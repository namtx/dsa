package dev.namtx.codewar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Crypto {
    Map<String, Double> prices = new HashMap<>();

    public static void main(String[] args) {
        String[] wallets = new String[]{
                "2 BTC",
                "32100 HEX",
                "100 SOL",
                "6.2 ETH",
                "0.2 BTC",
                "8 ETH",
                "0.2 BTC",
                "2 ETH",
                "5 ETH",
                "5.5 ETH",
                "36000 XRP",
                "0.05 BTC",
                "500 TRX",
                "12000 USDT",
                "0.25 ETH",
                "15000 DOGE",
                "64 DOT",
                "0.5 BTC",
                "3500 USDT",
                "2 ETH",
                "2700 ADA",
                "0.2 BTC",
                "0.25 ETH",
                "2100 HEX",
                "40000 DOGE",
                "24000 ADA",
                "50000 XRP",
                "500 TRX",
                "1.2 BTC",
                "124 DOT",
                "0.8 BTC",
                "28 DOT",
                "1 BTC",
                "80 SOL",
                "1 BTC"
        };
        String[] wallets2 = new String[]{"0.5 BTC", "15 ETH", "1000 DOGE", "0.4 BTC"};
        System.out.println(Arrays.deepToString(new double[][]{new Crypto().solve(wallets)}));
    }

    public double[] solve(String[] wallets) {
        prices.put("BTC", 22000.0);
        prices.put("ETH", 1200.0);
        prices.put("USDT", 1.0);
        prices.put("BNB", 230.0);
        prices.put("BUSD", 1.0);
        prices.put("XRP", 0.5);
        prices.put("ADA", 0.5);
        prices.put("SOL", 40.0);
        prices.put("HEX", 0.05);
        prices.put("DOGE", 0.05);
        prices.put("DOT", 8.0);
        prices.put("TRX", 0.06);

        double[] values = new double[wallets.length];
        double total = 0.0;
        for (int i = 0; i < wallets.length; i++) {
            String[] walletParts = wallets[i].split(" ");
            values[i] = Double.parseDouble(walletParts[0]) * prices.get(walletParts[1]);
            total += values[i];
        }

        double[][][] dp = new double[wallets.length][wallets.length][2];
        for (double[][] r : dp) {
            for (double[] rr: r) {
                Arrays.fill(rr, -1);
            }
        }
        minimax(values, dp, 0, wallets.length - 1, 0);
        System.out.println(Arrays.deepToString(dp));

        return new double[]{};
    }

    double minimax(double[] values, double[][][] dp, int i, int j, int turn) {
        if (i >= j) return 0;
        if (dp[i][j][turn] != -1) return dp[i][j][turn];

        double res = 0;
        if (turn == 0) {
            res = Math.max(
                values[i] + minimax(values, dp, i + 1, j, 1 - turn),
                values[j] + minimax(values, dp, i, j - 1, 1 - turn)
            );
        } else {
            res = Math.min(
                minimax(values, dp, i + 1, j, 1 - turn),
                minimax(values, dp, i, j - 1, 1 - turn)
            );
        }

        dp[i][j][turn] = res;
        return dp[i][j][turn];
    }
}
