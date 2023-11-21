#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
  int countNicePairs(vector<int> &nums) {
    int mod = 1000000000 + 7;
    const int N = nums.size();

    for (int i = 0; i < N; i++) {
      nums[i] = nums[i] - rev(nums[i]);
    }
    std::sort(nums.begin(), nums.end());
    long r = 0;
    for (int i = 0; i < nums.size() - 1; i++) {
      long count = 1;
      while (i < nums.size() - 1 && nums[i] == nums[i + 1]) {
        count++;
      }
      r = (r % mod + (count * (count - 1) / 2) % mod) % mod;
    }
    return static_cast<int>(r);
  }

private:
  int rev(int num) {
    int r = 0;
    while (num > 0) {
      r = r * 10 + num % 10;
      num /= 10;
    }

    return r;
  }
};

int main(int argc, char *argv[]) {
  vector<int> nums = {42, 11, 1, 97};
  cout << (new Solution())->countNicePairs(nums) << endl;
  return 0;
}
