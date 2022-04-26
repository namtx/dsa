package dev.namtx.leetcode;

public class KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int right = max;
        while (left < right) {
            int total = 0;
            int mid = (left + right) / 2;
            for (int pile : piles) {
                if (pile <= mid) {
                    total++;
                    continue;
                }
                if (pile % mid == 0) {
                    total += pile / mid;
                } else {
                    total += pile / mid + 1;
                }
            }
            if (total <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
