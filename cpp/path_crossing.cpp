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
  bool isPathCrossing(string path) {
    vector<vector<bool>> visited(10000, vector<bool>(10000, false));
    int i = 5000, j = 5000;
    visited[i][j] = true;
    for (auto c : path) {
      if (c == 'N') {
        i--;
      } else if (c == 'S') {
        i++;
      } else if (c == 'E') {
        j++;
      } else {
        j--;
      }
      if (visited[i][j])
        return true;

      visited[i][j] = true;
    }

    return false;
  }
};
