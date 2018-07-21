package com.nincodedo.rpgcore.components.character;

import com.nincodedo.rpgcore.components.GameManager;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BattleCharacterCreatorTest {

    private BattleCharacterCreator battleCharacterCreator = new BattleCharacterCreator();

    @Test
    public void testPlayerCreator() {

        BattleCharacter nincodedo = battleCharacterCreator.createNewPlayer("Nincodedo", "86958766125244416");
        System.out.println(nincodedo);
        Assert.assertEquals(1, nincodedo.getLevel());
        Assert.assertEquals(9, nincodedo.getHp());
    }

    @Test
    public void testEnemyCreator() {
        GameManager.loadObjects();
        val enemyTemplateList = GameManager.getEnemyDataTemplateList();
        List<BattleCharacter> enemies = new ArrayList<>();
        enemyTemplateList.forEach(enemyDataTemplate -> enemies.add(battleCharacterCreator.createEnemy(enemyDataTemplate, 1)));
        System.out.println();
        System.out.println(enemies);
        GameManager.clearObjects();
    }
}
