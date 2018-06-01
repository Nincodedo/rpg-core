package com.nincodedo.rpgcore.components.character;

import com.nincodedo.rpgcore.Item;
import com.nincodedo.rpgcore.components.attack.Attack;
import lombok.Data;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class BattleCharacter {
    private int id;
    private int level;
    private int hp;
    private int currentHp;
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

    public Optional<Attack> getAttackByName(String attackName) {
        for (val namedAttack : attackList) {
            if (namedAttack.getName().equalsIgnoreCase(attackName)) {
                return Optional.of(namedAttack);
            }
        }
        return Optional.empty();
    }
}
