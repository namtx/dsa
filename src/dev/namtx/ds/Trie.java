package dev.namtx.ds;

public class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("Programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("life");

        trie.delete("life");

        System.out.println(trie.contains("way"));
    }

    public void insert(String s) {
        TrieNode current = root;
        for (char l : s.toCharArray()) {
            current = current.children.computeIfAbsent(l, c -> new TrieNode());
        }
        current.isEndOfWord = true;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    public boolean contains(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if (node == null) return false;

            current = node;
        }
        return current.isEndOfWord;
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord) {
                return false;
            }

            current.isEndOfWord = false;
            return current.children.isEmpty();
        }

        char c = word.charAt(index);
        TrieNode node = current.children.get(c);
        if (node == null) return false;

        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord;
        if (shouldDeleteCurrentNode) {
            current.children.remove(c);
            return current.children.isEmpty();
        }

        return false;
    }
}
