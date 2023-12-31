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
  int maxLengthBetweenEqualCharacters(string s) {
    vector<pair<int, int>> occurs(26, {-1, -1});

    for (int i = 0; i < s.size(); i++) {
      char c = s[i];
      if (occurs[c - 'a'].first == -1) { // never occured before
        occurs[c - 'a'].first = i;
        occurs[c - 'a'].second = i;
      } else {
        occurs[c - 'a'].second = i;
      }
    }
    int max = -1;
    for (auto p : occurs) {
      max = std::max(max, p.second - p.first - 1);
    }
    return max;
  }
};
