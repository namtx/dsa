// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes

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
  vector<int> findSmallestSetOfVertices(int n, vector<vector<int>> &edges) {
    vector<int> ans;
    vector<int> hasIncommingEdge(n, false);
    for (const auto &edge : edges) {
      hasIncommingEdge[edge[1]] = true;
    }
    for (int i = 0; i < n; i++) {
      if (!hasIncommingEdge[i])
        ans.push_back(i);
    }

    return ans;
  }
};
