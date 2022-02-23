package dev.namtx.leetcode;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(
                new SearchA2DMatrix().searchMatrix(matrix, 13)
        );
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0;
        int bottom = n - 1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if (matrix[mid][0] <= target && matrix[mid][m - 1] >= target) {
                return binarySearch(matrix[mid], target);
            } else if (matrix[mid][0] > target) {
                bottom = mid - 1;
            } else if (matrix[mid][m - 1] < target) {
                top = mid + 1;
            }
        }

        return false;
    }

    public boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return true;
            if (arr[mid] > target) right = mid - 1;
            if (arr[mid] < target) left = mid + 1;
        }

        return false;
    }
}
