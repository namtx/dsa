package dev.namtx.adventofcode2022.day12;

import dev.namtx.adventofcode2022.utils.IterableFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day12/input.txt";
    private static final int[][] DIRS = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static char[][] buildTheMap() throws IOException {
        List<String> lines = new ArrayList<>();
        IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
        fileReader.forEach(lines::add);

        char[][] map = new char[lines.size()][lines.get(0).length()];
        for (int i = 0; i < map.length; i++) {
            map[i] = lines.get(i).toCharArray();
        }

        return map;
    }

    private static int calculateSteps(char end) throws IOException {
        char[][] map = buildTheMap();
        int xe = 0, ye = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'E') {
                    xe = i;
                    ye = j;
                }
            }
        }
        map[xe][ye] = 'z';
        int steps = 0;

        List<int[]> queue = new ArrayList<>();
        queue.add(new int[]{xe, ye});
        while (!queue.isEmpty()) {
            steps++;
            List<int[]> next = new ArrayList<>();
            for (int[] point : queue) {
                char c = map[point[0]][point[1]];
                if (map[point[0]][point[1]] == '.') continue;
                map[point[0]][point[1]] = '.';
                for (int[] dir : DIRS) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < map.length && y < map[0].length && map[x][y] != '.') {
                        if (map[x][y] == end && (c == 'a' || c == 'b')) {
                            return steps;
                        }
                        if (map[x][y] != end && c - map[x][y] < 2) {
                            next.add(new int[]{x, y});
                        }
                    }
                }
            }
            queue = next;
        }

        return steps;
    }

    static class Part1 {
        public static void main(String[] args) throws IOException {
            System.out.println(calculateSteps('S'));
        }
    }

    static class Part2 {
        public static void main(String[] args) throws IOException {
            System.out.println(calculateSteps('a'));
        }
    }
}
