package dev.nincodedo.rpgcore.components.character;

import dev.nincodedo.rpgcore.components.GameManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CharacterCreatorTest {
    private CharacterCreator characterCreator = new CharacterCreator();

    @BeforeClass
    public static void setup() {
        GameManager.loadObjects();
    }

    @Test
    public void testPlayerCreator() {
        BattleCharacter nincodedo = characterCreator.createNewPlayer("Nincodedo", "wizard", "86958766125244416");
        System.out.println(nincodedo);
        Assert.assertEquals(1, nincodedo.getLevel());
        Assert.assertEquals(19, nincodedo.getHp());
    }
}