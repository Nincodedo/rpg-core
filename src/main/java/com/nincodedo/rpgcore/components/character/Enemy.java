package com.nincodedo.rpgcore.components.character;

import lombok.Data;

@Data
public class Enemy extends BattleCharacter {
    private int id;
    private int tier;
}
