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
  int minCost(string colors, vector<int> &neededTime) {
    int total = neededTime[0];
    int max = neededTime[0];
    int cc = 1;
    int cost = 0;

    for (int i = 1; i < neededTime.size(); i++) {
      if (colors[i] == colors[i - 1]) {
        cc++;
        total += neededTime[i];
        max = std::max(max, neededTime[i]);
      } else {
        if (cc > 1) {
          cost += (total - max);
        }
        cc = 1;
        total = neededTime[i];
        max = neededTime[i];
      }
    }
    if (cc > 1) {
      cost += (total - max);
    }

    return cost;
  }
};
