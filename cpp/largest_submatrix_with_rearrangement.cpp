#include <bits/stdc++.h>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int largestSubmatrix(vector<vector<int>> &matrix) {
    int n = matrix.size();
    int m = matrix[0].size();
    int ans = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] != 0 && i > 0) {
          matrix[i][j] += matrix[i - 1][j];
        }
      }

      vector<int> row = vector<int>(m);
      for (int j = 0; j < m; j++) {
        row.push_back(matrix[i][j]);
      }
      sort(row.begin(), row.end(), greater<int>());

      int consecutiveRow = 0;
      for (int i = 0; i < row.size(); i++) {
        if (row[i] != 0) {
          consecutiveRow++;
          ans = max(ans, consecutiveRow * row[i]);
        } else {
          consecutiveRow = 0;
        }
      }
    }

    return ans;
  }
};

int main(int argc, char *argv[]) {
  vector<vector<int>> matrix = {
      {1, 0, 1, 0, 1}, {0, 0, 1, 1, 1}, {1, 0, 1, 1, 1}};

  cout << (new Solution())->largestSubmatrix(matrix) << endl;
  return 0;
}
