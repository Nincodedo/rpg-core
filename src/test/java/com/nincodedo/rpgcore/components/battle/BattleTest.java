package com.nincodedo.rpgcore.components.battle;

import com.nincodedo.rpgcore.components.attack.Attack;
import com.nincodedo.rpgcore.components.attack.AttackAction;
import com.nincodedo.rpgcore.components.attack.AttackResult;
import com.nincodedo.rpgcore.components.character.Enemy;
import com.nincodedo.rpgcore.components.character.Player;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class BattleTest {

    private Random random = new Random();

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

    @Test
    public void attacking() {
        Battle battle = new Battle();
        Player player = setupPlayer();
        val attack = new Attack();
        attack.setAccuracy(100);
        attack.setName("wow");
        attack.setPhysicalAttack(true);
        attack.setPower(5);
        val attackList = Arrays.asList(attack);
        player.setAttackList(attackList);
        Enemy enemy = setupEnemy();
        battle.addPlayers(player);
        battle.addEnemies(enemy);
        val enemyHp = enemy.getCurrentHp();
        val turnOrder = battle.getTurnOrder();
        Optional<AttackResult> attackResult = Optional.empty();
        for (val character : turnOrder) {
            if (character instanceof Player) {
                attackResult = battle.attack(character, character.getAttackByName("wow"), enemy);
            }
        }
        val newEnemyHp = battle.getEnemies().get(0).getCurrentHp();
        Assert.assertTrue(enemyHp != newEnemyHp);
        if (attackResult.isPresent()) {
            Assert.assertEquals(AttackAction.HIT, attackResult.get().getAction());
        } else {
            Assert.fail();
        }
    }

    private Player setupPlayer() {
        Player player = new Player();
        player.setHp(random.nextInt(10));
        player.setCurrentHp(player.getHp());
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
        enemy.setCurrentHp(enemy.getHp());
        enemy.setAttack(random.nextInt(10));
        enemy.setDefense(random.nextInt(10));
        enemy.setMagicAttack(random.nextInt(10));
        enemy.setMagicDefense(random.nextInt(10));
        enemy.setSpeed(random.nextInt(10));
        enemy.setLevel(1);
        return enemy;
    }
}
