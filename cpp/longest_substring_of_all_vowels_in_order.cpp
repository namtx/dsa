#include <iostream>

using namespace std;

class Solution {
public:
  int longestBeautifulSubstring(string word) {
    int max = 0;

    for (int i = 1; i < word.length(); i++) {
      if (word[i - 1] == 'a') {
        int len = 1;
        int uniqueVowelCount = 1;
        while (i < word.length() && word[i - 1] <= word[i]) {
          if (word[i] > word[i - 1]) {
            uniqueVowelCount++;
          }
          len++;
          i++;
        }
        if (uniqueVowelCount == 5) {
          max = std::max(max, len);
        }
      }
    }

    return max;
  }
};

int main(int argc, char *argv[]) {
  Solution s;
  std::cout << s.longestBeautifulSubstring("aeeeiiiioooauuuaeiou") << std::endl;

  return 0;
}
