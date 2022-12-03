package dev.namtx.adventofcode2022.day3;

import dev.namtx.adventofcode2022.utils.IterableFileReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day3/input.txt";

    private static int getPriority(char c) {
        if (c > 'Z') {
            return c - 'a' + 1;
        } else {
            return 26 + c - 'A' + 1;
        }
    }

    static class Part1 {
        public static void main(String[] args) throws IOException {
            IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
            final int[] ans = {0};

            fileReader.forEach(s -> {
                int left = 0;
                int right = s.length() - 1;
                Set<Character> leftSet = new HashSet<>();
                Set<Character> rightSet = new HashSet<>();
                Set<Character> occurredTwiceCharacterSet = new HashSet<>();
                System.out.println(s);
                while (left < right) {
                    char charLeft = s.charAt(left);
                    char charRight = s.charAt(right);
                    leftSet.add(charLeft);
                    rightSet.add(charRight);
                    if (rightSet.contains(charLeft)) {
                        occurredTwiceCharacterSet.add(charLeft);
                    }
                    if (leftSet.contains(charRight)) {
                        occurredTwiceCharacterSet.add(charRight);
                    }
                    left++;
                    right--;
                }
                for (char c : occurredTwiceCharacterSet) {
                    ans[0] += getPriority(c);
                }
            });

            System.out.println(ans[0]);
        }
    }

    static class Part2 {
        public static void main(String[] args) throws IOException {
            IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
            final int[] itemIndex = {0};
            String[] rucksacks = new String[3];
            int[] ans = {0};

            fileReader.forEach(s -> {
                rucksacks[itemIndex[0]] = s;
                itemIndex[0]++;
                if (itemIndex[0] % 3 == 0) {
                    HashMap<Character, Integer> count = new HashMap<>();
                    for (String rucksack : rucksacks) {
                        Set<Character> set = new HashSet<>();
                        for (char c : rucksack.toCharArray()) {
                            if (!set.contains(c)) {
                                set.add(c);
                                int characterCount = count.getOrDefault(c, 0);
                                if (characterCount == 2) {
                                    ans[0] += getPriority(c);
                                } else {
                                    count.put(c, characterCount + 1);
                                }
                            }
                        }
                    }
                    itemIndex[0] = 0;
                }
            });

            System.out.println(ans[0]);
        }
    }
}
