package com.nincodedo.rpgcore.components.character;

import lombok.Data;

import java.util.List;

@Data
public class CharacterClass {
    private String name;
    private List<String> focus;
}
