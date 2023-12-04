#include <iostream>
#include <unordered_map>

using namespace std;

class Node {
public:
  int key;
  int val;
  Node *prev;
  Node *next;

  Node(int key, int val) {
    this->key = key;
    this->val = val;
  }
};

class LRUCache {
public:
  LRUCache(int capacity) {
    this->capacity = capacity;
    head = new Node(0, 0);
    tail = new Node(0, 0);
    head->next = tail;
    tail->prev = head;
    size = 0;
  }

  int get(int key) {
    if (cache.find(key) != cache.end()) {
      Node *node = cache[key];
      deleteNode(node);
      addToHead(node);
      return cache[key]->val;
    }
    return -1;
  }

  void put(int key, int value) {
    Node *newNode = new Node(key, value);
    if (cache.find(key) != cache.end()) {
      deleteNode(cache[key]);
      cache[key] = newNode;
      addToHead(newNode);
    } else {
      if (size == capacity) {
        cache.erase(tail->prev->key);
        deleteNode(tail->prev);
        cache[key] = newNode;
        addToHead(newNode);
      } else {
        cache[key] = newNode;
        addToHead(newNode);
        size++;
      }
    }
  }

private:
  unordered_map<int, Node *> cache;
  Node *head;
  Node *tail;
  int capacity;
  int size;

  void deleteNode(Node *node) {
    node->prev->next = node->next;
    node->next->prev = node->prev;
  }

  void addToHead(Node *node) {
    node->next = head->next;
    node->next->prev = node;
    node->prev = head;
    head->next = node;
  }
};

int main(int argc, char *argv[]) {
  LRUCache lru = LRUCache(1);
  lru.put(2, 1);
  cout << lru.get(2) << endl;

  return 0;
}
