package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        String[] words = split(s);

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(reverse(word));
            sb.append(' ');
        }

        return sb.toString().trim();
    }

    private String[] split(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                words.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(s.charAt(i));
            }
        }

        words.add(sb.toString());

        return words.toArray(new String[words.size()]);
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.insert(0, c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAStringIII().reverseWords("Let's take LeetCode contest"));
    }
}
