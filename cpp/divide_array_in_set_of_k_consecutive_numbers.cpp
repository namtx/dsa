#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
  bool isPossibleDivide(vector<int> &nums, int k) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n = nums.size();
    if (n % k != 0)
      return false;

    unordered_map<int, int> occurences;
    sort(nums.begin(), nums.end());

    for (auto num : nums) {
      occurences[num]++;
    }

    for (int i = 0; i < n; i++) {
      // occurences[nums[i]] == 0 means that nums[i] is already picked and
      // belongs to existing set
      if (occurences[nums[i]] == 0) {
        continue;
      }

      // create a new set by picking nums[i]
      occurences[nums[i]]--;

      for (int j = 1; j < k; j++) {
        // if there is no nums[i] + j available to for newly created set, then
        // return false
        if (occurences[nums[i] + j] == 0) {
          return false;
        }
        // if yes, pick it
        occurences[nums[i] + j]--;
      }
    }

    return true;
  }
};

int main(int argc, char *argv[]) {
  vector<int> nums = {3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11};
  cout << (new Solution)->isPossibleDivide(nums, 3) << endl;
  return 0;
}
