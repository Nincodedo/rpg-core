package com.nincodedo.rpgcore.components.character;

import com.nincodedo.rpgcore.components.GameManager;
import lombok.val;

import java.util.List;
import java.util.Random;

public class CharacterCreator {
    public BattleCharacter createNewPlayer(String name,
            String characterClassName, String id) {
        BattleCharacter battleCharacter = new BattleCharacter();
        battleCharacter.setName(name);
        battleCharacter.setInternalId(id);
        val classMap = GameManager.getCharacterClassMap();
        battleCharacter.setCharacterClass(characterClassName);
        Random random = new Random(Long.parseLong(battleCharacter.getInternalId()));
        List<String> focusStat = classMap.get(characterClassName).getFocus();
        battleCharacter.setHp(getBaseStat(random, 10, focusStat, "HP"));
        battleCharacter.setCurrentHp(battleCharacter.getHp());
        battleCharacter.setAttack(getBaseStat(random, 5, focusStat, "ATTACK"));
        battleCharacter.setDefense(getBaseStat(random, 5, focusStat, "DEFENSE"));
        battleCharacter.setMagicAttack(getBaseStat(random, 5, focusStat, "MAGICATTACK"));
        battleCharacter.setMagicDefense(getBaseStat(random, 5, focusStat, "MAGICDEFENSE"));
        battleCharacter.setSpeed(getBaseStat(random, 5, focusStat, "SPEED"));
        return battleCharacter;
    }

    private int getBaseStat(Random random, int baseState, List<String> focusStat, String currentStat) {
        return focusStat.contains(currentStat) ? (int) ((random.nextInt(baseState) + baseState) * 1.35) :
                random.nextInt(baseState) + baseState;
    }
}
