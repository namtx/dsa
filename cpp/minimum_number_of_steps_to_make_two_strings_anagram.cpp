#include <iostream>
#include <unordered_map>

using namespace std;

static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();

class Solution {
public:
  int minSteps(string s, string t) {
    unordered_map<char, int> sm;
    unordered_map<char, int> tm;
    int count = 0;

    for (auto pair : sm) {
      if (tm.find(pair.first) != tm.end()) {

        if (tm[pair.first] == sm[pair.first]) {
          count += tm[pair.first];
        } else {
          count += min(tm[pair.first], sm[pair.first]);
        }
      }
    }

    return s.size() - count;
  }
};
