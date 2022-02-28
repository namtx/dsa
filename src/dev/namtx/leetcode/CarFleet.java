package dev.namtx.leetcode;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * Output: 3
 * Explanation:
 * The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12.
 * The car starting at 0 does not catch up to any other car, so it is a fleet by itself.
 * The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
 * Note that no other cars meet these fleets before the destination, so the answer is 3.
 */
public class CarFleet {
    public static void main(String[] args) {
        System.out.println(new CarFleet().carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
    }

    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], (double) (target - position[i]) / speed[i]);
        }

        double currentTime = -1;
        int count = 0;
        for (double time : map.values()) {
            if (time > currentTime) {
                currentTime = time;
                count++;
            }
        }

        return count;
    }
}
