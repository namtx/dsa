#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int minOperations(vector<vector<int>> &grid, int x) {
    int n = grid.size();
    int m = grid[0].size();

    vector<int> num(n * m);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        num[i * m + j] = grid[i][j];
      }
    }
    int ans = 0;

    sort(num.begin(), num.end());

    for (int i = 0; i < m * n; i++) {
      if (abs(num[i] - num[m * n / 2]) % x != 0) {
        return -1;
      } else {
        ans += abs(num[i] - num[m * n / 2]) / x;
      }
    }

    return ans;
  }
};

int main(int argc, char *argv[]) {
  vector<vector<int>> grid = {{1, 2}, {3, 4}};

  cout << (new Solution())->minOperations(grid, 2) << endl;
  return 0;
}
