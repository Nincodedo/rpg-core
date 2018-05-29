package com.nincodedo.rpgcore;

import com.nincodedo.rpgcore.character.Player;
import com.nincodedo.rpgcore.character.PlayerCreator;
import org.junit.Assert;
import org.junit.Test;

public class PlayerCreatorTest {
    @Test
    public void testPlayerCreator() {
        PlayerCreator playerCreator = new PlayerCreator();
        Player nincodedo = playerCreator.createPlayer("86958766125244416", "Nincodedo");
        System.out.println(nincodedo);
        Assert.assertEquals("", 1, nincodedo.getLevel());
        Assert.assertEquals("", 9, nincodedo.getHp());
    }
}
