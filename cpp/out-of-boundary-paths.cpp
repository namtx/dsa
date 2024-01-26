// https://leetcode.com/problems/out-of-boundary-paths

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
  long paths = 0;
  long mod = 1e9 + 7;
  vector<vector<int>> dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
  int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    if (maxMove == 0)
      return 0;
    vector<vector<vector<long>>> dp(
        m, vector<vector<long>>(n, vector<long>(maxMove + 1, 0)));

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        long p = 0;
        for (auto dir : dirs) {
          if (i + dir[0] < 0 || i + dir[0] >= m)
            p++;
          if (j + dir[1] < 0 || j + dir[1] >= n)
            p++;
        }
        dp[i][j][1] = p != 0 ? p : -1;
      }
    }

    for (int move = 2; move <= maxMove; move++) {
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          for (auto dir : dirs) {
            int di = i + dir[0];
            int dj = j + dir[1];
            if (di >= 0 && di < m && dj >= 0 && dj < n &&
                dp[di][dj][move - 1] != -1) {
              dp[i][j][move] = (dp[i][j][move] + dp[di][dj][move - 1]) % mod;
            }
          }
        }
      }
    }

    for (int move = 1; move <= maxMove; move++) {
      if (dp[startRow][startColumn][move] != -1) {
        paths = (paths + dp[startRow][startColumn][move]) % mod;
      }
    }

    return static_cast<int>(paths);
  }
};

int main(int argc, char *argv[]) {
  cout << (new Solution())->findPaths(2, 2, 2, 0, 0);
  return 0;
}
