package com.nincodedo.rpgcore.components.character;

import lombok.val;

import java.util.Random;

public class BattleCharacterCreator {
    public BattleCharacter createNewPlayer(String name, String id) {
        BattleCharacter player = new BattleCharacter();
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
        player.setDiscordId(id);
        return player;
    }

    public BattleCharacter createEnemy(String name) {
        return createEnemy(name, name);
    }

    public BattleCharacter createEnemy(String name, String id) {
        BattleCharacter enemy = new BattleCharacter();
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

    public BattleCharacter createEnemy(EnemyDataTemplate enemyDataTemplate, int tier) {
        BattleCharacter enemy = new BattleCharacter();
        Random random = new Random();
        enemy.setName(enemyDataTemplate.getName());
        val rating = enemyDataTemplate.getRating();
        val multiplier = rating * (random.nextInt(rating * 10) + rating);
        enemy.setHp(random.nextInt(multiplier) + rating + addStatFocus(StatFocus.HP, enemyDataTemplate));
        enemy.setAttack(random.nextInt(multiplier) + rating + addStatFocus(StatFocus.ATTACK, enemyDataTemplate));
        enemy.setDefense(random.nextInt(multiplier) + rating + addStatFocus(StatFocus.DEFENSE, enemyDataTemplate));
        enemy.setMagicAttack(
                random.nextInt(multiplier) + rating + addStatFocus(StatFocus.MAGIC_ATTACK, enemyDataTemplate));
        enemy.setMagicDefense(
                random.nextInt(multiplier) + rating + addStatFocus(StatFocus.MAGIC_DEFENSE, enemyDataTemplate));
        enemy.setSpeed(random.nextInt(multiplier) + rating + addStatFocus(StatFocus.SPEED, enemyDataTemplate));
        return enemy;
    }

    private int addStatFocus(StatFocus stat, EnemyDataTemplate enemyDataTemplate) {
        return enemyDataTemplate.getStatFocus().contains(stat) ? enemyDataTemplate.getRating() / 2 : 0;
    }
}
