package dev.namtx.leetcode.contest;

/**
 * https://leetcode.com/contest/weekly-contest-308/problems/minimum-amount-of-time-to-collect-garbage/
 */
public class MinimumAmountOfTimeToCollectGarbage {
    public int garbageCollection(String[] garbage, int[] travel) {
        int[] prefixTravel = new int[garbage.length];
        int mCount = 0;
        int pCount = 0;
        int gCount = 0;
        int mTravel = 0;
        int pTravel = 0;
        int gTravel = 0;

        for (int i = 1; i < garbage.length; i++) {
            prefixTravel[i] = prefixTravel[i - 1] + travel[i - 1];
        }

        for (int i = 0; i < garbage.length; i++) {
            for (char c : garbage[i].toCharArray()) {
                if (c == 'M') {
                    mCount++;
                    mTravel = prefixTravel[i];
                } else if (c == 'P') {
                    pCount++;
                    pTravel = prefixTravel[i];
                } else {
                    gCount++;
                    gTravel = prefixTravel[i];
                }
            }
        }

        return mCount + gCount + pCount + gTravel + pTravel + mTravel;
    }
}
