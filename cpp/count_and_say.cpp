#include <iostream>

using namespace std;

class Solution {
public:
  string countAndSay(int n) {
    string ans = "1";
    for (int i = 1; i < n; i++) {
      string temp = "";
      int count = 1;
      for (int j = 0; j < ans.size(); j++) {
        if (j + 1 < ans.size() && ans[j] == ans[j + 1]) {
          count++;
        } else {
          temp += to_string(count) + ans[j];
          count = 1;
        }
      }
      ans = temp;
    }

    return ans;
  }
};

int main (int argc, char *argv[]) {
  Solution s;
  cout << s.countAndSay(1) << endl;
  return 0;
}
