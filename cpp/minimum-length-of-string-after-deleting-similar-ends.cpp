// https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends

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
  int minimumLength(string s) {

    int left = 0;
    int n = s.size();
    int right = n - 1;
    while (left < right) {
      if (s[left] != s[right])
        break;
      left++;
      right--;
      while (left <= right && left <= n - 1 && s[left] == s[left - 1])
        left++;
      while (left <= right && right >= 0 && s[right] == s[right + 1])
        right--;
    }

    return right - left + 1;
  }
};
