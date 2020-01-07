package com.nincodedo.rpgcore.components.attack;

import com.nincodedo.rpgcore.components.character.BattleCharacter;
import lombok.Data;

@Data
public class AttackResult {
    private int damage;
    private BattleCharacter source;
    private BattleCharacter target;

    public AttackResult(BattleCharacter source, BattleCharacter target) {
        this.source = source;
        this.target = target;
    }
}
