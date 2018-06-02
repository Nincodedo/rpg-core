package com.nincodedo.rpgcore.components;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nincodedo.rpgcore.components.attack.Attack;
import com.nincodedo.rpgcore.components.character.Enemy;
import com.nincodedo.rpgcore.components.item.Item;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Data
public class GameManager {
    static List<Item> itemList;
    static List<Enemy> enemyList;
    static List<Attack> attackList;

    public static void loadItems() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            itemList = objectMapper.readValue(new File("src/main/resources/item-data.json"),
                    new TypeReference<List<Item>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
