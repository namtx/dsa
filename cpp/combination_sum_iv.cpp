#include <iostream>
#include <set>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
  int combinationSum4(vector<int> &nums, int target) {
    if (target < 0)
      return 0;
    if (target == 0)
      return 1;

    vector<int> dp(target + 1, 0);
    dp[0] = 1;

    for (int i = 1; i <= target; i++) {
      long long ans = 0;
      for (int j = 0; j < nums.size(); j++) {
        if (i - nums[j] >= 0) {
          ans += dp[i - nums[j]];
        }
      }
      dp[i] = ans;
    }

    return dp[target];
  }
};

int main(int argc, char *argv[]) {
  Solution s;

  vector<int> v = {4, 2, 1};
  cout << s.combinationSum4(v, 8) << endl;
  return 0;
}
