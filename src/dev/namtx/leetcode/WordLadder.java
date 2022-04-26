package dev.namtx.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count = 0;

        while(!queue.isEmpty()) {
            String word = queue.poll();
            if (word.equals(endWord)) {
                return count;
            }
            for (int i = 0; i < word.length(); i++) {

            }
        }

        return 0;
    }
}
