// https://leetcode.com/problems/divide-array-into-arrays-with-max-difference

#include <vector>

using namespace std;

class Solution {
public:
  vector<vector<int>> divideArray(vector<int> &nums, int k) {
    std::sort(nums.begin(), nums.end());
    vector<vector<int>> ans;

    for (int i = 0; i < nums.size() / 3; i++) {
      if (nums[i * 3 + 2] - nums[i * 3] > k) {
        return {};
      }
      ans.push_back({nums[i * 3], nums[i * 3 + 1], nums[i * 3 + 2]});
    }

    return ans;
  }
};
