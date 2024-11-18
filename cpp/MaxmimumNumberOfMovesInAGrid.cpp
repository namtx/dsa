#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int maxMoves(vector<vector<int>>& grid) {
    int n = grid.size();
    int m = grid[0].size();
    vector<vector<int>> dp(n, vector<int>(m, 1));

    for (int j = m-1; j >= 0; j--) {
      for (int i = 0; i < n; i++) {
        if (j == m-1) {
          dp[i][j] = 1;
        } else {
          if (grid[i][j] < grid[i][j+1]) {
            dp[i][j] += dp[i][j+1];
          }
          if (i > 0 && grid[i][j] < grid[i-1][j+1]) {
            dp[i][j] += dp[i-1][j];
          }
          if (i < n-1 && grid[i][j] < grid[i+1][j+1]) {
            dp[i][j] += dp[i+1][j];
          }
        }
      }
    }

    // print out the dp table
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
      cout << dp[i][j] << " ";
      }
      cout << endl;
    }

    int max = 0;
    for (int i = 0; i < n; i++) {
      if (dp[i][0] > max) {
        max = dp[i][0];
      }
    }

    return max == 1 ? 0 : max;
  }
};
