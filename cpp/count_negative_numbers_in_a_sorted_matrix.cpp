#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int countNegatives(vector<vector<int>> &grid) {
    int m = grid[0].size();
    int n = grid.size();
    int limit = m;
    int count = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < limit; j++) {
        if (grid[i][j] < 0) {
          count += (n - i) * (limit - j);
          limit = j;
          break;
        }
      }
    }

    return count;
  }
};

int main(int argc, char *argv[]) {
  Solution solution = Solution();
  vector<vector<int>> matrix = {
      {4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
  std::cout << solution.countNegatives(matrix) << std::endl;

  return 0;
}
