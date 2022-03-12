package dev.namtx.lintcode;

public class WateringFlowers {
    public static void main(String[] args) {
        System.out.println(new WateringFlowers().waterPlants(new int[]{2, 4, 5, 1, 2}, 5, 7));
        System.out.println(new WateringFlowers().waterPlants(new int[]{11, 1, 1, 11}, 11, 12));
        System.out.println(new WateringFlowers().waterPlants(new int[]{43, 48, 29}, 49, 34));
    }

    public int waterPlants(int[] plants, int capacity1, int capacity2) {
        int left = 0;
        int right = plants.length - 1;
        int count1 = 1;
        int count2 = 1;
        int current1 = capacity1;
        int current2 = capacity2;
        int remain1 = capacity1 - plants[left];
        int remain2 = capacity2 - plants[right];
        while (left < plants.length / 2 - 1) {
            remain1 = current1 - plants[left];
            if (remain1 < plants[left + 1]) {
                count1++; // refill
                current1 = capacity1;
            } else {
                current1 = remain1;
            }
            remain2 = current2 - plants[right];
            if (remain2 < plants[right - 1]) {
                count2++;
                current2 = capacity2;
            } else {
                current2 = remain2;
            }
            left++;
            right--;
        }

        if (plants.length % 2 != 0) {
            if (remain1 + remain2 < plants[plants.length / 2]) {
                return count1 + count2 + 1;
            }
        }

        return count1 + count2;
    }
}

