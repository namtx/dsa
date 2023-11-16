#include <iostream>
#include <set>
#include <vector>

using namespace std;

class Solution {
public:
  string findDifferentBinaryString(vector<string> &nums) {
    int n = nums.size();
    set<string> s;

    for (auto num : nums) {
      s.insert(num);
    }

    string empty = "";
    string *str = &empty;
    return *backtrack(str, n, s);
  }

private:
  string *backtrack(string *str, int n, set<string> &s) {
    if (str->length() == n) {
      if (s.find(*str) == s.end()) {
        return str;
      } else {
        return nullptr;
      }
    }

    string chars[2] = {"0", "1"};

    for (auto c : chars) {
      str->append(c);
      string *r = backtrack(str, n, s);
      if (r != nullptr) {
        return r;
      } else {
        str->pop_back();
      }
    }

    return nullptr;
  }
};

int main(int argc, char *argv[]) {
  vector<string> nums = {"111", "001", "100"};
  cout << (new Solution)->findDifferentBinaryString(nums) << endl;
  return 0;
}
