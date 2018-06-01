package com.nincodedo.rpgcore.components.battle;

import com.nincodedo.rpgcore.components.attack.Attack;
import com.nincodedo.rpgcore.components.attack.AttackAction;
import com.nincodedo.rpgcore.components.attack.AttackResult;
import com.nincodedo.rpgcore.components.character.BattleCharacter;
import com.nincodedo.rpgcore.components.character.Enemy;
import com.nincodedo.rpgcore.components.character.Player;
import lombok.Data;
import lombok.val;

import java.util.*;

@Data
class Battle {
    private List<Enemy> enemies;
    private List<Player> players;
    private int currentCharacterTurnId;
    private int id;

    public Battle() {
        enemies = new ArrayList<>();
        players = new ArrayList<>();
    }

    List<BattleCharacter> getTurnOrder() {
        List<BattleCharacter> turnOrderList = new ArrayList<>();
        turnOrderList.addAll(enemies);
        turnOrderList.addAll(players);
        turnOrderList.sort(Comparator.comparingInt(BattleCharacter::getSpeed));
        Collections.reverse(turnOrderList);
        return turnOrderList;
    }

    void addPlayers(Player... player) {
        players.addAll(Arrays.asList(player));
    }

    void addEnemies(Enemy... enemy) {
        enemies.addAll(Arrays.asList(enemy));
    }

    public Optional<AttackResult> attack(BattleCharacter source, Optional<Attack> optionalAttack,
            BattleCharacter target) {
        if (optionalAttack.isPresent()) {
            val attack = optionalAttack.get();
            AttackResult attackResult = new AttackResult(source, attack, target);

            Random random = new Random();
            if (random.nextInt(100) + 1 <= attack.getAccuracy()) {
                int damageDone;
                if (attack.isPhysicalAttack()) {
                    damageDone = source.getAttack() - target.getDefense();
                } else {
                    damageDone = source.getMagicAttack() - target.getMagicDefense();
                }

                if (damageDone <= 0) {
                    damageDone = 1;
                }
                attackResult.setAction(AttackAction.HIT);
                attackResult.setDamage(damageDone);
                target.setCurrentHp(target.getCurrentHp() - damageDone);
            } else {
                attackResult.setAction(AttackAction.MISS);
                attackResult.setDamage(0);
            }
            return Optional.of(attackResult);
        }
        return Optional.empty();
    }
}
