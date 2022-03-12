package dev.namtx.leetcode;

class EditDistance {
    public static void main(String[] args) {
        EditDistance obj = new EditDistance();
        System.out.println(obj.minDistance("intention", "execution"));
    }

    public int minDistance(String word1, String word2) {
        int N = word1.length();
        int M = word2.length();
        if (M == 0 || N == 0) {
            return Math.max(M, N); // only adding
        }

        int[][] cost = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            cost[i][0] = i;
        }
        for (int i = 1; i <= M; i++) {
            cost[0][i] = i;
        }

        /**
         * cost[i][j]: replace
         * const[i+1][j]: delete
         * cost[i][j+1]: add
         */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    cost[i + 1][j + 1] = cost[i][j];
                } else {
                    cost[i + 1][j + 1] = 1 + Math.min(cost[i][j + 1], Math.min(cost[i + 1][j], cost[i][j]));
                }
            }
        }

        return cost[M][N];
    }
}
