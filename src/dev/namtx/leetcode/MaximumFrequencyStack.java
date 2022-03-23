package dev.namtx.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop());
    }

    static class FreqStack {
        Map<Integer, Integer> frequencies;
        Map<Integer, Stack<Integer>> group;
        int maxFrequencies;

        public FreqStack() {
            frequencies = new HashMap<>();
            group = new HashMap<>();
            maxFrequencies = 0;
        }

        public void push(int val) {
            int f = frequencies.getOrDefault(val, 0) + 1;
            frequencies.put(val, f);
            if (f > maxFrequencies) {
                maxFrequencies = f;
            }

            group.computeIfAbsent(f, newGroup -> new Stack<>()).push(val);
        }

        public int pop() {
            int x = group.get(maxFrequencies).pop();
            frequencies.put(x, frequencies.get(x) - 1);
            if (group.get(maxFrequencies).size() == 0) maxFrequencies--;
            return x;
        }
    }
}
