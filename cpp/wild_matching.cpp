#include <iostream>

using namespace std;

class Solution {
public:
  bool isMatch(string s, string p) {
    vector<vector<bool>> dp(s.size() + 1, vector<bool>(p.size() + 1, -1));

    for (size_t i = 1; i < s.size(); i++) {
      for (size_t j = 1; j < p.size(); j++) {
        if (s[i - 1] == p[j - 1] || p[j - 1] == '?') {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (p[j - 1] == '*') {
          dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
        } else {
          dp[i][j] = false;
        }
      }
    }

    return dp[s.size()][p.size()];
  }
}

int main (int argc, char *argv[]) {
  Solution s;

  cout << s.isMatch("abcdef", "a?c*f") << endl;
  return 0;
}
