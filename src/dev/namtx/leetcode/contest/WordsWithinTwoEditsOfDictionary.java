package dev.namtx.leetcode.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/contest/biweekly-contest-90/problems/words-within-two-edits-of-dictionary/
 */
public class WordsWithinTwoEditsOfDictionary {
    static class TrieNode {
        public Map<Character, TrieNode> children;
        public boolean isEndOfWord;
        public char character;

        public TrieNode(char c) {
            children = new HashMap<>();
            isEndOfWord = false;
            character = c;
        }
    }

    static class Trie {
        public TrieNode root;

        public Trie() {
            root = new TrieNode(' ');
        }

        public void addWord(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new TrieNode(c));
                }
                current = current.children.get(c);
            }
            current.isEndOfWord = true;
        }
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.addWord(word);
        }

        List<String> ans = new ArrayList<>();
        for (String query : queries) {
            if (twoEditWord(query, trie.root, 0, 0)) {
                ans.add(query);
            }
        }

        return ans;
    }

    public boolean twoEditWord(String word, TrieNode root, int i, int edit) {
        if (edit > 2) return false;
        if (i >= word.length()) return root.isEndOfWord;
        for (Map.Entry<Character, TrieNode> e : root.children.entrySet()) {
            if (twoEditWord(word, e.getValue(), i + 1, edit + (e.getKey() == word.charAt(i) ? 0 : 1))) {
                return true;
            }
        }

        return false;
    }
}
