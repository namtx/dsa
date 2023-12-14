#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  vector<vector<int>> onesMinusZeros(vector<vector<int>> &grid) {
    vector<int> onesRow(grid.size(), 0);
    vector<int> onesCol(grid[0].size(), 0);
    vector<int> zeroesRow(grid.size(), 0);
    vector<int> zeroesCol(grid[0].size(), 0);

    for (int i = 0; i < grid.size(); i++) {
      for (int j = 0; j < grid[0].size(); j++) {
        if (grid[i][j] == 0) {
          zeroesRow[i]++;
          zeroesCol[j]++;
        } else {
          onesCol[j]++;
          onesRow[i]++;
        }
      }
    }
    for (int i = 0; i < grid.size(); i++) {
      for (int j = 0; j < grid[0].size(); j++) {
        cout << " " << grid[i][j];
      }
      cout << endl;
    }

    vector<vector<int>> ans(grid.size(), vector<int>(grid[0].size(), 0));

    for (int i = 0; i < grid.size(); i++) {
      for (int j = 0; j < grid[0].size(); j++) {
        ans[i][j] = onesRow[i] + onesCol[j] - zeroesRow[i] - zeroesCol[j];
      }
    }

    return ans;
  }
};
