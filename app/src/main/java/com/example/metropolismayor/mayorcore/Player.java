package com.example.metropolismayor.mayorcore;

import com.example.metropolismayor.mayorcore.cards.Card;

public class Player {
    public String name;
    public String id;
    public CardCollection hand;
    public boolean hasPlayed;

    public Player(String id, String name, CardCollection hand) {
        this.id = id;
        this.name = name;
        this.hand = hand;
        this.hasPlayed = false;
    }

    public void reset() {
        hasPlayed = false;
    }

    public void playCard(Card card) {
        hand.addCard(card);
        hasPlayed = false;
    }

    public int calculateMoneyIncome() {
        int total = 0;
        for (Card c : hand) {
            total += c.getIncome().getMoneyIncome(this);
        }
        return total;
    }

    public int calculateVictoryIncome() {
        int total = 0;
        for (Card c : hand) {
            total += c.getIncome().getVictoryIncome(this);
        }
        return total;
    }
}
