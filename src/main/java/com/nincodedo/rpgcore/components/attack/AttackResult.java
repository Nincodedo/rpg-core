package com.nincodedo.rpgcore.components.attack;

import com.nincodedo.rpgcore.components.character.BattleCharacter;
import lombok.Data;

@Data
public class AttackResult {
    private int damage;
    private AttackAction action;
    private BattleCharacter source;
    private Attack attack;
    private BattleCharacter target;

    public AttackResult(BattleCharacter source, Attack attack, BattleCharacter target) {
        this.source = source;
        this.attack = attack;
        this.target = target;
    }
}
