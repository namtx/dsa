package dev.namtx.leetcode;

public class CountCollisionsOnARoad {
    public int countCollisions(String directions) {
        int ans = 0;
        char[] directionsArray = directions.toCharArray();
        int sameDirection = 0;

        int j = 0;
        while(j < directionsArray.length && directionsArray[j] == 'L') j++;
        for (int i = j; i < directionsArray.length; i++) {
            if (directionsArray[i] == 'R' && i == directionsArray.length-1) continue;
            if (directionsArray[i] == 'L' && i == 0) continue;
            if (directionsArray[i] == 'R') {
                if (directionsArray[i+1] == 'L') {
                    ans+= 2;
                    ans += sameDirection;
                    sameDirection = 0;
                    directionsArray[i] = 'S';
                    directionsArray[i+1] = 'S';
                } else if (directionsArray[i+1] == 'S') {
                    directionsArray[i] = 'S';
                    ans += 1;
                    ans += sameDirection;
                    sameDirection = 0;
                } else {
                    sameDirection++;
                }
            } else if (directionsArray[i] == 'L') {
                if (directionsArray[i-1] == 'R') {
                    ans+= 2;
                    ans += sameDirection;
                    sameDirection = 0;
                    directionsArray[i] = 'S';
                    directionsArray[i-1] = 'S';
                } else if (directionsArray[i-1] == 'S') {
                    directionsArray[i] = 'S';
                    ans += 1;
                    ans += sameDirection;
                    sameDirection = 0;
                } else {
                    sameDirection++;
                }
            } else {
                sameDirection = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CountCollisionsOnARoad().countCollisions("LLRLRLLSLRLLSLSSSS"));
    }
}
