package dev.namtx.leetcode;

public class WordSearch {
    static final int[][] DIRS = new int[][]{
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}
        };
        System.out.println(new WordSearch().exist(board, "AAB"));
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && !visited[i][j]) {
                    visited[i][j] = true;
                    if (helper(board, word, visited, i, j, 0)) return true;
                    visited[i][j] = false;
                }
            }
        }

        return false;
    }

    private boolean helper(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (board[i][j] != word.charAt(index)) return false;
        if (index == word.length() - 1) {
            return true;
        }
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y]) {
                visited[x][y] = true;
                if (helper(board, word, visited, x, y, index + 1)) {
                    return true;
                }
                visited[x][y] = false;
            }
        }

        return false;
    }
}
