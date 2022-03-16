package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class CountNodesWithTheHighestScore {
    public static void main(String[] args) {
        int[] parents = new int[]{-1, 2, 0, 2, 0};

        System.out.println(new CountNodesWithTheHighestScore().countHighestScoreNodes(parents));
    }

    public int countHighestScoreNodes(int[] parents) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < parents.length; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 1; i < parents.length; i++) {
            map.get(parents[i]).add(i);
        }
        long[] s = new long[parents.length];

        dfs(map, s, 0);
        long max = Arrays.stream(s).max().getAsLong();

        return (int) Arrays.stream(s).filter(x -> x == max).count();
    }

    private int dfs(HashMap<Integer, List<Integer>> map, long[] s, int node) {
        int sum = 1;
        long product = 1;
        for (int child : map.get(node)) {
            int score = dfs(map, s, child);
            sum += score;
            product *= score;
        }
        s[node] = product * Math.max(1, map.size() - sum);

        return sum;
    }
}
