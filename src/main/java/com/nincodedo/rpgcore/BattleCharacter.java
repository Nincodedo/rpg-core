package com.nincodedo.rpgcore;

import lombok.Data;

import java.util.List;

@Data
public class BattleCharacter {
    private int level;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private String name;
    private List<Item> inventory;
    private List<Attack> attackList;
}
