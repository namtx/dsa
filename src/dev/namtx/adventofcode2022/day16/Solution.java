package dev.namtx.adventofcode2022.day16;

import dev.namtx.adventofcode2022.utils.IterableFileReader;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day16/input.txt";
    static class Valve {
        int rate;
        List<Valve> neighborValves;

        boolean isOpen = false;

        String name;

        public Valve(String name) {
            this.name = name;
            this.neighborValves = new ArrayList<>();
        }
    }

    static Map<String, Valve> parseInput() throws IOException {
        IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
        List<String>[] lines = new List[]{new ArrayList<>()};
        fileReader.forEach(s -> lines[0].add(s));
        Pattern pattern = Pattern.compile("^Valve\\s([A-Z]{2})\\s.+rate=(\\d+);.+\\sto\\svalves*\\s(.+)$");

        Map<String, Valve> map = new HashMap<>();
        for (String line: lines[0]) {
            Matcher matcher = pattern.matcher(line);
            List<String> list = new ArrayList<>();
            while (matcher.find()) {
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    list.add(matcher.group(i));
                }
            }
            Valve valve = map.getOrDefault(list.get(0), new Valve(list.get(0)));
            valve.rate = Integer.parseInt(list.get(1));
            map.putIfAbsent(list.get(0), valve);
            for (String v: list.get(2).split(", ")) {
                map.putIfAbsent(v, new Valve(v));
                valve.neighborValves.add(map.get(v));
            }
        }
        return map;
    }

    static class Part1 {
        public static void main(String[] args) throws IOException {
            Map<String, Valve> map = parseInput();
            System.out.println(map);
            System.out.println(findMaxPath(30, map.get("AA"), new HashSet<>(), new HashMap<>()));

        }

        static int findMaxPath(int minuteLeft, Valve currentValve, Set<String> opened, Map<String, Map<String, int[]>> cached) {
            if (cached.containsKey(currentValve.name) && cached.get(currentValve).containsKey(opened.toString()))
            if (minuteLeft <= 0) {
                return 0;
            }
            int max = 0;
            if (!opened.contains(currentValve.name)) {
                int val = currentValve.rate * (minuteLeft-1);
                Set<String> newOpened = new HashSet<>(opened);
                newOpened.add(currentValve.name);
                for (Valve v: currentValve.neighborValves) {
                    if (val != 0) {
                        max = Math.max(max, val + findMaxPath(minuteLeft - 2, v, newOpened, cached));
                    }
                    max = Math.max(max, findMaxPath(minuteLeft - 1, v, opened, cached));
                }
            }

            return max;
        }
    }
}
