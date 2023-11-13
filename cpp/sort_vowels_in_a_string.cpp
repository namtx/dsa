#include <iostream>

using namespace std;

class Solution {
public:
  string sortVowels(string s) {
    int freq[128] = {0};
    for (int i = 0; i < s.length(); i++) {
      if (isVowel(s[i])) {
        freq[s[i]]++;
      }
    }

    int idx = 0;
    for (int i = 0; i < s.length(); i++) {
      if (isVowel(s[i])) {
        while (freq[idx] == 0)
          idx++;
        s[i] = (char)idx;
        freq[idx]--;
      }
    }
    return s;
  }

private:
  bool isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
           c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
  }
};

int main(int argc, char *argv[]) {
  Solution s;

  cout << s.sortVowels("LEetcOde") << endl;
  return 0;
}
