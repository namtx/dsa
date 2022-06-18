package dev.namtx.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumConsecutiveCardsToPickUp {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])) {
                res = Math.min(res, i - map.get(cards[i])+1);
            }
            map.put(cards[i], i);
        }

        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumConsecutiveCardsToPickUp().minimumCardPickup(new int[]{3,4,2,3,4,7}));
    }
}
