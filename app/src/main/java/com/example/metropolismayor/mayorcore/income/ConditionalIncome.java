package com.example.metropolismayor.mayorcore.income;

import com.example.metropolismayor.mayorcore.Game;
import com.example.metropolismayor.mayorcore.Player;

/**
 * Defines an income that is dependent on the presence of a building.
 * INCOME: if (card) then (amount)
 * These card can be in the players hand or in any players hand (depends).
 */
public class ConditionalIncome implements Income {
    int amount;
    String cardname;

    public ConditionalIncome(int amount, String cardname) {
        this.amount = amount;
        this.cardname = cardname;
    }

    @Override
    public int calculate(Player player) {
        if (cardname.equals("Universiteit")) {
            // If the card to watch is the university we want to know if it is globally present
            return Game.getInstance().isUniversiteit() ? amount : 0;
        } else {
            // Any other card must be in the players' hand
            return player.hand.contains(cardname) ? amount : 0;
        }
    }

    public String toString() {
        return String.format("%d if %s", amount, cardname);
    }
}
