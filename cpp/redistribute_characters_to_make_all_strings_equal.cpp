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
  bool makeEqual(vector<string> &words) {
    vector<int> c(26);
    for (auto w : words) {
      for (auto ch : w) {
        c[ch - 'a']++;
      }
    }
    int n = static_cast<int>(words.size());
    for (auto count : c) {
      if (count % n != 0)
        return false;
    }
    return true;
  }
};
