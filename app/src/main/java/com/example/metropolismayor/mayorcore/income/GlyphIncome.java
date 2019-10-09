package com.example.metropolismayor.mayorcore.income;

import com.example.metropolismayor.mayorcore.Game;
import com.example.metropolismayor.mayorcore.Player;

/**
 * Defines an income based on the amount of glyphs
 * INCOME: (amountGlyphs)
 */
public class GlyphIncome implements Income {
    String glyphColor;

    public GlyphIncome(String color) {
        glyphColor = color;
    }

    // Currently not working for all or 1other
    @Override
    public int calculate(Player player) {
        if (player != null) {
            return Game.getInstance().getGlyphCount(player.id, glyphColor);
        } else {
            return Game.getInstance().getGlyphCount(null, glyphColor);
        }
    }

    @Override
    public String toString() {
        return String.format("#[Glyph %s]", glyphColor);
    }
}
