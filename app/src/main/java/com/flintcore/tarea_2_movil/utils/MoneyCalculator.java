package com.flintcore.tarea_2_movil.utils;

import static com.flintcore.tarea_2_movil.utils.MoneyCalculator.Amounts.*;

public class MoneyCalculator {

    private static String[] EMPTY = new String[POSSIBLE_AMOUNTS_VALUES];

    protected interface Amounts {
        int POSSIBLE_AMOUNTS_VALUES = 5;
        int ZERO = 0;

        int HUNDRED = 100,
                FIFTY = 50,
                TWENTY = 20;
        float TEN_CENTS = .1f,
                FIVE_CENTS = .05f;

        int[] intsAmounts = {HUNDRED, FIFTY, TWENTY};
        float[] floatsAmounts = {TEN_CENTS, FIVE_CENTS};
    }

    private static MoneyCalculator moneyCalculator;

    private MoneyCalculator() {
    }

    public static MoneyCalculator getInstance() {
        if (moneyCalculator == null) {
            moneyCalculator = new MoneyCalculator();
        }

        return moneyCalculator;
    }

    public synchronized String[] getAmounts(long value) {
        String[] values = EMPTY;
//        If it empty or zero.
        if (value == 0L) {
            for (int index = 0; index < POSSIBLE_AMOUNTS_VALUES; index++) {
                values[index] = Long.toString(value);
            }

            return values;
        }

        int index = 0;
        for (int amount : intsAmounts) {
            long moneyPapers = value / amount;

            values[index++] = Long.toString(moneyPapers);

            value %= amount;
        }

        for (float amount : floatsAmounts) {
            long moneyPapers = (long) Math.floor(value / amount);

            values[index++] = Long.toString(moneyPapers);

            value %= amount;
        }

        return values;
    }


}
