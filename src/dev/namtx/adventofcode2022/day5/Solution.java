package dev.namtx.adventofcode2022.day5;

import dev.namtx.adventofcode2022.utils.IterableFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day5/input.txt";

    /**
     * @param instruction
     * @return [numberOfCrates, fromIndex, toIndex]
     */
    static private int[] parseMoveInstruction(String instruction) {
        String[] instructionParts = instruction.split(" ");
        return new int[]{Integer.parseInt(instructionParts[1]), Integer.parseInt(instructionParts[3]), Integer.parseInt(instructionParts[5])};
    }

    static class Part1 {
        public static void main(String[] args) throws IOException {
            boolean[] instructionStart = {false};
            List<String> lines = new ArrayList<>();
            List<Stack<Character>> stacks = new ArrayList<>();
            int[] currentIndex = {0};
            IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
            fileReader.forEach(s -> {
                if (s.length() == 0) {
                    instructionStart[0] = true;
                    int numberOfStack = lines.get(currentIndex[0] - 1).strip().split("   ").length;
                    for (int i = 0; i < numberOfStack; i++) {
                        stacks.add(new Stack<>());
                    }
                    for (int i = currentIndex[0] - 2; i >= 0; i--) {
                        String line = lines.get(i);
                        for (int j = 0; j < numberOfStack; j++) {
                            Stack<Character> stack = stacks.get(j);
                            if (line.charAt(j * 4 + 1) != ' ') stack.push(line.charAt(j * 4 + 1));
                        }
                    }
                    currentIndex[0]++;
                    return;
                }
                if (!instructionStart[0]) {
                    currentIndex[0]++;
                    lines.add(s);
                } else {
                    int[] instruction = parseMoveInstruction(s);
                    for (int i = 0; i < instruction[0]; i++) {
                        char c = stacks.get(instruction[1] - 1).pop();
                        stacks.get(instruction[2] - 1).push(c);
                    }
                }
            });

            StringBuilder sb = new StringBuilder();
            for (Stack<Character> stack : stacks) {
                if (stack.size() > 0) {
                    sb.append(stack.peek());
                }
            }
            System.out.println(sb);
        }
    }

    static class Part2 {
        public static void main(String[] args) throws IOException {
            boolean[] instructionStart = {false};
            List<String> lines = new ArrayList<>();
            List<Stack<Character>> stacks = new ArrayList<>();
            int[] currentIndex = {0};
            IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
            fileReader.forEach(s -> {
                if (s.length() == 0) {
                    instructionStart[0] = true;
                    int numberOfStack = lines.get(currentIndex[0] - 1).strip().split("   ").length;
                    for (int i = 0; i < numberOfStack; i++) {
                        stacks.add(new Stack<>());
                    }
                    for (int i = currentIndex[0] - 2; i >= 0; i--) {
                        String line = lines.get(i);
                        for (int j = 0; j < numberOfStack; j++) {
                            Stack<Character> stack = stacks.get(j);
                            if (line.charAt(j * 4 + 1) != ' ') stack.push(line.charAt(j * 4 + 1));
                        }
                    }
                    currentIndex[0]++;
                    return;
                }
                if (!instructionStart[0]) {
                    currentIndex[0]++;
                    lines.add(s);
                } else {
                    int[] instruction = parseMoveInstruction(s);
                    Stack<Character> tmp = new Stack<>();
                    for (int i = 0; i < instruction[0]; i++) {
                        tmp.push(stacks.get(instruction[1] - 1).pop());
                    }
                    while (!tmp.isEmpty()) {
                        stacks.get(instruction[2] - 1).push(tmp.pop());
                    }
                }
            });

            StringBuilder sb = new StringBuilder();
            for (Stack<Character> stack : stacks) {
                if (stack.size() > 0) {
                    sb.append(stack.peek());
                }
            }
            System.out.println(sb.toString());
        }
    }
}
