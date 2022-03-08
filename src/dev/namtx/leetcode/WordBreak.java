package dev.namtx.leetcode;

import dev.namtx.ds.Trie;
import dev.namtx.ds.TrieNode;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(
                new WordBreak().wordBreak("aaaaaaa", Arrays.asList("aaaa", "aa"))
        );
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();

        for (String w : wordDict) trie.insert(w);

        boolean[] searched = new boolean[s.length()];
        return helper(s, trie, searched, 0);
    }

    private boolean helper(String s, Trie trie, boolean[] searched, int start) {
        if (start == s.length()) return true;
        TrieNode current = trie.root;
        for (int i = start; i < s.length(); i++) {
            current = current.children.get(s.charAt(i));
            if (current == null) break;
            if (current.isEndOfWord && !searched[i]) {
                searched[i] = true;
                if (helper(s, trie, searched, i + 1)) return true;
            }
        }

        return false;
    }
}
