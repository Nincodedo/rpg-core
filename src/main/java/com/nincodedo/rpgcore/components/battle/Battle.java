package com.nincodedo.rpgcore.components.battle;

import com.nincodedo.rpgcore.components.attack.Attack;
import com.nincodedo.rpgcore.components.attack.AttackAction;
import com.nincodedo.rpgcore.components.attack.AttackResult;
import com.nincodedo.rpgcore.components.character.BattleCharacter;
import lombok.Data;
import lombok.val;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "Battle")
public class Battle {
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private int id;
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<BattleCharacter> enemies;
    @Column(name = "CurrentTurnId")
    private int currentCharacterTurnId;
    @Column(name = "InstanceId")
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
