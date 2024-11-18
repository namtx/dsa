#include <vector>


class Solution {
public:
  long long maximumImportance(int n, vector<vector<int>>& roads) {
    vector<pair<int, int>> points;
    for (int i = 0; i < n; i++) {
      points.push_back({i, 0});
    }

    for (auto &road: roads) {
      points[road[0]] = {road[0], points[road[0]].second + 1};
      points[road[1]] = {road[1], points[road[1]].second + 1};
    }

    sort(points.begin(), points.end(), [](pair<int, int> &a, pair<int, int> &b) {
      return a.second > b.second;
    });
    vector<int> importances(n, 0);
    for (auto i = 0; i < n; i++) {
      importances.push_back(points[i].first);
    }
    int sum = 0;
    for (auto &road: roads) {
      sum += importances[road[0]] + importances[road[1]] + 2;
    }
    return sum;
  }
};

