#include <iostream>

using namespace std;

class Solution {
public:
  int countPalindromicSubsequence(string s) {
    int count = 0;
    bool used[26] = {false};
    for (int i = 0; i < s.length(); i++) {
      if (!used[s[i] - 'a']) {
        bool paired[26] = {false};
        int j = s.length() - 1;
        while (j > i && s[j] != s[i])
          j--;
        if (j > i) {
          for (int k = i + 1; k < j; k++) {
            if (!paired[s[k] - 'a']) {
              count++;
              paired[s[k] - 'a'] = true;
            }
          }
        }
        used[s[i] - 'a'] = true;
      }
    }

    return count;
  }
};

int main(int argc, char *argv[]) {
  Solution s;
  cout << s.countPalindromicSubsequence(
              "bbcbaasdsjakldasdadaabaabcascbaiqiqhaa")
       << endl;
  return 0;
}
