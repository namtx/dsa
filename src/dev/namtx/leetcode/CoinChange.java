package dev.namtx.leetcode;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{5, 2, 1}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE - 1;

            for (int coin : coins) {
                if (i == coin) {
                    dp[i] = 1;
                } else if (i < coin) {
                    break;
                } else {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE - 1) {
            return -1;
        }

        return dp[amount];
    }
}
