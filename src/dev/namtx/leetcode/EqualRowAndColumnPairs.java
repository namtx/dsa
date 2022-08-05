package dev.namtx.leetcode;

public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        String[] rows = new String[grid.length];
        String[] columns = new String[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j: grid[i]) {
                sb.append(j);
                sb.append('-');
            }
            rows[i] = sb.toString();
        }
        for (int j = 0; j < grid[0].length; j++) {
            StringBuilder sb = new StringBuilder();
            for (int[] ints : grid) {
                sb.append(ints[j]);
                sb.append('-');
            }
            columns[j] = sb.toString();
        }
        int count = 0;

        for (String row : rows) {
            for (String column : columns) {
                if (row.equals(column))
                    count++;
            }
        }

        return count;
    }
}

