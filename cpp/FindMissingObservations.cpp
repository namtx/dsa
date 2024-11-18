#include <vector>
#include <iostream>
#include <numeric>

using namespace std;

class Solution {
public:
  vector<int> missingRolls(vector<int>& rolls, int mean, int n) {
    int expectation = mean * (rolls.size() + n);
    int sum = accumulate(rolls.begin(), rolls.end(), 0);
    int missing = expectation - sum;

    if (missing < n || missing > n * 6) {
      return {};
    }

    auto divResult = div(missing, n);
    vector<int> missingRolls(n, divResult.quot);
    for (auto i = 0; i < divResult.rem; i++) {
      missingRolls[i]++;
    }

    return missingRolls;
  }
};

