package com.nincodedo.rpgcore;

import com.nincodedo.rpgcore.character.BattleCharacter;
import com.nincodedo.rpgcore.character.Enemy;
import com.nincodedo.rpgcore.character.Player;
import lombok.Data;

import java.util.*;

@Data
class Battle {
    private List<Enemy> enemies;
    private List<Player> players;
    private int currentCharacterTurnId;
    private int id;

    public Battle() {
        enemies = new ArrayList<>();
        players = new ArrayList<>();
    }

    List<BattleCharacter> getTurnOrder() {
        List<BattleCharacter> turnOrderList = new ArrayList<>();
        turnOrderList.addAll(enemies);
        turnOrderList.addAll(players);
        turnOrderList.sort(Comparator.comparingInt(BattleCharacter::getSpeed));
        Collections.reverse(turnOrderList);
        return turnOrderList;
    }

    void addPlayers(Player... player) {
        players.addAll(Arrays.asList(player));
    }

    void addEnemies(Enemy... enemy) {
        enemies.addAll(Arrays.asList(enemy));
    }
}
