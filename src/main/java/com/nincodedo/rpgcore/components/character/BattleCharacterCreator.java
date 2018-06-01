package com.nincodedo.rpgcore.components.character;

import java.util.Random;

public class BattleCharacterCreator {
    public Player createPlayer(String name, String id) {
        Player player = new Player();
        Random random = new Random(id.hashCode());
        player.setName(name);
        player.setHp(random.nextInt(10) + 5);
        player.setCurrentHp(player.getHp());
        player.setAttack(random.nextInt(10));
        player.setDefense(random.nextInt(10));
        player.setMagicAttack(random.nextInt(10));
        player.setMagicDefense(random.nextInt(10));
        player.setSpeed(random.nextInt(10));
        player.setLevel(1);
        return player;
    }

    public Enemy createEnemy(String name, String id) {
        Enemy enemy = new Enemy();
        Random random = new Random(id.hashCode());
        enemy.setName(name);
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
