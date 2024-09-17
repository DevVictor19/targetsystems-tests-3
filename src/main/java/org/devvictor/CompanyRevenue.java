package org.devvictor;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class CompanyRevenue {
    public static void main(String[] args) {
        double[] yearDailyRevenue = { 1500.00, 2000.23, 34303.3, 4321.4, 5303.5, 00.00, 00.00 };
        double[] validRevenueDays = getValidRevenueDays(yearDailyRevenue);

        double lowerRevenueAmount = validRevenueDays[0];
        double higherRevenueAmount = validRevenueDays[0];
        double yearDailyRevenueAverage = getRevenueDaysAverage(validRevenueDays);
        int daysOfDailyRevenueHigherYearDailyRevenueAverage = 0;

        for (int i = 0; i < validRevenueDays.length; i++) {
            if (validRevenueDays[i] < lowerRevenueAmount) {
                lowerRevenueAmount = validRevenueDays[i];
            } else if (validRevenueDays[i] > higherRevenueAmount) {
                higherRevenueAmount = validRevenueDays[i];
            }

            if (validRevenueDays[i] > yearDailyRevenueAverage) {
                daysOfDailyRevenueHigherYearDailyRevenueAverage++;
            }
        }

        System.out.format("Valor do maior faturamento: %.2f %n", higherRevenueAmount);
        System.out.format("Valor do menor faturamento: %.2f %n", lowerRevenueAmount);
        System.out.format("Número de dias no ano em que o valor de faturamento diário foi superior à média anual: %d",
                daysOfDailyRevenueHigherYearDailyRevenueAverage);
    }

    public static double[] getValidRevenueDays(double[] revenueDays) {
        return Arrays.stream(revenueDays)
                .filter((rev) -> rev > 0)
                .toArray();
    }

    public static double getRevenueDaysAverage(double[] revenueDays) {
        double sum = Arrays.stream(revenueDays).sum();
        return sum / revenueDays.length;
    }
}
