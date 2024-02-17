// https://leetcode.com/problems/furthest-building-you-can-reach

#include <iostream>
#include <queue>
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
  int furthestBuilding(vector<int> &heights, int bricks, int ladders) {
    priority_queue<int> p;

    int i = 0, diff = 0;
    for (i = 0; i < heights.size() - 1; i++) {

      diff = heights[i + 1] - heights[i];

      if (diff <= 0) {
        continue;
      }

      bricks -= diff;
      p.push(diff);

      if (bricks < 0) {
        bricks += p.top();
        p.pop();
        ladders--;
      }

      if (ladders < 0)
        break;
    }

    return i;
  }
};

int main(int argc, char *argv[]) {
  vector<int> heights = {4, 12, 2, 7, 3, 18, 20, 3, 19};
  cout << (new Solution())->furthestBuilding(heights, 10, 2) << endl;
  return 0;
}
