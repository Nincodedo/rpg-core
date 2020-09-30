package dev.nincodedo.rpgcore.components.battle;

import dev.nincodedo.rpgcore.components.attack.AttackResult;
import dev.nincodedo.rpgcore.components.character.BattleCharacter;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.Random;

public class BattleTest {

    private Random random = new Random();

    @Test
    public void checkTurnOrder() {
        Battle battle = new Battle();
        BattleCharacter enemy = setupEnemy();
        enemy.setSpeed(5);
        BattleCharacter enemy2 = setupEnemy();
        enemy2.setSpeed(10);
        enemy2.setName("enemy2");
        battle.addEnemies(enemy, enemy2);
        val turnOrder = battle.getTurnOrder();
        Assert.assertEquals("enemy2", turnOrder.get(0).getName());
    }

    @Test
    public void attacking() {
        Battle battle = new Battle();
        BattleCharacter player = setupPlayer();
        BattleCharacter enemy = setupEnemy();
        battle.addEnemies(enemy);
        val enemyHp = enemy.getCurrentHp();
        Optional<AttackResult> attackResult = battle.attack(player, battle.getEnemies().get(0));
        val newEnemyHp = battle.getEnemies().get(0).getCurrentHp();
        Assert.assertTrue(enemyHp != newEnemyHp);
        if (!attackResult.isPresent()) {
            Assert.fail();
        }
    }

    private BattleCharacter setupPlayer() {
        BattleCharacter player = new BattleCharacter();
        player.setName("player");
        player.setHp(random.nextInt(10));
        player.setCurrentHp(player.getHp());
        player.setAttack(random.nextInt(10));
        player.setDefense(random.nextInt(10));
        player.setSpeed(random.nextInt(10));
        player.setLevel(1);
        return player;
    }

    private BattleCharacter setupEnemy() {
        BattleCharacter enemy = new BattleCharacter();
        enemy.setName("enemy");
        enemy.setHp(random.nextInt(10));
        enemy.setCurrentHp(enemy.getHp());
        enemy.setAttack(random.nextInt(10));
        enemy.setDefense(random.nextInt(10));
        enemy.setSpeed(random.nextInt(10));
        enemy.setLevel(1);
        return enemy;
    }
}
