package com.example.metropolismayor.mayorcore;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private static Game instance = new Game();
    private int turnCount;

    private Game() {
        turnCount = 0;
    }

    public static Game getInstance() {
        return instance;
    }

    // --- Player Turns ---
    public boolean hasAllPlayed() {
        for (Player player: players.getPlayers().values()) {
            if (!player.hasPlayed) {
                return false;
            }
        }
        return true;
    }

    // --- Global Buildings ---
    private int klaverbladCount = 0;
    private boolean universiteit = false;
    private int schoolCount = 0;

    public boolean isUniversiteit() {
        return universiteit;
    }

    public int getSchoolCount() {
        return schoolCount;
    }

    public int getKlaverbladCount() {
        return klaverbladCount;
    }

    // --- Players ---
    private PlayerList players;

    public int getGlyphCount(String playerId, String color) {
        return players.getPlayer(playerId).hand.countGlyphs(color);
    }

    public void setPlayerList(HashMap<String, Player> players) {
        this.players = new PlayerList(players);
    }

    public PlayerList getPlayerList() {
        return players;
    }
}
