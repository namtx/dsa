#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  bool arrayStringsAreEqual(vector<string> &word1, vector<string> &word2) {
    int i = 0;
    int j = 0;
    int first = 0;
    int second = 0;

    while (word1[i][first] == word2[j][second]) {
      first++;
      second++;
      if (first == word1[i].size()) {
        first = 0;
        i++;
      }
      if (second == word2[j].size()) {
        second = 0;
        j++;
      }
      if (i == word1.size() && j == word2.size()) {
        return true;
      } else if (i == word1.size() || j == word2.size()) {
        return false;
      }
    }

    return false;
  }
};

int main(int argc, char *argv[]) {
  vector<string> word1 = {"abc", "d", "defg"};
  vector<string> word2 = {"abcddefg"};

  cout << (new Solution())->arrayStringsAreEqual(word1, word2);
  return 0;
}
