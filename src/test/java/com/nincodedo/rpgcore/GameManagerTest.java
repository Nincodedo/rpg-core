package com.nincodedo.rpgcore;

import com.nincodedo.rpgcore.components.GameManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class GameManagerTest {

    @BeforeClass
    public static void setup() {
        GameManager.loadObjects();
    }

    @AfterClass
    public static void tearDown() {
        GameManager.clearObjects();
    }

}
