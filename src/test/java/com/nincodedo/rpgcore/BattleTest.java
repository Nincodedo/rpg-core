package com.nincodedo.rpgcore;

import com.nincodedo.rpgcore.character.Enemy;
import com.nincodedo.rpgcore.character.Player;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class BattleTest {

    Random random = new Random();

    @Test
    public void checkTurnOrder() {
        Battle battle = new Battle();
        Player player = setupPlayer();
        Enemy enemy = setupEnemy();
        player.setSpeed(10);
        enemy.setSpeed(5);
        battle.addPlayers(player);
        battle.addEnemies(enemy);
        val turnOrder = battle.getTurnOrder();
        Assert.assertTrue(turnOrder.get(0) instanceof Player);
    }

    private Player setupPlayer() {
        Player player = new Player();
        player.setHp(random.nextInt(10));
        player.setAttack(random.nextInt(10));
        player.setDefense(random.nextInt(10));
        player.setMagicAttack(random.nextInt(10));
        player.setMagicDefense(random.nextInt(10));
        player.setSpeed(random.nextInt(10));
        player.setLevel(1);
        return player;
    }

    private Enemy setupEnemy() {
        Enemy enemy = new Enemy();
        enemy.setHp(random.nextInt(10));
        enemy.setAttack(random.nextInt(10));
        enemy.setDefense(random.nextInt(10));
        enemy.setMagicAttack(random.nextInt(10));
        enemy.setMagicDefense(random.nextInt(10));
        enemy.setSpeed(random.nextInt(10));
        enemy.setLevel(1);
        return enemy;
    }
}
