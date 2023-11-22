#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class Solution {
public:
  vector<int> findDiagonalOrder(vector<vector<int>> &nums) {
    vector<int> ans;
    queue<pair<int, int>> q; // pair<row, col>
    q.push({0, 0});

    while (!q.empty()) {
      int r = q.front().first;
      int c = q.front().second;
      cout << r << ", " << c << endl;
      ans.push_back(nums[r][c]);

      q.pop();
      if (c == 0 && r + 1 < nums.size()) {
        q.push({r + 1, c});
      }
      if (c + 1 < nums[r].size()) {
        q.push({r, c + 1});
      }
    }

    return ans;
  }
};

int main(int argc, char *argv[]) {
  vector<vector<int>> nums = {
      {1, 2, 3, 4, 5}, {6, 7}, {8}, {9, 10, 11}, {12, 13, 14, 15, 16}};

  for (auto num : (new Solution())->findDiagonalOrder(nums)) {
    cout << num << ", ";
  }

  return 0;
}
