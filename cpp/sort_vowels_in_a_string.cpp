#include <iostream>
#include <queue>

using namespace std;

class Solution {
public:
  string sortVowels(string s) {
    priority_queue<char> pq;

    for (int i = 0; i < s.length(); i++) {
      if (isVowel(s[i])) {
        pq.push(-s[i]);
      }
    }

    for (int i = 0; i < s.length(); i++) {
      if (isVowel(s[i])) {
        s[i] = -pq.top();
        pq.pop();
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
