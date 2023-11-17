#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int minPairSum(vector<int> &nums) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    sort(nums.begin(), nums.end());

    int l = 0;
    int r = nums.size() - 1;
    int max = 0;

    while (l < r) {
      max = std::max(max, nums[l++] + nums[r--]);
    }

    return max;
  }
};

int main(int argc, char *argv[]) {
  vector<int> nums = {1, 1};
  cout << (new Solution())->minPairSum(nums) << endl;
  return 0;
}
