#include <iostream>
#include <vector>

using namespace std;

static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();

// using prefix-sum to calculate the total time to go to next stop
class Solution {
public:
  int garbageCollection(vector<string> &garbage, vector<int> &travel) {
    vector<int> prefixSum = vector<int>(garbage.size());

    for (int i = 1; i < prefixSum.size(); i++) {
      prefixSum[i] = prefixSum[i - 1] + travel[i - 1];
    }

    int total = 0;
    int glassTravelTime = 0;
    int metalTravelTime = 0;
    int paperTravelTime = 0;

    for (int i = 0; i < garbage.size(); i++) {
      int glassCount = 0;
      int metalCount = 0;
      int paperCount = 0;
      for (char c : garbage[i]) {
        switch (c) {
        case 'G':
          glassCount++;
          break;
        case 'M':
          metalCount++;
          break;
        case 'P':
          paperCount++;
          break;
        }
      }

      if (glassCount > 0) {
        total += glassCount + prefixSum[i] - glassTravelTime;
        glassTravelTime = prefixSum[i];
      }
      if (metalCount > 0) {
        total += metalCount + prefixSum[i] - metalTravelTime;
        metalTravelTime = prefixSum[i];
      }
      if (paperCount > 0) {
        total += paperCount + prefixSum[i] - paperTravelTime;
        paperTravelTime = prefixSum[i];
      }
    }

    return total;
  }
};

int main(int argc, char *argv[]) {
  vector<string> garbage = {"G", "P", "GP", "GG"};
  vector<int> travel = {2, 4, 3};

  cout << (new Solution())->garbageCollection(garbage, travel) << endl;
  return 0;
}
