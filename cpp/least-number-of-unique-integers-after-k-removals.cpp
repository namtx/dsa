// https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals

#include <iostream>
#include <unordered_map>
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
  int findLeastNumOfUniqueInts(vector<int> &arr, int k) {
    unordered_map<int, int> occurencesCount;
    for (auto num : arr) {
      occurencesCount[num]++;
    }

    vector<pair<int, int>> pairs;
    for (auto p : occurencesCount) {
      pairs.push_back(p);
    }

    std::sort(pairs.begin(), pairs.end(),
              [](pair<int, int> a, pair<int, int> b) -> bool {
                return a.second < b.second;
              });

    int deleted = 0;
    int i = 0;

    while (k > 0 && i < pairs.size()) {
      if (k > pairs[i].second) {
        k -= pairs[i].second;
        i++;
        deleted++;
      } else {
        break;
      }
    }
    return pairs.size() - deleted;
  }
};
