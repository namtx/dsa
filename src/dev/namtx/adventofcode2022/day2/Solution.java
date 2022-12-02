package dev.namtx.adventofcode2022.day2;

import dev.namtx.adventofcode2022.utils.IterableFileReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final Map<Character, Integer> pointsForChoiceMapping = new HashMap<>();
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day2/input.txt";

    static class Part1 {
        public static void main(String[] args) {
            setUp();

            try {
                IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
                final int[] ans = {0};
                fileReader.forEach(s -> ans[0] += score(s.charAt(0), s.charAt(2)));
                System.out.println(ans[0]);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class Part2 {
        public static void main(String[] args) {
            setUp();
            try {
                IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
                final int[] ans = {0};
                fileReader.forEach(s -> ans[0] += pointForTheExpectedResult(s.charAt(0), s.charAt(2)));
                System.out.println(ans[0]);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void setUp() {
        pointsForChoiceMapping.put('A', 1);
        pointsForChoiceMapping.put('B', 2);
        pointsForChoiceMapping.put('C', 3);
        pointsForChoiceMapping.put('X', 1);
        pointsForChoiceMapping.put('Y', 2);
        pointsForChoiceMapping.put('Z', 3);
    }

    private static int score(char opponentChoice, char yourChoice) {
        int ans = 0;
        ans += pointsForChoiceMapping.getOrDefault(yourChoice, 0);
        ans += scoreForEachMatch(opponentChoice, yourChoice);
        return ans;
    }

    private static int scoreForEachMatch(char opponentChoice, char yourChoice) {
        switch (opponentChoice) {
            case 'A':
                if (yourChoice == 'X') return 3;
                if (yourChoice == 'Y') return 6;
                if (yourChoice == 'Z') return 0;
            case 'B':
                if (yourChoice == 'X') return 0;
                if (yourChoice == 'Y') return 3;
                if (yourChoice == 'Z') return 6;
            case 'C':
                if (yourChoice == 'X') return 6;
                if (yourChoice == 'Y') return 0;
                if (yourChoice == 'Z') return 3;
            default:
                return 0;
        }
    }

    private static int pointForTheExpectedResult(char opponentChoice, char expectedResult) {
        if (expectedResult == 'Y') return 3 + pointsForChoiceMapping.get(opponentChoice);
        switch (opponentChoice) {
            case 'A':
                if (expectedResult == 'X') return pointsForChoiceMapping.get('C');
                else return 6 + pointsForChoiceMapping.get('B');
            case 'B':
                if (expectedResult == 'X') return pointsForChoiceMapping.get('A');
                else return 6 + pointsForChoiceMapping.get('C');
            case 'C':
                if (expectedResult == 'X') return pointsForChoiceMapping.get('B');
                else return 6 + pointsForChoiceMapping.get('A');
        }
        return 0;
    }
}
