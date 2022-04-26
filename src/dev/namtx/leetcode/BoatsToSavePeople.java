package dev.namtx.leetcode;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int i = 0;
        int j = people.length-1;

        while(i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            ans++;
            j--;
        }

        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new BoatsToSavePeople().numRescueBoats(new int[]{1,2}, 3));
//        System.out.println(new BoatsToSavePeople().numRescueBoats(new int[]{1,2,4,5}, 6));
        System.out.println(new BoatsToSavePeople().numRescueBoats(new int[]{3,5,3,4}, 5));
        System.out.println(new BoatsToSavePeople().numRescueBoats(new int[]{3,2,3,2,2}, 6));
    }
}
