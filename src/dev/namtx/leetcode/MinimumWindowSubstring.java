package dev.namtx.leetcode;

import java.util.HashMap;
import java.util.Objects;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * <p>
 * tags: string, sliding window
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("a", "a"));
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        int left = 0;
        int right = 0;
        int countCharacters = 0;

        HashMap<Character, Integer> windowMap = new HashMap<>();
        int[] answer = new int[]{-1, 0, 0};

        while (right < s.length()) {
            Character c = s.charAt(right);
            if (!windowMap.containsKey(c)) {
                windowMap.put(c, 1);
            } else {
                windowMap.put(c, windowMap.get(c) + 1);
            }
            if (map.containsKey(c) && Objects.equals(map.get(c), windowMap.get(c))) {
                countCharacters++;
            }

            while (left <= right && countCharacters == map.size()) {
                Character leftCharacter = s.charAt(left);
                windowMap.put(leftCharacter, windowMap.get(leftCharacter) - 1);
                if (map.containsKey(leftCharacter) && windowMap.get(leftCharacter) < map.get(leftCharacter)) {
                    countCharacters--;
                }
                if (answer[0] == -1 || right - left + 1 < answer[0]) {
                    answer[0] = right - left + 1;
                    answer[1] = left;
                    answer[2] = right;
                }

                left++;
            }

            right++;
        }

        return answer[0] == -1 ? "" : s.substring(answer[1], answer[2] + 1);
    }
}
