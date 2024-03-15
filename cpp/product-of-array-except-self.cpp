// https://leetcode.com/problems/product-of-array-except-self

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
  vector<int> productExceptSelf(vector<int> &nums) {
    int N = nums.size();
    vector<int> ans(N, 1);
    int current = 1;
    for (int i = 0; i < N; i++) {
      ans[i] *= current;
      current *= nums[i];
    }
    current = 1;
    for (int i = N - 1; i >= 0; i--) {
      ans[i] *= current;
      current *= nums[i];
    }
    return ans;
  }
};
