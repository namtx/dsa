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
  int numberOfBeams(vector<string> &bank) {
    vector<int> devices(bank.size());
    int i = -1;
    for (auto r : bank) {
      i++;
      for (auto p : r) {
        if (p == '1') {
          devices[i]++;
        }
      }
    }
    int prev = 0;
    int ans = 0;
    for (int i = 0; i < devices.size(); i++) {
      if (devices[i] != 0) {
        if (prev != 0) {
          ans += prev * devices[i];
        }
        prev = devices[i];
      }
    }
    return ans;
  }
};
