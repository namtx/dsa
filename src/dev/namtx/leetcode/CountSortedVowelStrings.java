package dev.namtx.leetcode;

public class CountSortedVowelStrings {
    char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
    int ans = 0;
    public int countVowelStrings(int n) {
        backtrack(n, 0, new StringBuilder());
        return ans;
    }

    void backtrack(int n, int i, StringBuilder sb) {
        if (sb.length() == n) {
            ans++;
            return;
        }
        for (int j = i; j < vowels.length; j++) {
            sb.append(vowels[j]);
            backtrack(n, j, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CountSortedVowelStrings().countVowelStrings(33));
    }
}
