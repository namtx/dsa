package dev.namtx.leetcode;

import java.util.*;

public class ThreeSumWithMultiplicity {
    public int threeSumMulti(int[] arr, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        Map<Integer, List<Integer>> occurenceMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> occurences = occurenceMap.getOrDefault(arr[i], new ArrayList<>());
            occurences.add(i);
            occurenceMap.put(arr[i], occurences);
            m.put(arr[i], m.getOrDefault(arr[i], 0)+1);
        }
        Arrays.sort(arr);

        int ans = 0;

        for (int i = 0; i < arr.length-2; i++) {
            if (i > 0 && arr[i] == arr[i-1]) continue;
            int left = i+1;
            int right = arr.length-1;
            while(left < right) {
                if (arr[left] + arr[right] == target - arr[i]) {
                    System.out.println("(" + arr[i] + ", " + arr[left] + ", " + arr[right]);
                    if (arr[i] != arr[left] && arr[i] != arr[right] && arr[left] != arr[right]) {
                        for (int oci: occurenceMap.get(arr[i])) {
                            for (int occleft: occurenceMap.get(arr[left])) {
                                for (int occright: occurenceMap.get(arr[right])) {
                                    if (oci < occleft && occleft < occright) {
                                        ans++;
                                    }
                                }
                            }
                        }
                    } else if (arr[i] == arr[left] && arr[i] == arr[right]) {
                        for (int oci: occurenceMap.get(arr[left])) {
                            for (int occleft: occurenceMap.get(arr[left])) {
                                for (int occright: occurenceMap.get(arr[left])) {
                                    if (oci < occleft && occleft < occright) {
                                        ans++;
                                    }
                                }
                            }
                        }
                    } else if (arr[i] == arr[left]) {
                        for (int oci: occurenceMap.get(arr[i])) {
                            for (int occleft: occurenceMap.get(arr[i])) {
                                for (int occright: occurenceMap.get(arr[right])) {
                                    if (oci < occleft && occleft < occright) {
                                        ans++;
                                    }
                                }
                            }
                        }
                    } else if (arr[left] == arr[right]) {
                        for (int oci: occurenceMap.get(arr[i])) {
                            for (int occleft: occurenceMap.get(arr[left])) {
                                for (int occright: occurenceMap.get(arr[left])) {
                                    if (oci < occleft && occleft < occright) {
                                        ans++;
                                    }
                                }
                            }
                        }
                    }
                    while(left < right && arr[left]== arr[left+1]) left++;
                    while(left < right && arr[right] == arr[right-1]) right--;
                    left++;
                    right--;
                } else if (arr[left] + arr[right] > target-arr[i]) {
                    right--;
                } else left++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumWithMultiplicity().threeSumMulti(new int[]{1,1,2,2,3,3,4,4,5,5}, 8));
    }
}
