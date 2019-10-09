package com.example.metropolismayor.mayorcore.income;

import com.example.metropolismayor.mayorcore.Player;

// Income interface. By implementing this various forms of income can be calculated for a single total.
public interface Income {
    int calculate(Player player);
}
