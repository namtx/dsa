// https://leetcode.com/problems/custom-sort-string

#include <iostream>
#include <set>
#include <unordered_map>

using namespace std;

static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();

class Solution {
public:
  string customSortString(string order, string s) {
    unordered_map<char, int> occurences;
    for (auto c : s) {
      occurences[c]++;
    }

    int pointer = 0;
    set<char> orderSet = set<char>(order.begin(), order.end());
    string ans = s;
    for (auto c : order) {
      if (occurences.find(c) != occurences.end()) {
        for (int i = 0; i < occurences[c]; i++) {
          ans[pointer++] = c;
        }
      }
    }
    for (auto p : occurences) {
      if (orderSet.find(p.first) == orderSet.end()) {
        for (int i = 0; i < p.second; i++) {
          ans[pointer++] = p.first;
        }
      }
    }

    return ans;
  }
};
