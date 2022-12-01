package dev.namtx.adventofcode2022.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day1/sample.txt";

    static class Part1 {
        public static void main(String[] args) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
                String currentLine = reader.readLine();
                int max = 0;
                int currentCalories = 0;
                while (currentLine != null) {
                    if (currentLine.length() == 0) {
                        max = Math.max(max, currentCalories);
                        currentCalories = 0;
                    } else {
                        currentCalories += Integer.parseInt(currentLine);
                    }
                    currentLine = reader.readLine();
                }
                reader.close();
                System.out.println(max);
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
                BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
                String currentLine = reader.readLine();
                PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
                int currentCalories = 0;
                while (currentLine != null) {
                    if (currentLine.length() == 0) {
                        queue.offer(currentCalories);
                        currentCalories = 0;
                    } else {
                        currentCalories += Integer.parseInt(currentLine);
                    }
                    currentLine = reader.readLine();
                }
                reader.close();
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
