// https://leetcode.com/problems/first-unique-character-in-a-string

#include <string>
#include <unordered_map>

using namespace std;

class Solution {
public:
  int firstUniqChar(string s) {
    unordered_map<char, int> charCountingMap;

    for (auto const &c : s) {
      charCountingMap[c]++;
    }

    for (int i = 0; i < s.size(); i++) {
      if (charCountingMap[s[i]] == 1)
        return i;
    }

    return -1;
  }
};
