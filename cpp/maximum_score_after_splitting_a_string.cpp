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
  int maxScore(string s) {
    int n = s.size();
    vector<int> zeroes(n);
    vector<int> ones(n);
    zeroes[0] = s[0] == '0' ? 1 : 0;
    ones[n - 1] = s[n - 1] == '1' ? 1 : 0;

    for (int i = 1; i < s.size(); i++) {
      zeroes[i] = s[i] == '0' ? zeroes[i - 1] + 1 : zeroes[i - 1];
    }
    for (int i = n - 2; i >= 0; i--) {
      ones[i] = s[i] == '1' ? ones[i + 1] + 1 : ones[i + 1];
    }

    int max = 0;

    for (int i = 0; i < n - 1; i++) {
      max = std::max(max, zeroes[i] + ones[i + 1]);
    }

    return max;
  }
};

int main(int argc, char *argv[]) {
  cout << (new Solution())->maxScore("00111") << endl;
  return 0;
}
