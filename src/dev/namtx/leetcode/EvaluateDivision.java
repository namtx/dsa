package dev.namtx.leetcode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class EvaluateDivision {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "e"));
        equations.add(Arrays.asList("b", "e"));
        double[] values = new double[]{4.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "b"));
        queries.add(Arrays.asList("e", "e"));
        queries.add(Arrays.asList("x", "x"));

        System.out.println(Arrays.toString(new EvaluateDivision().calcEquation(equations, values, queries)));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, Double>> map = new ConcurrentHashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            dfs(equations.get(i).get(0), equations.get(i).get(1), values[i], map);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String first = queries.get(i).get(0);
            String second = queries.get(i).get(1);
            double r = map.getOrDefault(first, new ConcurrentHashMap<>()).getOrDefault(second, -1.0);
            result[i] = r;
        }
        return result;
    }

    private void dfs(String first, String second, double value, ConcurrentHashMap<String, ConcurrentHashMap<String, Double>> map) {
        if (map.getOrDefault(first, new ConcurrentHashMap<>()).getOrDefault(second, 0.0) != 0.0) return;
        map.computeIfAbsent(first, k -> new ConcurrentHashMap<>());
        map.computeIfAbsent(second, k -> new ConcurrentHashMap<>());
        map.get(first).put(second, value);
        map.get(first).put(first, 1.0);
        map.get(second).put(first, 1 / value);
        map.get(second).put(second, 1.0);
        for (String s : map.get(first).keySet()) {
            dfs(s, second, 1 / map.get(first).get(s) * value, map);
        }
        for (String s : map.get(second).keySet()) {
            dfs(first,s, value * map.get(second).get(s), map);
        }
    }
}
