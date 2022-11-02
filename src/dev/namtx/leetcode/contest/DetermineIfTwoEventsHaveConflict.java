package dev.namtx.leetcode.contest;

import java.util.Arrays;
import java.util.Comparator;

public class DetermineIfTwoEventsHaveConflict {
    public static void main(String[] args) {
        System.out.println(new DetermineIfTwoEventsHaveConflict().haveConflict(
                new String[]{"01:15","02:00"},
                new String[]{"02:00","03:00"}
        ));
    }

    public boolean haveConflict(String[] event1, String[] event2) {
        String[][] arr = new String[][]{event1, event2};
        Arrays.sort(arr, Comparator.comparing(o -> o[0]));
        return arr[1][0].compareTo(arr[0][1]) <= 0;
    }
}
