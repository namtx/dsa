#include <climits>
#include <deque>
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();

vector<vector<int>> dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
class Solution {
public:
  int minimumObstacles(vector<vector<int>> &grid) {
    int n = grid.size();
    int m = grid[0].size();

    this->grid = grid;
    this->dp = vector<vector<int>>(n, vector<int>(m, INT_MAX));
    this->visited = vector<vector<bool>>(n, vector<bool>(m, false));

    bfs();

    return dp[n - 1][m - 1];
  }

private:
  vector<vector<int>> grid;
  vector<vector<bool>> visited;
  vector<vector<int>> dp;
  deque<pair<int, int>> q;

  void bfs() {
    q.push_front({0, 0});
    visited[0][0] = true;
    dp[0][0] = 0;
    while (!q.empty()) {
      auto current = q.front();
      q.pop_front();
      int x = current.first, y = current.second;

      for (auto dir : dirs) {
        int dx = x + dir[0];
        int dy = y + dir[1];
        if (valid({dx, dy})) {
          visited[dx][dy] = true;
          if (grid[dx][dy] == 1) {
            dp[dx][dy] = dp[x][y] + 1;
            q.push_back({dx, dy});
          } else {
            dp[dx][dy] = dp[x][y];
            q.push_front({dx, dy});
          }
        }
      }
    }
  }

  bool valid(pair<int, int> p) {
    return (p.first >= 0 && p.second >= 0 && p.first < grid.size() &&
            p.second < grid[0].size() && !visited[p.first][p.second]);
  }
};

int main(int argc, char *argv[]) {
  vector<vector<int>> grid = {
      {0, 1, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 0}};

  cout << (new Solution())->minimumObstacles(grid) << endl;
}
