package dev.namtx.leetcode;

import java.util.Arrays;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        
        int[] dup = new int[flowerbed.length+2];
        Arrays.fill(dup, 0);
        for (int i = 0; i < flowerbed.length; i++) {
            dup[i+1] = flowerbed[i];
        }
        
        for (int i = 1; i < dup.length - 1;) {
            if (dup[i] == 0 && dup[i-1] == 0 && dup[i+1] == 0) {
                n--;
                
                if (n == 0) {
                    return true;
                }

                dup[i] = 1;
                i += 2;
            } else {
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] flowerbed = new int[] {1,0,0,0,0,0,1};
        int n = 2;
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, n));
    }
}
