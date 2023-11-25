#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  vector<int> getSumAbsoluteDifferences(vector<int> &nums) {
    vector<int> prefixSum = vector<int>(nums.size());
    vector<int> suffixSum = vector<int>(nums.size());

    for (int i = 1; i < nums.size(); i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
    }
    for (int i = nums.size() - 2; i >= 0; i--) {
      suffixSum[i] = suffixSum[i + 1] + nums[i + 1];
    }
    vector<int> ans = vector<int>(nums.size());

    for (int i = 0; i < nums.size(); i++) {
      ans[i] = (i * nums[i]) - prefixSum[i] +
               (suffixSum[i] - nums[i] * (nums.size() - i - 1));
    }

    return ans;
  }
};

int main(int argc, char *argv[]) {
  vector<int> nums = {1, 4, 6, 8, 10};
  auto ans = (new Solution())->getSumAbsoluteDifferences(nums);

  for (auto i : ans) {
    cout << i << ", ";
  }

  cout << endl;

  return 0;
}
