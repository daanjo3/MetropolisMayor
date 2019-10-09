package com.example.metropolismayor.mayorcore.cards;

import com.example.metropolismayor.mayorcore.Player;
import com.example.metropolismayor.mayorcore.income.Income;
import com.example.metropolismayor.mayorcore.income.StaticIncome;


public class CardIncome {
    private Income baseIncomeMoney;
    private Income baseIncomeVictory;
    private Income bonusIncomeMoney;
    private Income bonusIncomeVictory;

    // Public constructor for static base income and complex bonus income
    public CardIncome(int staticMoney, int staticVictory, Income bonusIncomeMoney, Income bonusIncomeVictory) {
        this(bonusIncomeMoney, bonusIncomeVictory);
        this.baseIncomeMoney = staticMoney > 0 ? new StaticIncome(staticMoney) : null;
        this.baseIncomeVictory = staticVictory > 0 ? new StaticIncome(staticVictory) : null;
    }

    // Public constructor for complex base and bonus income
    public CardIncome(Income baseIncomeMoney, Income baseIncomeVictory, Income bonusIncomeMoney, Income bonusIncomeVictory) {
        this(bonusIncomeMoney, bonusIncomeVictory);
        this.baseIncomeMoney = baseIncomeMoney;
        this.baseIncomeVictory = baseIncomeVictory;
    }

    //Public constructor when only static income is necessary
    public CardIncome(int staticMoney, int staticVictory) {
        this(null, null);
        this.baseIncomeMoney = staticMoney > 0 ? new StaticIncome(staticMoney) : null;
        this.baseIncomeVictory = staticVictory > 0 ? new StaticIncome(staticVictory) : null;
    }

    //Private constructor to handle bonus income
    private CardIncome(Income bonusIncomeMoney, Income bonusIncomeVictory) {
        this.bonusIncomeMoney = bonusIncomeMoney;
        this.bonusIncomeVictory = bonusIncomeVictory;
    }

    public int getMoneyIncome(Player player) {
        int total = 0;
        if (baseIncomeMoney != null) {
            total += baseIncomeMoney.calculate(player);
        }
        if (bonusIncomeMoney != null) {
            total += bonusIncomeMoney.calculate(player);
        }
        return total;
    }

    public int getVictoryIncome(Player player) {
        int total = 0;
        if (baseIncomeVictory != null) {
            total += baseIncomeVictory.calculate(player);
        }
        if (bonusIncomeVictory != null) {
            total += bonusIncomeVictory.calculate(player);
        }
        return total;
    }

    public String toString() {
        String outStr = "";
        if (baseIncomeMoney != null) {
            outStr = outStr.concat(String.format("BaM:%s\t", baseIncomeMoney));
        }
        if (baseIncomeVictory != null) {
            outStr = outStr.concat(String.format("BaV:%s\t", baseIncomeVictory));
        }
        if (bonusIncomeMoney != null) {
            outStr = outStr.concat(String.format("BoM:%s\t", bonusIncomeMoney));
        }
        if (bonusIncomeVictory != null) {
            outStr = outStr.concat(String.format("BoV:%s", bonusIncomeVictory));
        }
        return outStr;
    }
}
