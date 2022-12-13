package dev.namtx.adventofcode2022.day13;

import dev.namtx.adventofcode2022.utils.IterableFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day13/input.txt";

    static List<Object> parse(String line) {
        List<Object> ans = new ArrayList<>();
        Stack<List<Object>> listStack = new Stack<>();
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '[') {
                s.push(c);
                listStack.push(new ArrayList<>());
            } else {
                if (c == ',' || c == ']') {
                    StringBuilder sb = new StringBuilder();
                    while (s.peek() != '[') {
                        sb.insert(0, s.pop());
                    }
                    if (sb.length() > 0) listStack.peek().add(Integer.parseInt(sb.toString()));
                    if (c == ']') {
                        List<Object> last = listStack.pop();
                        if (listStack.isEmpty()) {
                            return last;
                        } else {
                            while (s.peek() != '[') {
                                sb.insert(0, s.pop());
                            }
                            listStack.peek().add(last);
                        }
                    }
                } else {
                    s.push(c);
                }
            }
        }

        return ans;
    }

    static int compare(Integer first, List<Object> second) {
        if (second.size() == 0) {
            return 1;
        }
        if (second.get(0) instanceof Integer) {
            if (first == second.get(0)) {
                if (second.size() == 1) return 0;
                return first - (int) second.get(0) > 0 ? 1 : -1;
            }
            return first - (int) second.get(0) > 0 ? 1 : -1;
        } else if (second.get(0) instanceof List) {
            return compare(first, (List<Object>) second.get(0));
        }
        return 0;
    }

    static int compareList(List<Object> first, List<Object> second) {
        int firstCursor = 0;
        int secondCursor = 0;
        if (first.size() == 0 && second.size() == 0) return 0;
        while (firstCursor < first.size() && secondCursor < second.size()) {
            Object firstVal = first.get(firstCursor);
            Object secondVal = second.get(secondCursor);
            if (firstVal instanceof Integer && secondVal instanceof Integer) {
                if ((int) firstVal != (int) secondVal) {
                    return (int) firstVal - (int) secondVal > 0 ? 1 : -1;
                }
            } else if (firstVal instanceof Integer) {
                int compareResult = compare((int) firstVal, (List<Object>) secondVal);
                if (compareResult != 0) return compareResult;
            } else if (secondVal instanceof Integer) {
                int compareResult = compare((int) secondVal, (List<Object>) firstVal);
                if (compareResult != 0) return -compareResult;
            } else {
                int compareResult = compareList((List<Object>) firstVal, (List<Object>) secondVal);
                if (compareResult != 0) return compareResult;
            }

            firstCursor++;
            secondCursor++;
        }

        if (firstCursor >= first.size()) {
            return -1;
        } else {
            return 1;
        }
    }

    static class Part1 {
        public static void main(String[] args) throws IOException {
            IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
            final List<String>[] lines = new List[]{new ArrayList<>()};
            int[] ans = {0};
            int[] index = {1};

            fileReader.forEach(s -> {
                if (s.length() > 0) {
                    lines[0].add(s);
                    if (lines[0].size() == 2) {
                        List<Object> first1 = parse(lines[0].get(0));
                        List<Object> second1 = parse(lines[0].get(1));

                        if (compareList(first1, second1) == -1) {
                            ans[0] += index[0];
                        }
                        index[0]++;
                        lines[0] = new ArrayList<>();
                    }
                }
            });

            System.out.println(ans[0]);
        }
    }

    static class Part2 {
        public static void main(String[] args) throws IOException {
            IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
            final List<String>[] lines = new List[]{new ArrayList<>()};

            fileReader.forEach(s -> {
                if (s.length() > 0) {
                    lines[0].add(s);
                }
            });

            lines[0].add("[[2]]");
            lines[0].add("[[6]]");

            String[] zipLines = lines[0].toArray(String[]::new);

            Arrays.sort(zipLines, (o1, o2) -> compareList(parse(o1), parse(o2)));
            int ans = 1;
            for (int i = 0; i < zipLines.length; i++) {
                if (zipLines[i].equals("[[2]]") || zipLines[i].equals("[[6]]")) {
                    ans *= i + 1;
                }
            }
            System.out.println(ans);
        }
    }
}
