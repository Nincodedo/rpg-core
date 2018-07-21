package com.nincodedo.rpgcore.components.character;

import com.nincodedo.rpgcore.components.attack.Attack;
import com.nincodedo.rpgcore.components.item.Item;
import lombok.Data;
import lombok.val;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@Table(name = "BattleCharacter")
public class BattleCharacter implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "Level", nullable = false)
    private int level;
    @Column(name = "Hp", nullable = false)
    private int hp;
    @Column(name = "CurrentHp", nullable = false)
    private int currentHp;
    @Column(name = "Attack", nullable = false)
    private int attack;
    @Column(name = "Defense", nullable = false)
    private int defense;
    @Column(name = "MagicAttack", nullable = false)
    private int magicAttack;
    @Column(name = "MagicDefense", nullable = false)
    private int magicDefense;
    @Column(name = "Speed", nullable = false)
    private int speed;
    @Column(name = "Name", nullable = false)
    private String name;
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Item> inventory;
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Attack> attackList;
    @Column(name = "DiscordId")
    private String discordId;
    @Column(name = "CombatInstanceId")
    private String combatInstanceId;
    @Column(name = "Tier")
    private int tier;

    public BattleCharacter() {
        inventory = new ArrayList<>();
        attackList = new ArrayList<>();
        level = 1;
        tier = 1;
    }

    public Optional<Attack> getAttackByName(String attackName) {
        for (val namedAttack : attackList) {
            if (namedAttack.getName().equalsIgnoreCase(attackName)) {
                return Optional.of(namedAttack);
            }
        }
        return Optional.empty();
    }
}
