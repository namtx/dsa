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
  int MAX = 1e9;
  int minDifficulty(vector<int> &jobDifficulty, int d) {
    if (jobDifficulty.size() < d)
      return -1;
    int n = jobDifficulty.size();
    vector<vector<int>> dp(n + 1, vector<int>(d + 1, MAX));
    dp[n][0] = 0;

    for (int i = n - 1; i >= 0; i--) {
      for (int j = 1; j <= d; j++) {
        int max = 0;
        int ans = 1e9;
        for (int k = i; k < n; k++) {
          max = std::max(max, jobDifficulty[k]);
          int res = dp[k + 1][j - 1];
          if (res != MAX) {
            ans = std::min(ans, max + res);
          }
        }
        dp[i][j] = ans;
      }
    }

    return dp[0][d];
  }
};

int main(int argc, char *argv[]) {
  vector<int> jobDifficulty = {7, 1, 7, 1, 7, 1};
  cout << (new Solution())->minDifficulty(jobDifficulty, 3);
  return 0;
}
