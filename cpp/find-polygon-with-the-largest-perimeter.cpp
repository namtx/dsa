// https://leetcode.com/problems/find-polygon-with-the-largest-perimeter

#include <iostream>
#include <vector>

using namespace std;

static auto _ = [](){
ios::sync_with_stdio(false);
cin.tie(nullptr);
cout.tie(nullptr);
return nullptr;
}();

class Solution {
public:
    long long largestPerimeter(vector<int>& nums) {
        vector<long long> prefixSum(nums.size());
        std::sort(nums.begin(), nums.end());
        prefixSum[0] = 0;
        int n = nums.size();
        for (int i = 1; i < n; i++) {
            prefixSum[i] = nums[i-1] + prefixSum[i-1];
        }
        int i = n-1;
        while (i >= 2) {
            if (prefixSum[i] <= nums[i]) {
                i--;
            } else {
                return prefixSum[i] + nums[i];
            }
        }
        return -1;
    }
};
