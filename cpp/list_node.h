#ifndef LISTNODE_H
#define LISTNODE_H

struct ListNode {
  int val;
  TreeNode* next;
  TreeNode() : val(0), next(nullptr) {}
  TreeNode(int x) : val(x), next(nullptr) {}
  TreeNode(int x, ListNode* next) : val(x), next(next) {}
};

#endif
