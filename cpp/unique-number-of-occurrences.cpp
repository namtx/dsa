#include <iostream>
#include <unordered_map>
#include <unordered_set>
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
  bool uniqueOccurrences(vector<int> &arr) {
    unordered_map<int, int> occurrences;
    for (auto num : arr) {
      occurrences[num]++;
    }
    unordered_set<int> s;
    for (auto pair : occurrences) {
      if (s.contains(pair.second))
        return false;
      s.insert(pair.second);
    }
    return true;
  }
};
