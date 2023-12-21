#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();

bool comp(vector<int> v1, vector<int> v2) { return v1[0] > v2[0]; }

class Solution {
public:
  int maxWidthOfVerticalArea(vector<vector<int>> &points) {
    sort(points.begin(), points.end(), comp);

    int widest = 0;
    for (int i = 1; i < points.size(); i++) {
      int wide = points[i][0] - points[i - 1][0];
      if (wide > widest) {
        widest = wide;
      }
    }
    return widest;
  }
};
