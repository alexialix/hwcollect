package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> registeredPlayers = new ArrayList<>();

    public void register(Player player) {
        registeredPlayers.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("One of the players is not registered.");
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1; // Первый игрок выиграл
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2; // Второй игрок выиграл
        } else {
            return 0; // Ничья
        }
    }

    private Player findByName(String playerName) {
        for (Player player : registeredPlayers) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

    public List<Player> getRegisteredPlayers() {
        return registeredPlayers;
    }
}
