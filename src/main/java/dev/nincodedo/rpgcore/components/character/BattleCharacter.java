package dev.nincodedo.rpgcore.components.character;

import lombok.Data;

@Data
public class BattleCharacter {

    private int level;
    private int hp;
    private int currentHp;
    private int attack;
    private int defense;
    private int magicAttack;
    private int magicDefense;
    private int speed;
    private String name;
    private String internalId;
    private String characterClass;

    public BattleCharacter() {
        level = 1;
    }
}
