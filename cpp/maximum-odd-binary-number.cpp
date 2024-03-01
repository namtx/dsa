// https://leetcode.com/problems/maximum-odd-binary-number

#include <iostream>

using namespace std;

static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();

class Solution {
public:
  string maximumOddBinaryNumber(string s) {
    int ones = count(s.begin(), s.end(), '1');
    int n = s.size();
    int zeroes = n - ones;
    string ans = s;
    ans[n - 1] = '1';
    ones--;
    int i = 0;
    while (ones > 0) {
      ans[i++] = '1';
      ones--;
    }
    while (zeroes > 0) {
      ans[i++] = '0';
      zeroes--;
    }
    return ans;
  }
};
