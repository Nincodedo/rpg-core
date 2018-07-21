package com.nincodedo.rpgcore.components.character;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum StatFocus {
    @JsonProperty("hp")
    HP,
    @JsonProperty("attack")
    ATTACK,
    @JsonProperty("defense")
    DEFENSE,
    @JsonProperty("spattack")
    MAGIC_ATTACK,
    @JsonProperty("spdefense")
    MAGIC_DEFENSE,
    @JsonProperty("speed")
    SPEED
}
