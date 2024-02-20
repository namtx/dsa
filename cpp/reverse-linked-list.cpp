// https://leetcode.com/problems/reverse-linked-list

#include <iostream>

using namespace std;

static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();

struct ListNode {
  int val;
  ListNode *next;
  ListNode() : val(0), next(nullptr) {}
  ListNode(int x) : val(x), next(nullptr) {}
  ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
  ListNode *reverseList(ListNode *head) {
    ListNode *prev = nullptr;
    ListNode *current = head;
    while (current != nullptr) {
      ListNode *next = current->next;
      current->next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }
};

int main(int argc, char *argv[]) {
  ListNode *head = new ListNode(1, new ListNode(2, new ListNode(3)));

  (new Solution())->reverseList(head);

  while (head != nullptr) {
    cout << head->val << "->";
    head = head->next;
  }
  cout << endl;
  return 0;
}
