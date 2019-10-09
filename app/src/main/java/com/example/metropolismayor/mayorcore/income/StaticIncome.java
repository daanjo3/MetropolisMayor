package com.example.metropolismayor.mayorcore.income;

import com.example.metropolismayor.mayorcore.Player;

/**
 * Defines a constant income
 * INCOME: (amount)
 */
public class StaticIncome implements Income {
    private int value;

    public StaticIncome(int value) {
        this.value = value;
    }

    @Override
    public int calculate(Player player) {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
