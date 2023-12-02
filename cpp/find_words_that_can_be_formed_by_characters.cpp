#include <array>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
  int countCharacters(vector<string> &words, string chars) {
    vector<int> characterCount(26, 0);
    int ans = 0;

    for (auto c : chars) {
      characterCount[c - 'a']++;
    }

    for (auto w : words) {
      vector<int> copy = characterCount;
      bool valid = true;
      for (auto c : w) {
        if (copy[c - 'a'] == 0) {
          valid = false;
          break;
        } else {
          copy[c - 'a']--;
        }
      }
      if (valid) {
        ans += w.size();
      }
    }
    return ans;
  }
};

int main() {
  vector<string> words = {"hello", "world", "leetcode"};
  string chars = "welldonehoneyr";
  cout << (new Solution())->countCharacters(words, chars) << endl;
  return 0;
}
