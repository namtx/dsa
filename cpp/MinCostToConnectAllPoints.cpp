#include <iostream>
#include <vector>
#include <queue>

using namespace std;

auto comp = [](pair<int, int> a, pair<int, int> b) {
  return a.second > b.second;
};

class Solution {
public:
  int minCostConnectPoints(vector<vector<int>>& points) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(comp)> q(comp);
    q.push({0, 0});

    vector<int> minDist = vector<int>(points.size(), INT_MAX);
    int visited = 0;
    int ans = 0;

    while (visited < points.size()) {
      auto [node, dist] = q.top();
      q.pop();

      if (minDist[node] == -1) {
        continue;
      }
      minDist[node] = -1; // visited

      visited++;
      ans += dist;
      for (auto i = 0; i < points.size(); i++) {
        if (minDist[i] == -1) {
          continue;
        }
        int d = abs(points[node][0] - points[i][0]) + abs(points[node][1] - points[i][1]);
        if (d < minDist[i]) {
          minDist[i] = d;
          q.push({i, d});
        }
      }
    }

    return ans;
  }
};

int main() {
  Solution s;
  vector<vector<int>> points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
  int ans = s.minCostConnectPoints(points);
  cout << "ans: " << ans << endl;
  return 0;
}
