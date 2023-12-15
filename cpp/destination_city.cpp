#include <set>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
  string destCity(vector<vector<string>> &paths) {
    set<string> s;
    for (auto path : paths) {
      s.insert(path[1]);
    }
    for (auto path : paths) {
      s.erase(path[0]);
    }
    return *s.begin();
  }
};
