package dev.namtx.adventofcode2022.day4;

import dev.namtx.adventofcode2022.utils.IterableFileReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day4/input.txt";

    private static boolean fullyContain(List<Integer> firstRange, List<Integer> secondRange) {
        return ((firstRange.get(0) <= secondRange.get(0)) && (secondRange.get(1) <= firstRange.get(1)))
                || ((firstRange.get(0) >= secondRange.get(0)) && (firstRange.get(1) <= secondRange.get(1)));
    }

    private static boolean overlap(List<Integer> firstRange, List<Integer> secondRange) {
        return ((firstRange.get(0) <= secondRange.get(0)) && (firstRange.get(1) >=  secondRange.get(0)))
                || ((firstRange.get(0) >= secondRange.get(0)) && (secondRange.get(1) >= firstRange.get(0)));
    }

    static class Part1 {
        public static void main(String[] args) throws IOException {
            IterableFileReader fileReader = new IterableFileReader(FILE_PATH);

            final int[] count = {0};

            fileReader.forEach(s -> {
                String[] sections = s.split(",");
                List<Integer> firstRange = Arrays.stream(sections[0].split("-")).map(Integer::parseInt).collect(Collectors.toList());
                List<Integer> secondRange = Arrays.stream(sections[1].split("-")).map(Integer::parseInt).collect(Collectors.toList());
                if (fullyContain(firstRange, secondRange)) {
                    System.out.println(s);
                    count[0]++;
                }
            });

            System.out.println(count[0]);
        }
    }

    static class Part2 {
        public static void main(String[] args) throws IOException {
            IterableFileReader fileReader = new IterableFileReader(FILE_PATH);

            final int[] count = {0};

            fileReader.forEach(s -> {
                String[] sections = s.split(",");
                List<Integer> firstRange = Arrays.stream(sections[0].split("-")).map(Integer::parseInt).collect(Collectors.toList());
                List<Integer> secondRange = Arrays.stream(sections[1].split("-")).map(Integer::parseInt).collect(Collectors.toList());
                if (overlap(firstRange, secondRange)) {
                    System.out.println(s);
                    count[0]++;
                }
            });

            System.out.println(count[0]);
        }
    }
}
