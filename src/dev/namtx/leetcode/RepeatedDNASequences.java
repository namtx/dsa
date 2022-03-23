package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {
    public static void main(String[] args) {
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences("AAAAAAAAAAA"));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length() - 10 + 1; i++) {
            String str = s.substring(i, i + 10);
            int count = m.getOrDefault(str, 0);
            m.put(str, count + 1);
        }
        List<String> ans = new ArrayList<>();
        for (String str : m.keySet()) {
            if (m.get(str) > 1) ans.add(str);
        }

        return ans;
    }
}
