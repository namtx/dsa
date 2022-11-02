package dev.namtx.leetcode.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * https://leetcode.com/contest/weekly-contest-317/problems/most-popular-video-creator/
 */
public class MostPopularVideoCreator {
    public static void main(String[] args) {
        String[] creators = new String[]{"alice", "bob", "alice", "chris"};
        String[] ids = new String[]{"one", "two", "three", "four"};
        int[] views = new int[]{5, 10, 5, 4};

        System.out.println(new MostPopularVideoCreator().mostPopularCreator(creators, ids, views));
    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String, Integer> mostViews = new HashMap<>();
        HashMap<String, Long> totalViews = new HashMap<>();
        long max = 0;

        for (int i = 0; i < creators.length; i++) {
            long totalView = views[i] + totalViews.getOrDefault(creators[i], 0L);
            totalViews.put(creators[i], totalView);
            max = Math.max(totalView, max);
            if (mostViews.containsKey(creators[i])) {
                int idx = mostViews.get(creators[i]);
                if (views[i] > views[idx]) {
                    mostViews.put(creators[i], i);
                } else if (views[i] == views[idx] && ids[i].compareTo(ids[idx]) < 0) {
                    mostViews.put(creators[i], i);
                }
            } else {
                mostViews.put(creators[i], i);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (Entry<String, Long> e : totalViews.entrySet()) {
            if (e.getValue() == max) {
                String creator = e.getKey();
                int idx = mostViews.get(creator);
                ans.add(List.of(creator, ids[idx]));
            }
        }

        return ans;
    }
}
