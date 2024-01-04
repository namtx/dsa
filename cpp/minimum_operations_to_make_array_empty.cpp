#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();

// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/description/?envType=daily-question&envId=2024-01-04
class Solution {
public:
  int minOperations(vector<int> &nums) {
    unordered_map<int, int> c;
    for (auto num : nums) {
      c[num]++;
    }

    int ans = 0;
    for (auto p : c) {
      int operations = calculateOpeartions(p.second);
      if (operations == -1)
        return -1;
      ans += operations;
    }
    return ans;
  }

  int calculateOpeartions(int n) {
    if (n < 2)
      return -1;
    if (n % 3 == 0) {
      return n / 3;
    } else if (n % 3 == 2) {
      return n / 3 + 1;
    } else {
      return 2 + (n - 2) / 3;
    }
  }
};
