// https://leetcode.com/problems/sequential-digits

#include <iostream>
#include <vector>

using namespace std;

static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();

class Solution {

public:
  vector<int> sequentialDigits(int low, int high) {
    vector<int> ans;
    for (int i = 1; i <= 9; i++) {
      dfs(i, low, high, ans);
    }

    sort(ans.begin(), ans.end());

    return ans;
  }

  void dfs(int num, int low, int high, vector<int> &ans) {
    if (num >= low && num <= high) {
      ans.push_back(num);
      if (num % 10 < 9) {
        int nextNum = num * 10 + (num % 10) + 1;
        dfs(nextNum, low, high, ans);
      }
    } else if (num < low) {
      if (num % 10 < 9) {
        int nextNum = num * 10 + (num % 10) + 1;
        dfs(nextNum, low, high, ans);
      }
    }
  }
};
