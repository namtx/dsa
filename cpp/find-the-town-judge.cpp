// https://leetcode.com/problems/find-the-town-judge

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
  int findJudge(int n, vector<vector<int>> &trust) {
    vector<int> trustCount(n + 1);
    vector<int> beingTrustedCount(n + 1);

    for (auto pair : trust) {
      trustCount[pair[0]]++;
      beingTrustedCount[pair[1]]++;
    }

    for (int i = 1; i <= n; i++) {
      if (trustCount[i] == 0 && beingTrustedCount[i] == n - 1)
        return i;
    }

    return -1;
  }
};
