#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  vector<bool> checkArithmeticSubarrays(vector<int> &nums, vector<int> &l,
                                        vector<int> &r) {
    vector<bool> ans;

    for (int i = 0; i < r.size(); i++) {
      vector<int> sub(nums.begin() + l[i], nums.begin() + r[i] + 1);
      ans.push_back(true);
    }
    return ans;
  }

private:
  bool check(vector<int> &nums) {
    sort(nums.begin(), nums.end());
    int diff = nums[0] - nums[1];

    for (int i = 1; i < nums.size() - 1; i++) {
      if (nums[i] - nums[i + 1] != diff)
        return false;
    }

    return true;
  }
};
