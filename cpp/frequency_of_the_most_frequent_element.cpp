#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int maxFrequency(vector<int> &nums, int k) {
    long currentSum = 0;
    int max = 0;
    sort(nums.begin(), nums.end());
    for (int l = 0, r = 0; r < nums.size(); r++) {
      currentSum += nums[r];
      while (static_cast<long>(r - l + 1) * nums[r] - currentSum > k) {
        currentSum -= nums[l];
        l++;
      }
      max = std::max(max, r - l + 1);
    }

    return max;
  }
};

int main(int argc, char *argv[]) {
  vector<int> nums = {1, 4, 8, 13};
  cout << (new Solution)->maxFrequency(nums, 5) << endl;
  return 0;
}
