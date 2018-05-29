package com.nincodedo.rpgcore;

import com.nincodedo.rpgcore.character.BattleCharacter;
import lombok.Data;

@Data
public class AttackResult {
    private int damage;
    private String action;
    private BattleCharacter source;
    private Attack attack;
    private BattleCharacter target;

    public AttackResult(BattleCharacter source, Attack attack, BattleCharacter target) {
        this.source = source;
        this.attack = attack;
        this.target = target;
    }
}
