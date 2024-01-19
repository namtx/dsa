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
  int minFallingPathSum(vector<vector<int>> &matrix) {
    int n = matrix.size();
    int m = matrix[0].size();
    vector<vector<int>> dp(n, vector<int>(m, 0));
    for (int i = 0; i < m; i++) {
      dp[0][i] = matrix[0][i];
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // top
        int top = dp[i - 1][j];
        int left = j > 0 ? dp[i - 1][j - 1] : INT_MAX;
        int right = j < m - 1 ? dp[i - 1][j + 1] : INT_MAX;

        dp[i][j] = matrix[i][j] + min(top, min(left, right));
      }
    }

    int min = INT_MAX;
    for (int i = 0; i < m; i++) {
      min = std::min(min, dp[n - 1][i]);
    }
    return min;
  }
};
