#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int maxCoins(vector<int> &piles) {
    sort(piles.begin(), piles.end());

    int ans = 0;
    for (int i = 0; i < piles.size() / 3; i++) {
      ans += piles[piles.size() - 2 * (i + 1)];
    }

    return ans;
  }
};

int main(int argc, char *argv[]) {
  vector<int> piles = {9, 8, 7, 6, 5, 1, 2, 3, 4};
  cout << (new Solution())->maxCoins(piles) << endl;
  return 0;
}
