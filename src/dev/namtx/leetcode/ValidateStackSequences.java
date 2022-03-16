package dev.namtx.leetcode;

public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushed = new int[]{0, 1};
        int[] popped = new int[]{1, 0};
        System.out.println(new ValidateStackSequences().validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushPointer = 0;
        int popPointer = 0;
        boolean[] processed = new boolean[1001];

        while (pushPointer > 0 || popPointer < popped.length - 1) {
            while (pushPointer < pushed.length && pushed[pushPointer] != popped[popPointer]) {
                pushPointer++;
            }
            if (pushPointer == pushed.length) return false;
            processed[pushed[pushPointer]] = true;
            while(pushPointer > 0 && processed[pushed[pushPointer]]) {
                pushPointer--;
            }
            popPointer++;
        }

        return true;
    }
}
