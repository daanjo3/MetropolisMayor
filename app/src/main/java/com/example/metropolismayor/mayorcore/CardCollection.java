package com.example.metropolismayor.mayorcore;

import com.example.metropolismayor.mayorcore.cards.Card;

import java.util.ArrayList;

public class CardCollection extends ArrayList<Card> {

    public CardCollection() {}

    public CardCollection(ArrayList<Card> inCards) {
        super(inCards);
    }

    public void addCard(Card card) {
        this.add(card);
    }

    public boolean contains(String cardname) {
        for (Card card: this) {
            if (card.name.equals(cardname)) {
                return true;
            }
        }
        return false;
    }

    public int countCardOccurence(String cardname) {
        int count = 0;
        for (Card c: this) {
            if (c.name.equals(cardname)) {
                count++;
            }
        }
        return count;
    }

    public int countGlyphs(String color) {
        int count = 0;
        for(Card card: this) {
            count += card.getGlyph(color);
        }
        return count;
    }

    @Override
    public String toString() {
        String outStr = "";
        for(Card card : this) {
            outStr = outStr.concat(card.toString());
            outStr = outStr.concat("\n");
        }
        return outStr;
    }
}
