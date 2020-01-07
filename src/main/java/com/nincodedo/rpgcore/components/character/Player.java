package com.nincodedo.rpgcore.components.character;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rpgcore-player")
public class Player extends BattleCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    public Player() {
        super();
    }
}
