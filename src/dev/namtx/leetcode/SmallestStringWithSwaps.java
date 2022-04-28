package dev.namtx.leetcode;

import java.util.*;

public class SmallestStringWithSwaps {
    public static void main(String[] args) {
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(new ArrayList<>(Arrays.asList(3, 3)));
        pairs.add(new ArrayList<>(Arrays.asList(3, 0)));
        pairs.add(new ArrayList<>(Arrays.asList(5, 1)));
        pairs.add(new ArrayList<>(Arrays.asList(3, 1)));
        pairs.add(new ArrayList<>(Arrays.asList(3, 4)));
        pairs.add(new ArrayList<>(Arrays.asList(3, 5)));
        System.out.println(new SmallestStringWithSwaps().smallestStringWithSwaps("udyyek", pairs));
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        boolean[] visited = new boolean[s.length()];
        char[] strs = s.toCharArray();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (List<Integer> pair : pairs) {
            if (!Objects.equals(pair.get(0), pair.get(1))) {
                if (!map.containsKey(pair.get(0))) {
                    map.put(pair.get(0), new ArrayList<>());
                }
                if (!map.containsKey(pair.get(1))) {
                    map.put(pair.get(1), new ArrayList<>());
                }
                map.get(pair.get(0)).add(pair.get(1));
                map.get(pair.get(1)).add(pair.get(0));
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                Set<Integer> set = getSet(i, map, visited, new HashSet<>());
                char[] chars = new char[set.size()];
                Integer[] indexes = new Integer[set.size()];
                set.toArray(indexes);
                for (int j = 0; j < set.size(); j++) {
                    chars[j] = s.charAt(indexes[j]);
                }
                Arrays.sort(indexes);
                Arrays.sort(chars);
                for (int j = 0; j < set.size(); j++) {
                    strs[indexes[j]] = chars[j];
                }
            }
        }

        return String.valueOf(strs);
    }

    public Set<Integer> getSet(int i, Map<Integer, List<Integer>> map, boolean[] visited, Set<Integer> set) {
        set.add(i);
        visited[i] = true;
        for (int j : map.getOrDefault(i, new ArrayList<>())) {
            if (!visited[j]) {
                getSet(j, map, visited, set);
            }
        }
        return set;
    }
}
