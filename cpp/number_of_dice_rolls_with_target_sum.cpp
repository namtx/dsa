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
  int mod = 1e9 + 7;
  int numRollsToTarget(int n, int k, int target) {
    vector<vector<long>> dp(n + 1, vector<long>(target + 1, 0));

    for (int i = 1; i <= min(target, k); i++) {
      dp[1][i] = 1;
    }

    for (int i = 2; i <= n; i++) {
      for (int j = i; j <= min(i * k, target); j++) {
        for (int l = 1; l <= min(target, k); l++) {
          dp[i][j] = (dp[i - 1][j - l] + dp[i][j]) % mod;
        }
      }
    }

    return static_cast<int>(dp[n][target]);
  }
};

int main(int argc, char *argv[]) {
  cout << (new Solution())->numRollsToTarget(2, 6, 7) << endl;
}
