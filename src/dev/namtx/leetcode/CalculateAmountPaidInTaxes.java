package dev.namtx.leetcode;

public class CalculateAmountPaidInTaxes {
    public static void main(String[] args) {
        System.out.println(new CalculateAmountPaidInTaxes().calculateTax(new int[][]{{2, 7}, {3, 17}, {4, 37}, {7, 6}, {9, 83}, {16, 67}, {19, 29}}, 18));
    }

    public double calculateTax(int[][] brackets, int income) {
        int currentBracket = 0;
        int currentIncome = 0;
        double taxes = 0;
        while (income > brackets[currentBracket][0]) {
            taxes += (double) (brackets[currentBracket][0] - currentIncome) * brackets[currentBracket][1] / 100;
            currentIncome = brackets[currentBracket][0];
            currentBracket++;
        }
        if (income == currentIncome) return taxes;
        taxes += (double) (income - currentIncome) * brackets[currentBracket][1] / 100;

        return taxes;
    }
}
