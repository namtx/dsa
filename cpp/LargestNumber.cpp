#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  string largestNumber(vector<int>& nums) {
    vector<string> numStrs;
    for(auto num : nums) {
      numStrs.push_back(to_string(num));
    }
    sort(numStrs.begin(), numStrs.end(), [](string &a, string &b) {
      return a + b > b + a;
    });

    if (numStrs[0] == "0") {
      return "0";
    }
    string ans = "";
    for (auto str: numStrs) {
      ans +=  str;
    }
    return ans;
  }
};

int main (int argc, char *argv[]) {
  Solution s;
  vector<int> nums = {34323, 3432};
  cout << s.largestNumber(nums) << endl;
  return 0;
}
