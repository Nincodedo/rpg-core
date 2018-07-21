package com.nincodedo.rpgcore.components.attack;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Attack")
public class Attack {
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "Power", nullable = false)
    private int power;
    @Column(name = "PhysicalAttack", nullable = false)
    private boolean isPhysicalAttack;
    @Column(name = "Accuracy", nullable = false)
    private int accuracy;
}
