// https://leetcode.com/problems/minimum-window-substring

#include <iostream>
#include <unordered_map>

using namespace std;

static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();

class Solution {
public:
  string minWindow(string s, string t) {
    unordered_map<char, int> characterCountingMap;

    for (auto const &c : t) {
      characterCountingMap[c]++;
    }

    int left = 0;
    int startIndex = 0;
    int right = 0;
    int min = 1e5;
    int count = t.size();

    while (right < s.size()) {
      if (characterCountingMap[s[right++]]-- > 0) {
        count--;
      }
      while (count == 0) {
        if (right - left < min) {
          min = right - left;
          startIndex = left;
        }
        if (characterCountingMap[s[left++]]++ == 0) {
          count++;
        }
      }
    }
    return min == 1e5 ? "" : s.substr(startIndex, min);
  }
};
