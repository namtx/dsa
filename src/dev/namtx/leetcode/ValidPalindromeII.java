package dev.namtx.leetcode;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, false);
    }

    public boolean validPalindrome(String s, boolean deleted) {
        int left = 0;
        int right = s.length()-1;

        while(left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (deleted) return false;
                return validPalindrome(s.substring(left+1, right+1), true) || validPalindrome(s.substring(left, right), true);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindromeII().validPalindrome("abc"));
    }
}
