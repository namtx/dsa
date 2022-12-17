package dev.namtx.adventofcode2022.day1;

import dev.namtx.adventofcode2022.utils.IterableFileReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day1/input.txt";

    static class Part1 {
        public static void main(String[] args) {
            try {
                IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
                final int[] max = {0};
                final int[] currentCalories = {0};
                fileReader.forEach(s -> {
                    if (s.length() == 0) {
                        max[0] = Math.max(max[0], currentCalories[0]);
                        currentCalories[0] = 0;
                    } else {
                        currentCalories[0] += Integer.parseInt(s);
                    }
                });
                System.out.println(max[0]);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class Part2 {
        public static void main(String[] args) {
            try {
                IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
                PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
                final int[] currentCalories = {0};
                fileReader.forEach(s -> {
                    if (s.length() == 0) {
                        queue.offer(currentCalories[0]);
                        currentCalories[0] = 0;
                    } else {
                        currentCalories[0] += Integer.parseInt(s);
                    }
                });
                int ans = 0;
                for (int i = 0; i < 3; i++) {
                    ans += queue.poll();
                }
                System.out.println(ans);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
