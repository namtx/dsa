package dev.namtx.adventofcode2022.day11;


import dev.namtx.adventofcode2022.utils.IterableFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day11/input.txt";

    static Monkey[] readInput() throws IOException {
        IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
        List<Monkey> monkeys = new ArrayList<>();
        fileReader.forEach(s -> {
            if (s.length() == 0) return;
            // start to read monkey attributes
            // Monkey 0:
            if (s.charAt(0) == 'M') {
                monkeys.add(new Monkey());
            } else {
                Monkey monkey = monkeys.get(monkeys.size() - 1);
                String[] parts = s.split(" ");
                if (s.charAt(2) == 'S') { // Starting items: 79, 98
                    monkey.items = Arrays.stream(s.substring(18).split(", ")).map(Long::parseLong).collect(Collectors.toList());
                } else if (s.charAt(2) == 'O') { // new = old * 19
                    monkey.operand = parts[parts.length - 1];
                    monkey.operator = parts[parts.length - 2];
                } else if (s.charAt(2) == 'T') { // Test: divisible by 23
                    monkey.testDivider = Long.parseLong(parts[parts.length - 1]);
                } else if (s.charAt(7) == 't') {// If true: throw to monkey 2
                    monkey.monkeyToThrowToIfTestSuccess = Integer.parseInt(parts[parts.length - 1]);
                } else if (s.charAt(7) == 'f') { // If false: throw to monkey 3
                    monkey.monkeyToThrowToIfTestFail = Integer.parseInt(parts[parts.length - 1]);
                }
            }
        });

        return monkeys.toArray(Monkey[]::new);
    }

    static class Part1 {
        public static void main(String[] args) throws IOException {
            Monkey[] monkeys = readInput();
            int[] inspects = new int[monkeys.length];
            for (int round = 0; round < 20; round++) {
                for (int i = 0; i < monkeys.length; i++) {
                    for (int j = 0; j < monkeys[i].items.size(); j++) {
                        inspects[i]++;
                        long item = monkeys[i].items.get(j);
                        long newValue = monkeys[i].operate(item);
                        newValue = newValue / 3;
                        if (newValue % monkeys[i].testDivider == 0) {
                            monkeys[monkeys[i].monkeyToThrowToIfTestSuccess].items.add(newValue);
                        } else {
                            monkeys[monkeys[i].monkeyToThrowToIfTestFail].items.add(newValue);
                        }
                    }
                    monkeys[i].items = new ArrayList<>();
                }
            }
            Arrays.sort(inspects);
            System.out.println(inspects[inspects.length - 1] * inspects[inspects.length - 2]);
        }
    }

    static class Part2 {
        public static void main(String[] args) throws IOException {
            Monkey[] monkeys = readInput();
            long[] inspects = new long[monkeys.length];
            long allDiv = 1;
            for (Monkey m : monkeys) {
                allDiv *= m.testDivider;
            }
            for (int round = 0; round < 10_000; round++) {
                for (int i = 0; i < monkeys.length; i++) {
                    for (int j = 0; j < monkeys[i].items.size(); j++) {
                        inspects[i]++;
                        long item = monkeys[i].items.get(j);
                        long newValue = monkeys[i].operate(item);
                        newValue %= allDiv;
                        if (newValue % monkeys[i].testDivider == 0) {
                            monkeys[monkeys[i].monkeyToThrowToIfTestSuccess].items.add(newValue);
                        } else {
                            monkeys[monkeys[i].monkeyToThrowToIfTestFail].items.add(newValue);
                        }
                    }
                    monkeys[i].items = new ArrayList<>();
                }
            }
            Arrays.sort(inspects);
            System.out.println(Arrays.toString(inspects));
            System.out.println(inspects[inspects.length - 1] * inspects[inspects.length - 2]);
        }
    }
}
