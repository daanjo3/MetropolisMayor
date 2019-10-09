package com.example.metropolismayor.mayorcore.cards;

import java.util.HashMap;

public class Card {
    public String name;
    public int cost;
    public HashMap<String, Integer> glyphSet = new HashMap<>();
    CardIncome income;


    public Card(String name, int cost, int glyphBlue, int glyphRed, int glyphGreen, CardIncome income) {
        this(name, cost, glyphBlue, glyphRed, glyphGreen);
        this.income = income;
    }

    public Card(String name, int cost, int glyphBlue, int glyphRed, int glyphGreen) {
        this(name, cost);
        this.glyphSet.put("blue", glyphBlue);
        this.glyphSet.put("red", glyphRed);
        this.glyphSet.put("green", glyphGreen);
        this.income = new CardIncome(0, 0);
    }

    public Card(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public CardIncome getIncome() {
        return income;
    }

    public int getGlyph(String color) {
        return glyphSet.get(color);
    }

    public String toString() {
        return String.format("--- %s ---\nCost: %d\nGlyphs: R%d B%d G%d\nIncome: %s\n---------\n",
                name, cost, glyphSet.get("blue"), glyphSet.get("red"), glyphSet.get("green"), income);
    }
}
