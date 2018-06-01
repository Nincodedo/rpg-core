package com.nincodedo.rpgcore.components.character;

import org.junit.Assert;
import org.junit.Test;

public class BattleCharacterCreatorTest {
    @Test
    public void testPlayerCreator() {
        BattleCharacterCreator battleCharacterCreator = new BattleCharacterCreator();
        Player nincodedo = battleCharacterCreator.createPlayer("Nincodedo", "86958766125244416");
        Assert.assertEquals(1, nincodedo.getLevel());
        Assert.assertEquals(9, nincodedo.getHp());
    }
}
