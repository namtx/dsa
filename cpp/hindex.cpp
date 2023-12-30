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
  int hIndex(vector<int> &citations) {
    int n = citations.size();
    std::sort(citations.begin(), citations.end());
    int ans = -1;
    for (int i = n - 1; i >= 0; i--) {
      ans = std::max(ans, std::min(citations[i], n - 1 - i + 1));
    }
    return ans;
  }
};
