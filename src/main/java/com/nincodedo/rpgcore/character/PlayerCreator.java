package com.nincodedo.rpgcore.character;

import java.util.Random;

public class PlayerCreator {
    public Player createPlayer(String discordId, String name) {
        Player player = new Player();
        Random random = new Random(discordId.hashCode());
        player.setName(name);
        player.setHp(random.nextInt(10) + 5);
        player.setAttack(random.nextInt(10));
        player.setDefense(random.nextInt(10));
        player.setMagicAttack(random.nextInt(10));
        player.setMagicDefense(random.nextInt(10));
        player.setSpeed(random.nextInt(10));
        player.setLevel(1);
        player.setDiscordId(discordId);
        return player;
    }
}
