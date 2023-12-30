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
  int removeDuplicates(vector<int> &nums) {
    int writeIndex = 1; // Index for writing unique elements
    int consecutiveCount = 1;

    for (int readIndex = 1; readIndex < nums.size(); readIndex++) {
      if (nums[readIndex] == nums[readIndex - 1]) {
        consecutiveCount++;
      } else {
        consecutiveCount = 1;
      }

      // Move unique elements to the front, overwriting duplicates
      if (consecutiveCount <= 2) {
        nums[writeIndex++] = nums[readIndex];
      }
    }

    return writeIndex; // Return the number of unique elements
  }
};

int main(int argc, char *argv[]) {
  vector<int> nums = {1, 1, 1, 2, 2, 2, 3, 3};
  cout << (new Solution())->removeDuplicates(nums);
  return 0;
}
