package dev.namtx.leetcode;

/**
 * https://leetcode.com/problems/score-of-parentheses/
 */
public class ScoreOfParentheses {
    public static void main(String[] args) {
        System.out.println(new ScoreOfParentheses().scoreOfParentheses("(()(())())"));
    }

    public int scoreOfParentheses(String s) {
        int opens = 0;
        int score = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                opens++;
            } else {
                opens--;
                if (s.charAt(i - 1) == '(') {
                    score += 1 << opens;
                }
            }
        }

        return score;
    }
}
