package dev.namtx.lintcode;

public class NumberOfSubstringsWithAllZeroes {
    public int stringCount(String str) {
        int i = 0;
        int ans = 0;
        while(i < str.length()) {
            if (str.charAt(i) == '0') {
                int end = i;
                while(end < str.length() && str.charAt(end) == '0') {
                    ans += (end - i + 1);
                    end++;
                }
                i = end;
            }
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfSubstringsWithAllZeroes().stringCount("00010011"));
        System.out.println(new NumberOfSubstringsWithAllZeroes().stringCount("010010"));
        System.out.println(new NumberOfSubstringsWithAllZeroes().stringCount("111"));
        System.out.println(new NumberOfSubstringsWithAllZeroes().stringCount("0"));
        System.out.println(new NumberOfSubstringsWithAllZeroes().stringCount("00"));
        System.out.println(new NumberOfSubstringsWithAllZeroes().stringCount(""));
    }
}
