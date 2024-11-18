#include <iostream>
#include <vector>

using namespace std;
class Solution {
public:
  vector<string> divideString(string s, int k, char fill) {
    vector<string> ans;

    int n = s.size();
    bool seen[26] = {false};
    bool odd = n % k != 0;
    if (odd) seen[fill-'a'] = true;
    string group = "";
    int i = 0;
    for (i = 0; i < (n/k)*k; i++) {
      if (seen[s[i]-'a']) {
        continue;
      }
      if (group.size() == k) {
        ans.push_back(group);
        for (auto c: group) {
          seen[c-'a'] = true;
        }
        group = "";
      }
      group += s[i];
    }
    if (group.size() > 0) {
      ans.push_back(group);
      for (auto c: group) {
        seen[c-'a'] = true;
      }
      group = "";
    }
    if (i < n) {
      seen[fill-'a'] = false;
      for (; i < n; i++) {
        if (seen[s[i]-'a']) {
          continue;
        }
        group += s[i];
      }
      while(group.size() < k) {
        group += fill;
      }
      ans.push_back(group);
    }

    return ans;
  }
};

int main (int argc, char *argv[]) {
  Solution s;
  for (auto str: s.divideString("ctoyjrwtngqwt", 8, 'n')) {
    cout << str << endl;
  }
  return 0;
}
