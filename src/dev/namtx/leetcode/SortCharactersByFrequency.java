package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency().prequencySort2("loveleetcode"));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        ArrayList<Character>[] buckets = new ArrayList[s.length() + 1];
        for (char c : countMap.keySet()) {
            int count = countMap.get(c);
            ArrayList<Character> bucket = buckets[count];
            if (bucket == null) {
                bucket = new ArrayList<>();
            }
            while (count-- > 0) {
                bucket.add(c);
            }
            buckets[countMap.get(c)] = bucket;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i >= 1; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

    public String prequencySort2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> e = pq.poll();
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }

        return sb.toString();
    }
}
