package dev.namtx.adventofcode2022.day9;

import dev.namtx.adventofcode2022.utils.IterableFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day9/input.txt";

    private static void debugMatrix(Knot[] knots) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                boolean found = false;
                for (int k = 0; k < knots.length; k++) {
                    if (i == knots[k].row && j == knots[k].col) {
                        if (k == 0) {
                            System.out.print("H");
                        } else {
                            System.out.print(k);
                        }
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    private static void debugVisited(boolean[][] visited) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (visited[i][j]) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    static class Knot {
        int row;
        int col;
        int prevRow;
        int prevCol;

        public Knot(int row, int col, int prevRow, int prevCol) {
            this.row = row;
            this.col = col;
            this.prevCol = prevCol;
            this.prevRow = prevRow;
        }
    }

    static class Part1 {
        public static void main(String[] args) throws IOException {
            List<String> lines = new ArrayList<>();
            IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
            fileReader.forEach(lines::add);
            Knot[] knots = new Knot[10];
            // 0 is the H
            for (int i = 0; i < knots.length; i++) {
                knots[i] = new Knot(500, 500, 500, 500);
            }

            boolean[][] visited = new boolean[1000][1000];
            int ans = 0;

            for (String line : lines) {
                String[] parts = line.split(" ");
                char direction = parts[0].charAt(0);
                int steps = Integer.parseInt(parts[1]);
                for (int i = 0; i < steps; i++) {
                    knots[0].prevRow = knots[0].row;
                    knots[0].prevCol = knots[0].col;
                    switch (direction) {
                        case 'R':
                            knots[0].col++;
                            break;
                        case 'L':
                            knots[0].col--;
                            break;
                        case 'U':
                            knots[0].row--;
                            break;
                        case 'D':
                            knots[0].row++;
                            break;
                    }
                    updateTail(knots[0], knots[1]);
                    if (!visited[knots[1].row][knots[1].col]) {
                        ans++;
                        visited[knots[1].row][knots[1].col] = true;
                    }
                }
            }
            System.out.println(ans);
        }

        private static void updateTail(Knot head, Knot tail) {
            int distance = Math.abs(head.row - tail.row) + Math.abs(head.col - tail.col);
            if (distance <= 1 || ((head.col != tail.col && head.row != tail.row) && distance == 2)) {
                // do not update the tail
            } else {
                tail.prevCol = tail.col;
                tail.prevRow = tail.row;
                tail.row = head.prevRow;
                tail.col = head.prevCol;
            }
        }
    }

    static class Part2 {
        static final int[][] HEX_DIRS = new int[][]{{1, 1}, {-1, -1}, {1, -1}, {-1, 1},};
        static final int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public static void main(String[] args) throws IOException {
            List<String> lines = new ArrayList<>();

            IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
            fileReader.forEach(lines::add);
            int startPoint = 500;
            Knot[] knots = new Knot[10];
            // 0 is the H
            for (int i = 0; i < knots.length; i++) {
                knots[i] = new Knot(startPoint, startPoint, startPoint, startPoint);
            }

            boolean[][] visited = new boolean[startPoint * 2][startPoint * 2];
            int ans = 0;

            for (String line : lines) {
                String[] parts = line.split(" ");
                char direction = parts[0].charAt(0);
                int steps = Integer.parseInt(parts[1]);
                for (int i = 0; i < steps; i++) {
                    knots[0].prevRow = knots[0].row;
                    knots[0].prevCol = knots[0].col;
                    switch (direction) {
                        case 'R':
                            knots[0].col++;
                            break;
                        case 'L':
                            knots[0].col--;
                            break;
                        case 'U':
                            knots[0].row--;
                            break;
                        case 'D':
                            knots[0].row++;
                            break;
                    }
                    for (int j = 1; j < knots.length; j++) {
                        updateTail(knots[j - 1], knots[j]);
                    }
                    if (!visited[knots[9].row][knots[9].col]) {
                        ans++;
                        visited[knots[9].row][knots[9].col] = true;
                    }
                }
            }
            System.out.println(ans);
        }

        private static void updateTail(Knot head, Knot tail) {
            if (!closeEnough(head, tail.row, tail.col)) {
                if (head.col != tail.col && head.row != tail.row) {
                    // jump
                    for (int[] dir : HEX_DIRS) {
                        int newRow = tail.row + dir[0];
                        int newCol = tail.col + dir[1];
                        if (closeEnough(head, newRow, newCol)) {
                            tail.col = newCol;
                            tail.row = newRow;
                            break;
                        }
                    }
                } else {
                    for (int[] dir : DIRS) {
                        int newRow = tail.row + dir[0];
                        int newCol = tail.col + dir[1];
                        if (closeEnough(head, newRow, newCol)) {
                            tail.col = newCol;
                            tail.row = newRow;
                            break;
                        }
                    }
                }
            }
        }

        private static boolean closeEnough(Knot head, int row, int col) {
            int distance = Math.abs(head.row - row) + Math.abs(head.col - col);

            return (distance <= 1 || ((head.col != col && head.row != row) && distance == 2));
        }
    }
}
