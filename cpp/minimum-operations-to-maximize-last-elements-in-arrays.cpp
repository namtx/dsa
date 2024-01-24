// https://leetcode.com/problems/minimum-operations-to-maximize-last-elements-in-arrays

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
  int minOperations(vector<int> &nums1, vector<int> &nums2) {
    size_t n = nums1.size();
    int dontSwapped = calculateOperations(nums1, nums2);
    std::swap(nums1[n - 1], nums2[n - 1]);
    int swapped = calculateOperations(nums1, nums2);

    if (dontSwapped == swapped && swapped == -1)
      return -1;
    if (dontSwapped == -1 || swapped == -1) {
      return std::max(dontSwapped, swapped + 1);
    }
    return std::min(dontSwapped, 1 + swapped);
  }

  int calculateOperations(vector<int> &nums1, vector<int> &nums2) {
    int operations = 0;
    size_t n = nums1.size();
    for (size_t i = 0; i < n - 1; i++) {
      if (nums1[i] <= nums1[n - 1] &&
          nums2[i] <= nums2[n - 1]) { // we dont need to swap
        continue;
      } else if (nums1[i] <= nums2[n - 1] && nums2[i] <= nums1[n - 1]) {
        operations++;
      } else {
        return -1;
      }
    }
    return operations;
  }
};
