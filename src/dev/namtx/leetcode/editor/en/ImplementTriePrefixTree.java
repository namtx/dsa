package dev.namtx.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie trie = new ImplementTriePrefixTree().new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode(' ');
        }

        public void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (current.child.containsKey(c)) {
                    current = current.child.get(c);
                } else {
                    TrieNode trieNode = new TrieNode(c);
                    current.child.put(c, trieNode);
                    current = trieNode;
                }
            }
            current.isEndOfWord = true;
        }

        public boolean search(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (!current.child.containsKey(c)) {
                    return false;
                } else {
                    current = current.child.get(c);
                }
            }
            return current.isEndOfWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()) {
                if (!current.child.containsKey(c)) {
                    return false;
                } else {
                    current = current.child.get(c);
                }
            }
            return true;
        }

        class TrieNode {
            char value;
            boolean isEndOfWord;
            Map<Character, TrieNode> child;

            TrieNode(char c) {
                this.value = c;
                this.isEndOfWord = false;
                this.child = new HashMap<>();
            }
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
