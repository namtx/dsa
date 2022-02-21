package dev.namtx.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int idx = 0;
        Deque<Integer> dequeue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!dequeue.isEmpty() && dequeue.peek() < i - k + 1) {
                dequeue.poll();
            }
            while (!dequeue.isEmpty() && nums[dequeue.peekLast()] < nums[i]) {
                dequeue.pollLast();
            }
            dequeue.offer(i);
            if (i >= k - 1) {
                ans[idx++] = nums[dequeue.peek()];
            }
        }

        return ans;
    }
}
