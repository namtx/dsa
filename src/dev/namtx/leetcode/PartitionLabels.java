package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] lastOccurrences = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrences[s.charAt(i)-'a'] = i;
        }

        int max = 0;
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            int lastOccurrence = lastOccurrences[s.charAt(i)-'a'];
            max = Math.max(lastOccurrence, max);
            if (max == i) {
                ans.add(count);
                count = 1;
            } else {
                count++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("xababcbacadefegdehijhklij"));
    }
}
