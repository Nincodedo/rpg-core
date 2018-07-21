package com.nincodedo.rpgcore.components.character;

import lombok.Data;

import java.util.List;

@Data
public class EnemyDataTemplate {
    private String name;
    private List<StatFocus> statFocus;
    private String classType;
    private int rating;
}
