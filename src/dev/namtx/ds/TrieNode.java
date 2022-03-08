package dev.namtx.ds;

import java.util.HashMap;

public class TrieNode {
    public HashMap<Character, TrieNode> children;
    public boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
    }
}
