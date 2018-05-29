package com.nincodedo.rpgcore.character;

import lombok.Data;

@Data
public class Player extends BattleCharacter {
    private String discordId;

    @Override
    void doTurn() {

    }

    @Override
    public String toString() {
        return super.toString() + " discordID=" + discordId;
    }
}
