package com.nincodedo.rpgcore.components;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nincodedo.rpgcore.components.attack.Attack;
import com.nincodedo.rpgcore.components.character.EnemyDataTemplate;
import com.nincodedo.rpgcore.components.item.Item;
import lombok.Data;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Data
public class GameManager {
    @Getter
    static List<Item> itemList;
    @Getter
    static List<EnemyDataTemplate> enemyDataTemplateList;
    @Getter
    static List<Attack> attackList;

    public static void loadObjects() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            itemList = objectMapper.readValue(new File("src/main/resources/item-data.json"),
                    new TypeReference<List<Item>>() {
                    });
            enemyDataTemplateList = objectMapper.readValue(new File("src/main/resources/enemy-data.json"),
                    new TypeReference<List<EnemyDataTemplate>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearObjects() {
        itemList.clear();
        enemyDataTemplateList.clear();
        //attackList.clear();
    }
}
