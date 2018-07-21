package com.nincodedo.rpgcore.components.battle;

import com.nincodedo.rpgcore.components.attack.Attack;
import com.nincodedo.rpgcore.components.attack.AttackAction;
import com.nincodedo.rpgcore.components.attack.AttackResult;
import com.nincodedo.rpgcore.components.character.BattleCharacter;
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
        BattleCharacter enemy = setupEnemy();
        enemy.setSpeed(5);
        BattleCharacter enemy2 = setupEnemy();
        enemy2.setSpeed(10);
        enemy2.setName("enemy2");
        battle.addEnemies(enemy, enemy2);
        val turnOrder = battle.getTurnOrder();
        Assert.assertTrue(turnOrder.get(0).getName().equals("enemy2"));
    }

    @Test
    public void attacking() {
        Battle battle = new Battle();
        BattleCharacter player = setupPlayer();
        val attack = new Attack();
        attack.setAccuracy(100);
        attack.setName("wow");
        attack.setPhysicalAttack(true);
        attack.setPower(5);
        val attackList = Arrays.asList(attack);
        player.setAttackList(attackList);
        BattleCharacter enemy = setupEnemy();
        battle.addEnemies(enemy);
        val enemyHp = enemy.getCurrentHp();
        Optional<AttackResult> attackResult = battle.attack(player, player.getAttackByName("wow"), battle.getEnemies().get(0));
        val newEnemyHp = battle.getEnemies().get(0).getCurrentHp();
        Assert.assertTrue(enemyHp != newEnemyHp);
        if (attackResult.isPresent()) {
            Assert.assertEquals(AttackAction.HIT, attackResult.get().getAction());
        } else {
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
        player.setMagicAttack(random.nextInt(10));
        player.setMagicDefense(random.nextInt(10));
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
        enemy.setMagicAttack(random.nextInt(10));
        enemy.setMagicDefense(random.nextInt(10));
        enemy.setSpeed(random.nextInt(10));
        enemy.setLevel(1);
        return enemy;
    }
}
