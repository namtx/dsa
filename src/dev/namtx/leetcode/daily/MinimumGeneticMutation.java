package dev.namtx.leetcode.daily;

/**
 * https://leetcode.com/problems/minimum-genetic-mutation
 */
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        boolean[] checked = new boolean[bank.length];
        int min = minMutation(start, end, bank, checked, 0);
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    private int minMutation(String start, String end, String[] bank, boolean[] checked, int mutations) {
        if (start.equals(end)) return mutations;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < bank.length; i++) {
            if (!checked[i] && isMutation(bank[i], start)) {
                checked[i] = true;
                min = Math.min(min, minMutation(bank[i], end, bank, checked, mutations + 1));
                checked[i] = false;
            }
        }

        return min;
    }

    private boolean isMutation(String start, String end) {
        int diff = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) diff++;
        }

        return diff == 1;
    }
}
