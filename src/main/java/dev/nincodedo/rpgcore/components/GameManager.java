package dev.nincodedo.rpgcore.components;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.nincodedo.rpgcore.components.character.CharacterClass;
import dev.nincodedo.rpgcore.components.character.Enemy;
import dev.nincodedo.rpgcore.components.item.Item;
import lombok.Data;
import lombok.Getter;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class GameManager {
    @Getter
    static List<Item> itemList;
    @Getter
    static List<Enemy> enemyList;
    @Getter
    static Map<String, CharacterClass> characterClassMap;

    public static void loadObjects() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            itemList = objectMapper.readValue(new File("src/main/resources/item-data.json"),
                    new TypeReference<List<Item>>() {
                    });
            enemyList = objectMapper.readValue(new File("src/main/resources/enemy-data.json"),
                    new TypeReference<List<Enemy>>() {
                    });
            List<CharacterClass> characterClasses = objectMapper.readValue(new File("src/main/resources/character"
                            + "-class.json"),
                    new TypeReference<List<CharacterClass>>() {
                    });
            characterClassMap = new HashMap<>();
            characterClasses.forEach(characterClass -> characterClassMap.put(characterClass.getName(), characterClass));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearObjects() {
        itemList.clear();
        enemyList.clear();
        characterClassMap.clear();
    }

    private static String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
