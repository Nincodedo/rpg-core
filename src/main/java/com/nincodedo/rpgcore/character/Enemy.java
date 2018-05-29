package com.nincodedo.rpgcore.character;

import lombok.Data;

@Data
public class Enemy extends BattleCharacter {
    private int id;
    private int tier;

    @Override
    void doTurn() {

    }
}
