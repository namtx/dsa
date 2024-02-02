// https://leetcode.com/problems/find-center-of-star-graph

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
  int findCenter(vector<vector<int>> &edges) {
    int u = edges[0][0];
    int v = edges[0][1];

    if (u == edges[1][0] || u == edges[1][1])
      return u;
    if (v == edges[1][0] || v == edges[1][1])
      return v;

    return -1;
  }
};
