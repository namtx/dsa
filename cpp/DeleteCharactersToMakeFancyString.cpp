#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
  string makeFancyString(string s) {
    vector<char> r;

    int count = 0;
    for (int i = 0; i < s.size(); i++) {
      if (i > 0 && s[i] == s[i - 1]) {
        count++;
      } else {
        count = 1;
      }
      if (count < 3) {
        r.push_back(s[i]);
      }
    }

    // make string from vector
    return string(r.begin(), r.end());
  }
};
