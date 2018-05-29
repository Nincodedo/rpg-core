package com.nincodedo.rpgcore.character;

import com.nincodedo.rpgcore.Attack;
import com.nincodedo.rpgcore.AttackResult;
import com.nincodedo.rpgcore.Item;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public abstract class BattleCharacter {
    private int id;
    private int level;
    private int hp;
    private int attack;
    private int defense;
    private int magicAttack;
    private int magicDefense;
    private int speed;
    private String name;
    private List<Item> inventory;
    private List<Attack> attackList;

    public BattleCharacter() {
        inventory = new ArrayList<>();
        attackList = new ArrayList<>();
    }

    AttackResult useAttack(Attack attack, BattleCharacter target) {
        AttackResult attackResult = new AttackResult(this, attack, target);
        Random random = new Random();
        if (random.nextInt(100) + 1 <= attack.getAccuracy()) {
            int damageDone;
            if (attack.isPhysicalAttack()) {
                damageDone = this.attack - target.getDefense();
            } else {
                damageDone = this.magicAttack - target.getMagicDefense();
            }

            if (damageDone <= 0) {
                damageDone = 1;
            }
            attackResult.setAction("HIT");
            attackResult.setDamage(damageDone);
            target.setHp(target.getHp() - damageDone);
        } else {
            attackResult.setAction("MISS");
            attackResult.setDamage(0);
        }
        return attackResult;
    }

    abstract void doTurn();
}
