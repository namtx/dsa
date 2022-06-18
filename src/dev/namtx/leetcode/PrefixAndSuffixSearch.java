package dev.namtx.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PrefixAndSuffixSearch {
    public static void main(String[] args) {
        String[] words = new String[]{"cabaabaaaa", "ccbcababac", "bacaabccba", "bcbbcbacaa", "abcaccbcaa", "accabaccaa", "cabcbbbcca", "ababccabcb", "caccbbcbab", "bccbacbcba"};
        System.out.println(new WordFilter(words).f("ab", "abcaccbcaa"));
    }

    static class TrieNode {
        public Map<Character, TrieNode> children;
        public int index;

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

    static class Trie {
        public TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String s, int index) {
            TrieNode current = root;
            for (char l : s.toCharArray()) {
                current = current.children.computeIfAbsent(l, c -> new TrieNode());
                current.index = index;
            }
        }
    }

    static class WordFilter {
        Trie trie;

        public WordFilter(String[] words) {
            this.trie = new Trie();
            for (int i = 0; i < words.length; i++) {
                insert(words[i], i);
            }
        }

        public int f(String prefix, String suffix) {
            String s = suffix + "#" + prefix;
            TrieNode current = trie.root;
            for (char c : s.toCharArray()) {
                current = current.children.get(c);
                if (current == null) return -1;
            }

            return current.index;
        }

        private void insert(String word, int index) {
            char[] chars = word.toCharArray();
            this.trie.insert("#" + word, index);
            StringBuilder sb = new StringBuilder();
            for (int i = chars.length - 1; i >= 0; i--) {
                sb.insert(0, chars[i]);
                this.trie.insert(sb.toString() + "#" + word, index);
            }
        }
    }
}

/**
 * ["WordFilter","f","f","f","f","f","f","f","f","f","f"]
 * [[["cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa","abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"]],["bccbacbcba","a"],["ab","abcaccbcaa"],["a","aa"],["cabaaba","abaaaa"],["cacc","accbbcbab"],["ccbcab","bac"],["bac","cba"],["ac","accabaccaa"],["bcbb","aa"],["ccbca","cbcababac"]]
 */
