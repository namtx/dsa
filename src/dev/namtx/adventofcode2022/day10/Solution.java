package dev.namtx.adventofcode2022.day10;

import dev.namtx.adventofcode2022.utils.IterableFileReader;

import java.io.IOException;

public class Solution {
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day10/input.txt";

    private static int[] buildCycles() throws IOException {
        IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
        int[] cycles = new int[1000];
        int[] x = {1};
        int[] i = {1};

        fileReader.forEach(s -> {
            // after the last cycle
            if (s.charAt(0) == 'a') {
                cycles[i[0]++] = x[0];
                cycles[i[0]++] = x[0];
                x[0] += Integer.parseInt(s.split(" ")[1]);
            } else {
                cycles[i[0]++] = x[0];
            }
        });

        return cycles;
    }

    static class Part1 {
        public static void main(String[] args) throws IOException {
            int[] cycles = buildCycles();

            int j = 20;
            long ans = 0;
            while (j <= 220) {
                ans += ((long) cycles[j] * j);
                j += 40;
            }

            System.out.println(ans);
        }
    }

    static class Part2 {
        public static void main(String[] args) throws IOException {
            int[] cycles = buildCycles();

            for (int line = 0; line < 6; line++) {
                StringBuilder sb = new StringBuilder();
                for (int cursor = 0; cursor < 40; cursor++) {
                    int spritePosition = cycles[line * 40 + cursor + 1];
                    if (cursor >= spritePosition - 1 && cursor <= spritePosition + 1) {
                        sb.append('#');
                    } else {
                        sb.append('.');
                    }
                }
                System.out.println(sb);
            }
        }
    }
}
