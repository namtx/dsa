package dev.namtx.adventofcode2022.day8;

import dev.namtx.adventofcode2022.utils.IterableFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day8/input.txt";

    static int[][] parseTheForest(String filePath) throws IOException {
        IterableFileReader fileReader = new IterableFileReader(filePath);
        List<String> lines = new ArrayList<>();
        fileReader.forEach(lines::add);
        int[][] forest = new int[lines.size()][lines.get(0).length()];
        int i = 0;
        for (String line : lines) {
            int j = 0;
            for (char c : line.toCharArray()) {
                forest[i][j++] = c - '0';
            }
            i++;
        }

        return forest;
    }

    static class Part1 {
        public static void main(String[] args) throws IOException {
            int[][] forest = parseTheForest(FILE_PATH);
            int ans = 0;
            for (int i = 1; i < forest.length - 1; i++) {
                for (int j = 1; j < forest[0].length - 1; j++) {
                    // top
                    int top = i;
                    while (top > 0 && forest[top - 1][j] < forest[i][j]) top--;
                    // right
                    int right = j;
                    while (right < forest[0].length - 1 && forest[i][right + 1] < forest[i][j]) right++;
                    // bottom
                    int bottom = i;
                    while (bottom < forest.length - 1 && forest[bottom + 1][j] < forest[i][j]) bottom++;
                    // left
                    int left = j;
                    while (left > 0 && forest[i][left - 1] < forest[i][j]) left--;

                    if (top == 0 || right == forest[0].length - 1 || bottom == forest.length - 1 || left == 0) {
                        ans++;
                    }
                }
            }
            System.out.println(ans + forest[0].length * 2 + forest.length * 2 - 4);
        }
    }

    static class Part2 {
        public static void main(String[] args) throws IOException {
            int[][] forest = parseTheForest(FILE_PATH);
            long ans = Long.MIN_VALUE;
            for (int i = 1; i < forest.length - 1; i++) {
                for (int j = 1; j < forest[0].length - 1; j++) {
                    // top
                    int top = i - 1;
                    while (top > 0 && forest[top][j] < forest[i][j]) top--;
                    // right
                    int right = j + 1;
                    while (right < forest[0].length - 1 && forest[i][right] < forest[i][j]) right++;
                    // bottom
                    int bottom = i + 1;
                    while (bottom < forest.length - 1 && forest[bottom][j] < forest[i][j]) bottom++;
                    // left
                    int left = j - 1;
                    while (left > 0 && forest[i][left] < forest[i][j]) left--;

                    long score = (long) (top - i) * (long) (right - j) * (long) (i - bottom) * (long) (j - left);
                    ans = Math.max(ans, score);
                }
            }

            System.out.println(ans);
        }
    }
}
