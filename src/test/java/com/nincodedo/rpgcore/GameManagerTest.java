package com.nincodedo.rpgcore;

import com.nincodedo.rpgcore.components.GameManager;
import lombok.val;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.stream.Collectors;

public class GameManagerTest {

    @BeforeClass
    public static void setup() {
        GameManager.loadObjects();
    }

    @AfterClass
    public static void tearDown() {
        GameManager.clearObjects();
    }

    @Test
    public void testEnemyTemplate() {
        val enemyDateTemplateList = GameManager.getEnemyDataTemplateList();
        val skeleton = enemyDateTemplateList.stream().
                filter(enemyDataTemplate -> enemyDataTemplate.getName().equals("Skeleton")).collect(Collectors.toList()).get(0);
        Assert.assertEquals("attack", skeleton.getClassType().toLowerCase());
    }
}
