#include <vector>

using namespace std;
class Solution {
public:
  int minTimeToVisitAllPoints(vector<vector<int>> &points) {
    int ans = 0;
    for (int i = 1; i < points.size(); i++) {
      ans += minTime(points[i], points[i - 1]);
    }
    return ans;
  }

  int minTime(vector<int> a, vector<int> b) {
    int diffX = abs(a[0] - b[0]);
    int diffY = abs(a[1] - b[1]);

    return max(diffX, diffY);
  }
};
