// https://leetcode.com/problems/find-the-punishment-number-of-an-integer

class Solution {
public:
  int punishmentNumber(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      if (isPunishable(i, to_string(i * i))) {
        sum += i * i;
      }
    }

    return sum;
  }

private:
  bool isPunishable(int n, string str) {
    if (str.length() == 0)
      return false;
    if (n == stoi(str))
      return true;
    for (int i = 1; i < str.length(); i++) {
      int prefix = stoi(str.substr(0, i));
      if (prefix > n)
        return false;
      if (isPunishable(n - prefix, str.substr(i)))
        return true;
    }

    return false;
  }
};

