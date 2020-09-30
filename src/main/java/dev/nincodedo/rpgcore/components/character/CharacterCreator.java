package dev.nincodedo.rpgcore.components.character;

import dev.nincodedo.rpgcore.components.GameManager;
import lombok.val;

import java.util.List;
import java.util.Random;

public class CharacterCreator {
    public Player createNewPlayer(String name,
            String characterClassName, String id) {
        Player player = new Player();
        player.setName(name);
        player.setInternalId(id);
        GameManager.loadObjects();
        val classMap = GameManager.getCharacterClassMap();
        player.setCharacterClass(characterClassName);
        Random random = new Random(Long.parseLong(player.getInternalId()));
        List<String> focusStat = classMap.get(characterClassName).getFocus();
        player.setHp(getBaseStat(random, 10, focusStat, "HP"));
        player.setCurrentHp(player.getHp());
        player.setAttack(getBaseStat(random, 5, focusStat, "ATTACK"));
        player.setDefense(getBaseStat(random, 5, focusStat, "DEFENSE"));
        player.setMagicAttack(getBaseStat(random, 5, focusStat, "MAGICATTACK"));
        player.setMagicDefense(getBaseStat(random, 5, focusStat, "MAGICDEFENSE"));
        player.setSpeed(getBaseStat(random, 5, focusStat, "SPEED"));
        return player;
    }

    private int getBaseStat(Random random, int baseState, List<String> focusStat, String currentStat) {
        return focusStat.contains(currentStat) ? (int) ((random.nextInt(baseState) + baseState) * 1.35) :
                random.nextInt(baseState) + baseState;
    }
}
