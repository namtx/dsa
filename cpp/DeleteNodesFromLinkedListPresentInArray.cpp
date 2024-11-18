#include <vector>
#include <iostream>
#include <unordered_set>
#include "list_node.h"

using namespace std;


class Solution {
public:
  ListNode* modifiedList(vector<int>& nums, ListNode* head) {
    // init set from nums
    unordered_set<int> numSet(nums.begin(), nums.end());

    ListNode* dummy = new ListNode(0);
    dummy->next = head;
    ListNode* newHead = dummy;

    while(dummy->next) {
      if (numSet.find(dummy->next->val) != numSet.end()) {
        dummy->next = dummy->next->next;
      } else {
        dummy = dummy->next;
      }
    }

    return newHead->next;
  }
};

