#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Node {
public:
  char c;
  bool isEndOfWord;
  unordered_map<char, Node *> children;

  Node(char _c, bool _isEndOfWord) {
    c = _c;
    isEndOfWord = _isEndOfWord;
  }
};

class MagicDictionary {
public:
  Node *root;
  MagicDictionary() { root = new Node(' ', false); }

  void buildDict(vector<string> dictionary) {
    for (auto word : dictionary) {
      Node *current = root;
      for (char c : word) {
        if (current->children.find(c) == current->children.end()) {
          current->children[c] = new Node(c, false);
        }
        current = current->children[c];
      }
      current->isEndOfWord = true;
    }
  }

  bool search(string searchWord) {
    int i = 0;
    Node *current = root;
    for (auto children : current->children) {
      if (searchByNode(searchWord, 0, children.second, false)) {
        return true;
      }
    }
    return false;
  }

private:
  bool searchByNode(string searchWord, int i, Node *node, bool exact) {
    if (i == searchWord.length() - 1) {
      return (exact && searchWord[i] == node->c && node->isEndOfWord) ||
             (!exact && searchWord[i] != node->c && node->isEndOfWord);
    }

    if (searchWord[i] != node->c && exact) {
      return false;
    }

    for (auto children : node->children) {
      if (searchByNode(searchWord, i + 1, children.second,
                       exact || (searchWord[i] != node->c))) {
        return true;
      }
    }

    return false;
  }
};

int main(int argc, char *argv[]) {
  MagicDictionary dictionary;
  dictionary.buildDict(vector<string>{"hello", "tella", "hella", "leetcode"});
  dictionary.search("hello");
}
