#include <iostream>
#include <vector>
#include <map>

using namespace std;

class Solution {
public:
    int longestSquareStreak(vector<int>& nums) {
      sort(nums.begin(), nums.end());

      int maxStreak = 0;
      map<int, int> streaks;

      for (size_t i = 0; i < nums.size(); i++) {
        int square_root = sqrt(nums[i]);
        if (square_root * square_root == nums[i]) {
          streaks[nums[i]] = streaks[square_root] + 1;
          maxStreak = max(maxStreak, streaks[nums[i]]);
        } else {
          streaks[nums[i]] = 1;
        }
      }

      return maxStreak;
    }
};

int main (int argc, char *argv[]) {
  Solution s;

  vector<int> nums = {2, 4, 9, 16, 25, 36, 49, 64, 81, 100};
  std::cout << s.longestSquareStreak(nums) << std::endl;
  return 0;
}
