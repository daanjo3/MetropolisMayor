package com.example.metropolismayor.mayorcore.cards;

import com.example.metropolismayor.mayorcore.CardCollection;
import com.example.metropolismayor.mayorcore.income.ConditionalIncome;
import com.example.metropolismayor.mayorcore.income.GlyphIncome;

import java.util.*;

public class CardFactory {

    public static Card createParkeergarage() {
        return new Card("Parkeergarage", 0, 1, 1, 1);
    }

    public static Card createRijtjeshuis() {
        CardIncome income = new CardIncome(0, 1);
        return new Card("Rijtjeshuis", 1, 1, 0, 0, income);
    }

    public static Card createIndustriepark() {
        CardIncome income = new CardIncome(1, 0, new ConditionalIncome(1, "Onderzoekcentrum"), null);
        return new Card("Industriepark", 1, 0, 0, 0, income);
    }

    public static Card createWinkelstraat() {
        CardIncome income = new CardIncome(1, 0);
        return new Card("Winkelstraat", 1, 0, 1, 1, income);
    }

    public static Card createBusstation() {
        CardIncome income = new CardIncome(0, 1, new ConditionalIncome(1, "Winkelstraat"), null);
        return new Card("Busstation", 1, 1, 0, 1, income);
    }

    public static Card createRestaurant() {
        CardIncome income = new CardIncome(0, 1, new ConditionalIncome(1, "Zakencentrum"), null);
        return new Card("Restaurant", 1, 1, 0, 1, income);
    }

    public static Card createSchool() {
        CardIncome income = new CardIncome(0, 2);
        return new Card("School", 1, 0, 0, 0, income);
    }

    public static Card createWoonhuis() {
        CardIncome income = new CardIncome(1, 0);
        return new Card("Woonhuis", 1, 0, 0, 0, income);
    }

    public static Card createWoonwijk() {
        CardIncome income = new CardIncome(0, 1);
        return new Card("Woonwijk", 1, 0, 1, 1, income);
    }

    public static Card createPark() {
        CardIncome income = new CardIncome(null, new GlyphIncome("blue"), null, null);
        return new Card("Park", 1, 1, 0, 0, income);
    }

    public static CardCollection getNRandomCard(int n) {
        CardCollection randomCards = new CardCollection();
        for(int k = 0; k < n; k++) {
            randomCards.add(getRandomCard());
        }
        return randomCards;
    }

    public static Card getRandomCard() {
        Random random = new Random();
        switch(random.nextInt(10)) {
            case 0:
                return createParkeergarage();
            case 1:
                return createRijtjeshuis();
            case 2:
                return createIndustriepark();
            case 3:
                return createWinkelstraat();
            case 4:
                return createBusstation();
            case 5:
                return createRestaurant();
            case 6:
                return createSchool();
            case 7:
                return createWoonhuis();
            case 8:
                return createWoonwijk();
            case 9:
                return createPark();
        }
        return null;
    }

    public static final List<String> INDEX = new ArrayList<>(Arrays.asList(
            "Parkeergarage",
            "Rijtjeshuis",
            "Industriepark",
            "Winkelstraat",
            "Busstation",
            "Restaurant",
            "School",
            "Woonhuis",
            "Woonwijk",
            "Park"
    ));
}
