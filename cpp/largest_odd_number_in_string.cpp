#include <iostream>

using namespace std;

class Solution {
public:
  string largestOddNumber(string num) {
    int i = num.size() - 1;
    while (i >= 0) {
      char c = num[i];
      if (c == '1' || c == '3' || c == '5' || c == '7' || c == '9') {
        return num.substr(0, i + 1);
      } else {
        i--;
      }
    }
    return "";
  }
};

int main(int argc, char *argv[]) {
  cout << (new Solution())->largestOddNumber("120241");
  return 0;
}
