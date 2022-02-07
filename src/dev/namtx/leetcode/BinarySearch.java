package dev.namtx.leetcode;

/**
 * https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        TestCase[] testCases = {
                new TestCase(new int[]{1, 0, 3, 5, 9, 12}, 5),
                new TestCase(new int[]{-1, 0, 3, 5, 9, 12}, 2),
        };

        for (TestCase testCase : testCases) {
            System.out.println(binarySearch.search(testCase.nums, testCase.target));
        }
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            mid = (left + right) / 2;
        }

        return -1;
    }

    static class TestCase {
        int[] nums;
        int target;

        public TestCase(int[] nums, int target) {
            this.nums = nums;
            this.target = target;
        }
    }
}

