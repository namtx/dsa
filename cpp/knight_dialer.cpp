#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
  unordered_map<string, int> cache;
  const int mod = 1000000007;

public:
  int knightDialer(int n) {
    int ans = 0;
    vector<vector<long>> dp(n + 1, vector<long>(10));

    for (int i = 0; i < 10; i++) {
      dp[1][i] = 1;
    }

    for (int i = 2; i <= n; i++) {
      dp[i][0] = (dp[i - 1][4] % mod + dp[i - 1][6] % mod) % mod;
      dp[i][1] = (dp[i - 1][8] % mod + dp[i - 1][6] % mod) % mod;
      dp[i][2] = (dp[i - 1][7] % mod + dp[i - 1][9] % mod) % mod;
      dp[i][3] = (dp[i - 1][4] % mod + dp[i - 1][8] % mod) % mod;
      dp[i][4] =
          (dp[i - 1][0] % mod + dp[i - 1][3] % mod + dp[i - 1][9] % mod) % mod;
      dp[i][6] =
          (dp[i - 1][0] % mod + dp[i - 1][1] % mod + dp[i - 1][7] % mod) % mod;
      dp[i][7] = (dp[i - 1][2] % mod + dp[i - 1][6] % mod) % mod;
      dp[i][8] = (dp[i - 1][1] % mod + dp[i - 1][3] % mod) % mod;
      dp[i][9] = (dp[i - 1][2] % mod + dp[i - 1][4] % mod) % mod;
    }

    for (int i = 0; i < 10; i++) {
      ans = ((ans % mod) + (dp[n][i]) % mod) % mod;
    }
    return static_cast<int>(ans);
  }
};

int main(int argc, char *argv[]) {
  cout << (new Solution())->knightDialer(3131) << endl;
  return 0;
}
