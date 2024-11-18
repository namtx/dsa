#include <iostream>
#include <vector>
#include <map>

using namespace std;

class Solution {
public:
    int countGoodNodes(vector<vector<int>>& edges) {
      map<int, vector<int>>  m;
      for (auto edge: edges) {
        m[edge[0]].push_back(edge[1]);
      }
    }
};
