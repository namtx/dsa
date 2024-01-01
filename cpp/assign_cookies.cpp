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
  int findContentChildren(vector<int> &g, vector<int> &s) {
    std::sort(g.begin(), g.end());
    std::sort(s.begin(), s.end());

    int gi = 0;
    int si = 0;
    int ans = 0;

    while (gi < g.size() && si < s.size()) {
      if (s[si] >= g[gi]) {
        gi++;
        ans++;
      }
      si++;
    }

    return ans;
  }
};
