package com.example.metropolismayor.mayorcore.income;

import com.example.metropolismayor.mayorcore.Game;
import com.example.metropolismayor.mayorcore.Player;

/**
 * Defines an income based on the amount of present buildings of a particular kind.
 * INCOME: (multiplier) * (card)
 * These card can be in the players hand or in any players hand (depends)
 */
public class BuildingIncome implements Income {
    String cardName;
    int multiplier;

    public BuildingIncome(String cardName, int multiplier) {
        this.cardName = cardName;
        this.multiplier = multiplier;
    }

    @Override
    public int calculate(Player player) {
        if (cardName.equals("Klaverblad")) {
            // The klaverblad has to be searched globally
            return Game.getInstance().getKlaverbladCount() * multiplier;
        } else if (cardName.equals("School")) {
            // Just like the school
            return Game.getInstance().getSchoolCount();
        } else {
            // All other cards must be present in the current players' collection
            return player.hand.countCardOccurence(cardName) * multiplier;
        }
    }

    public String toString() {
        return String.format("%d * [%s]", multiplier, cardName);
    }
}
