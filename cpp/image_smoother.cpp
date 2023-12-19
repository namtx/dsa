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
  vector<vector<int>> imageSmoother(vector<vector<int>> &img) {
    vector<vector<int>> r(img.size(), vector<int>(img[0].size()));
    int n = img.size();
    int m = img[0].size();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int ans = img[i][j];
        int count = 1;
        for (int x = -1; x <= 1; x++) {
          for (int y = -1; y <= 1; y++) {
            if (x == 0 && y == 0) {

            } else {
              if (valid(i + x, j + y, n, m)) {
                ans += img[i + x][j + y];
                count++;
              }
            }
          }
        }

        r[i][j] = ans / count;
      }
    }

    return r;
  }

  bool valid(int i, int j, int n, int m) {
    if (i < 0 || j < 0 || i >= n || j >= m)
      return false;

    return true;
  }
};
