#include <iostream>

using namespace std;
class Solution {
public:
  string largestGoodInteger(string num) {
    string max = "";
    int i = 0;
    if (num.size() <= 2)
      return max;
    while (i < num.size() - 3) {
      if (num[i] == num[i + 1] && num[i] == num[i + 2]) {
        string n = num.substr(i, 3);
        if (n > max) {
          max = n;
        }
        i += 3;
      } else {
        i++;
      }
    }
    return max;
  }
};
