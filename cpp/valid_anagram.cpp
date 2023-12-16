#include <iostream>
#include <string>
#include <vector>

using namespace std;
class Solution {
public:
  bool isAnagram(string s, string t) {
    if (s.size() != t.size())
      return false;
    vector<int> count(26, 0);

    for (char c : s) {
      count[c - 'a']++;
    }

    for (char c : t) {
      if (count[c - 'a'] == 0) {
        return false;
      }
      count[c - 'a']--;
    }

    return true;
  }
};

int main(int argc, char *argv[]) {
  cout << (new Solution())->isAnagram("anagram", "nagaram") << endl;
  return 0;
}
