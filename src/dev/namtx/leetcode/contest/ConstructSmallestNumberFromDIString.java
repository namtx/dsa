package dev.namtx.leetcode.contest;

public class ConstructSmallestNumberFromDIString {
    public String smallestNumber(String pattern) {
        pattern += "I";
        int[] digits = new int[pattern.length()];
        int num = 1;
        int i = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == 'I') {
                digits[i++] = num++;
            } else {
                int j = i;
                while(j < pattern.length() && pattern.charAt(j) == 'D') {
                    j++;
                    num++;
                }
                int prev = num;
                for (; i <= j; i++) {
                    digits[i] = prev--;
                }
                num++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (i = 0; i < digits.length; i++) {
            sb.append(String.valueOf(digits[i]));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ConstructSmallestNumberFromDIString().smallestNumber("IIIDIDDD"));
    }
}
