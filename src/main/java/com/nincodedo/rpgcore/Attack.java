package com.nincodedo.rpgcore;

import lombok.Data;

@Data
public class Attack {
    private String name;
    private int power;
    private boolean isPhysicalAttack;
    private int accuracy;
}
