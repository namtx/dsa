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
  int numDecodings(string s) {
    int n = s.size();

    vector<int> dp(n + 1, 0);
    dp[0] = 1;
    dp[1] = s[0] == '0' ? 0 : 1;

    for (int i = 2; i <= n; i++) {
      char c = s[i - 1];
      char d = s[i - 2];
      if (c >= '1' && c <= '9') {
        dp[i] += dp[i - 1];
      }
      if (d == '1' || d == '2' && c <= '6') {
        dp[i] += dp[i - 2];
      }
    }

    return dp[n];
  }
};

int main(int argc, char *argv[]) {
  cout << (new Solution())
              ->numDecodings("111111111111111111111111111111111111111111111")
       << endl;
  return 0;
}
