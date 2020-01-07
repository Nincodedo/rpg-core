package com.nincodedo.rpgcore.components.battle;

import com.nincodedo.rpgcore.components.attack.AttackResult;
import com.nincodedo.rpgcore.components.character.BattleCharacter;
import lombok.Data;

import java.util.*;

@Data

public class Battle {

    private List<BattleCharacter> enemies;
    private int currentCharacterTurnId;
    private String instanceId;


    public Battle() {
        enemies = new ArrayList<>();
    }

    List<BattleCharacter> getTurnOrder() {
        List<BattleCharacter> turnOrderList = new ArrayList<>();
        turnOrderList.addAll(enemies);
        turnOrderList.sort(Comparator.comparingInt(BattleCharacter::getSpeed));
        Collections.reverse(turnOrderList);
        return turnOrderList;
    }

    public void addEnemies(BattleCharacter... enemy) {
        enemies.addAll(Arrays.asList(enemy));
    }

    public Optional<AttackResult> attack(BattleCharacter source, BattleCharacter target) {
        AttackResult attackResult = new AttackResult(source, target);

        int damageDone = source.getAttack() - target.getDefense();

        if (damageDone <= 0) {
            damageDone = 1;
        }
        attackResult.setDamage(damageDone);
        target.setCurrentHp(target.getCurrentHp() - damageDone);

        return Optional.of(attackResult);
    }
}
