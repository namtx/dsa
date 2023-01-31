package dev.namtx.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class BestTeamWithNoConflicts {
    class Player {
        int age;
        int score;
        Player(int age, int score) {
            this.age = age;
            this.score = score;
        }
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        Player[] players = new Player[scores.length];

        for (int i = 0; i < scores.length; i++) {
            players[i] = new Player(ages[i], scores[i]);
        }

        Arrays.sort(players, (o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.score - o2.score;
            } else return o1.age - o2.age;
        });
        int[] dp = new int[scores.length];
        dp[0] = players[0].score;

        for (int i = 1; i < scores.length; i++) {
            int max = players[i].score;
            for (int j = 0; j < i; j++) {
                if (players[j].score <= players[i].score) {
                    max = Math.max(max, dp[j] + players[i].score);
                }
            }
            dp[i] = max;
        }

        int ans = 0;
        for (int d: dp) {
            ans = Math.max(ans, d);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BestTeamWithNoConflicts().bestTeamScore(new int[]{4,5,6,5}, new int[]{2,1,2,1}));
    }
}
