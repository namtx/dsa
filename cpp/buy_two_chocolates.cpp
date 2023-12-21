#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();

class Solution {
public:
  int buyChoco(vector<int> &prices, int money) {
    std::sort(prices.begin(), prices.end());
    if (prices[0] + prices[1] > money) {
      return money;
    }
    return money - prices[0] - prices[1];
  }
};
