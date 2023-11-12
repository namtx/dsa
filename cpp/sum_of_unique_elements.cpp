#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
  int sumOfUnique(vector<int> &nums) {
    unordered_map<int, int> m;

    for (auto num : nums) {
      m[num] += 1;
    }
    int sum = 0;
    for (auto pair : m) {
      if (pair.second == 1)
        sum += pair.first;
    }

    return sum;
  }
};
