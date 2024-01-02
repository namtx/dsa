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
  vector<vector<int>> findMatrix(vector<int> &nums) {
    vector<vector<int>> ans = vector<vector<int>>();
    int max = 0;
    vector<int> c(201, 0);
    for (int i = 0; i < nums.size(); i++) {
      int num = nums[i];
      c[num]++;
      if (c[num] > max) {
        ans.push_back(vector<int>());
        max = c[num];
      }
      ans[c[num] - 1].push_back(num);
    }

    return ans;
  }
};
