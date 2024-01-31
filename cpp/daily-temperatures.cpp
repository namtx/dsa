// https://leetcode.com/problems/daily-temperatures

#include <iostream>
#include <stack>
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
  vector<int> dailyTemperatures(vector<int> &temperatures) {
    stack<pair<int, int>> s;
    vector<int> ans(temperatures.size(), 0);

    for (int i = 0; i < temperatures.size(); i++) {
      int temp = temperatures[i];
      if (s.empty()) {
        s.push({i, temp});
      } else {
        if (temp > s.top().second) {
          while (!s.empty() && temp > s.top().second) {
            ans[s.top().first] = i - s.top().first;
            s.pop();
          }
        }
        s.push({i, temp});
      }
    }
    return ans;
  }
};
