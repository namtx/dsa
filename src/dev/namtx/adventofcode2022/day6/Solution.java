package dev.namtx.adventofcode2022.day6;

import dev.namtx.adventofcode2022.utils.IterableFileReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.function.Consumer;

public class Solution {
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day6/input.txt";

    static private int startOfPacketMarker(String line, int numberOfDistinctCharacters) {
        Map<Character, Integer> characterCountMap = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            queue.offer(c);
            characterCountMap.put(c, characterCountMap.getOrDefault(c, 0) + 1);
            if (queue.size() > numberOfDistinctCharacters) {
                char removedCharacter = queue.poll();
                int count = characterCountMap.get(removedCharacter);
                if (count == 1) {
                    characterCountMap.remove(removedCharacter);
                } else {
                    characterCountMap.put(removedCharacter, count - 1);
                }
            }
            if (characterCountMap.size() == numberOfDistinctCharacters) {
                // return 1-based index
                System.out.println(i + 1);
                return i + 1;
            }
        }
        return -1;
    }

    static class Part1 {
        public static void main(String[] args) throws IOException {
            IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
            String[] line = new String[1];

            fileReader.forEach(new Consumer<String>() {
                @Override
                public void accept(String s) {
                    line[0] = s;
                }
            });
            System.out.println(startOfPacketMarker(line[0], 4));
        }
    }

    static class Part2 {
        public static void main(String[] args) throws IOException {
            IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
            String[] line = new String[1];

            fileReader.forEach(new Consumer<String>() {
                @Override
                public void accept(String s) {
                    line[0] = s;
                }
            });
            System.out.println(startOfPacketMarker(line[0], 14));
        }
    }
}
