package dev.namtx.leetcode.daily;

import java.util.Arrays;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        return canPlaceFlowers(flowerbed, 0, n);
    }

    private boolean canPlaceFlowers(int[] flowerbed, int i, int n) {
        if (n == 0) return true;
        if (n > 0 && i >= flowerbed.length) return false;
        if (flowerbed[i] == 1) {
            return canPlaceFlowers(flowerbed, i+1, n);
        } else {
            if ((i >= 1 && flowerbed[i-1] == 1) || (i < flowerbed.length-1 && flowerbed[i+1] == 1)) { // cannot place
                return canPlaceFlowers(flowerbed, i+1, n);
            } else { // try to place
                int[] cloned = Arrays.copyOf(flowerbed, flowerbed.length);
                cloned[i] = 1;
                return canPlaceFlowers(cloned, i+1, n-1) || canPlaceFlowers(flowerbed, i+1, n);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
    }
}
