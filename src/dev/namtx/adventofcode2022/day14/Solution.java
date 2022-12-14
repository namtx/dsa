package dev.namtx.adventofcode2022.day14;

import dev.namtx.adventofcode2022.utils.IterableFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day14/input.txt";

    static char[][] parseInput() throws IOException {
        char[][] cave = new char[5000][5000];
        for (char[] row : cave) {
            Arrays.fill(row, '.');
        }
        IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
        final List<String>[] lines = new List[]{new ArrayList<>()};

        fileReader.forEach(s -> lines[0].add(s));

        for (String line : lines[0]) {
            line = line.replaceAll(" -> ", ",");
            String[] parts = line.split(",");
            int lastY = Integer.parseInt(parts[0]);
            int lastX = Integer.parseInt(parts[1]);
            for (int i = 3; i < parts.length; i++) {
                if (i % 2 != 0) {
                    int nextY = Integer.parseInt(parts[i - 1]);
                    int nextX = Integer.parseInt(parts[i]);
                    for (int x = Math.min(lastX, nextX); x <= Math.max(lastX, nextX); x++) {
                        for (int y = Math.min(lastY, nextY); y <= Math.max(lastY, nextY); y++) {
                            cave[x][y] = '#';
                        }
                    }
                    lastX = nextX;
                    lastY = nextY;
                }
            }
        }

        return cave;
    }

    static int findDeepestLevel(char[][] cave) {
        int deepestLevel = cave.length - 1;
        boolean foundDeepestLevel = false;

        while (!foundDeepestLevel) {
            int j;
            for (j = 0; j < cave[0].length; j++) {
                if (cave[deepestLevel][j] == '#') {
                    foundDeepestLevel = true;
                    break;
                }
            }
            deepestLevel--;
        }

        return deepestLevel;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Part1 {
        public static void main(String[] args) throws IOException {
            char[][] cave = parseInput();
            int deepestLevel = findDeepestLevel(cave);
            int ans = 0;

            boolean deepestLevelReached = false;
            while (!deepestLevelReached) {
                Point currentPoint = new Point(0, 500);
                while (currentPoint != null) {
                    // try to fall down
                    if (cave[currentPoint.x + 1][currentPoint.y] == '.') {
                        currentPoint = new Point(currentPoint.x + 1, currentPoint.y);
                    } else if (cave[currentPoint.x + 1][currentPoint.y - 1] == '.') { // try to one step down and left
                        currentPoint = new Point(currentPoint.x + 1, currentPoint.y - 1);
                    } else if (cave[currentPoint.x + 1][currentPoint.y + 1] == '.') { // try to one step down and right
                        currentPoint = new Point(currentPoint.x + 1, currentPoint.y + 1);
                    } else {
                        cave[currentPoint.x][currentPoint.y] = 'o';
                        ans++;
                        currentPoint = null;
                    }
                    if (currentPoint != null && currentPoint.x > deepestLevel) {
                        deepestLevelReached = true;
                        break;
                    }
                }
            }

            System.out.println(ans);
        }
    }

    static class Part2 {
        public static void main(String[] args) throws IOException {
            char[][] cave = parseInput();

            int deepestLevel = findDeepestLevel(cave);

            Arrays.fill(cave[deepestLevel + 3], '#');

            int ans = 0;

            while (true) {
                Point currentPoint = new Point(0, 500);
                while (currentPoint != null) {
                    // try to fall down
                    if (cave[currentPoint.x + 1][currentPoint.y] == '.') {
                        currentPoint = new Point(currentPoint.x + 1, currentPoint.y);
                    } else if (cave[currentPoint.x + 1][currentPoint.y - 1] == '.') { // try to one step down and left
                        currentPoint = new Point(currentPoint.x + 1, currentPoint.y - 1);
                    } else if (cave[currentPoint.x + 1][currentPoint.y + 1] == '.') { // try to one step down and right
                        currentPoint = new Point(currentPoint.x + 1, currentPoint.y + 1);
                    } else {
                        cave[currentPoint.x][currentPoint.y] = 'o';
                        ans++;
                        if (currentPoint.x == 0 && currentPoint.y == 500) {
                            System.out.println(ans);
                            return;
                        }
                        currentPoint = null;
                    }
                }
            }

        }
    }
}
