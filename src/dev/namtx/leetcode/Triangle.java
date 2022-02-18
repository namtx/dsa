package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(-1));
        triangle.add(Arrays.asList(-2, -3));

        System.out.println(
                new Triangle()
                        .minimumTotal(
                                triangle
                        )
        );
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int addition = dp[i - 1][j];
                if (j > 0 && j < triangle.get(i).size() - 1) {
                    addition = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                } else if (j == triangle.get(i).size() - 1) {
                    addition = dp[i - 1][j - 1];
                }
                dp[i][j] = addition + triangle.get(i).get(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[dp.length - 1].length; i++) {
            min = Math.min(min, dp[dp.length - 1][i]);
        }

        return min;
    }
}
