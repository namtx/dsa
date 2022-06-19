package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchSuggestionsSystem {
    public static void main(String[] args) {
        String[] products = new String[]{"bags", "baggage", "banner", "box", "cloths"};
        String searchWord = "bags";
        System.out.println(new SearchSuggestionsSystem().suggestedProducts(products, searchWord));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }
        TrieNode current = trie.root;
        StringBuilder sb = new StringBuilder();
        for (Character c : searchWord.toCharArray()) {
            sb.append(c);
            List<String> ret = new ArrayList<>();
            if (current == null) {
                ans.add(ret);
                continue;
            }
            current = current.children.get(c);
            dfs(ret, current, new StringBuilder(sb));
            ans.add(ret);
        }

        return ans;
    }

    private void dfs(List<String> ret, TrieNode root, StringBuilder sb) {
        if (root == null) return;
        if (ret.size() == 3) return;
        if (root.isEndOfWord) {
            ret.add(sb.toString());
        }
        if (root.children.isEmpty()) return;

        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            TrieNode node = root.children.get(c);
            if (node == null) continue;
            dfs(ret, node, new StringBuilder(sb).append(c));
        }
    }

    static class TrieNode {
        public boolean isEndOfWord;
        public Map<Character, TrieNode> children;

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String s) {
            TrieNode current = root;
            for (char c : s.toCharArray()) {
                current = current.children.computeIfAbsent(c, l -> new TrieNode());
            }
            current.isEndOfWord = true;
        }
    }
}
