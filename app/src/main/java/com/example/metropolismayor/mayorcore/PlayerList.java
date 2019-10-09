package com.example.metropolismayor.mayorcore;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerList {
    private HashMap<String, Player> players;

    public PlayerList(HashMap<String, Player> players) {
        this.players = players;
    }

    public ArrayList<String> getPlayerIds() {
        return new ArrayList<>(players.keySet());
    }

    public ArrayList<String> getPlayerNames() {
        ArrayList<String> playerNames = new ArrayList<>();
        for (Player player: players.values()) {
            playerNames.add(player.name);
        }
        return playerNames;
    }

    public Player getPlayer(String playerId) {
        return players.get(playerId);
    }

    public HashMap<String, Player> getPlayers() {
        return players;
    }
}
