#include <iostream>
#include <vector>

 using namespace std;

class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        int n = nums.size();
        long long maxSum = 0;
        unordered_map<int, int> lastIndex;
        int left = 0;
        long long currentSum = 0;
        int i = 0;
        while(i < n - k +1) {
            cout << "i: " << i << endl;
            if (lastIndex.find(nums[i]) != lastIndex.end()) {
                cout << "lastIndex[nums[i]]: " << lastIndex[nums[i]] << endl;
                cout << "left: " << left << endl;
                for (int j = left; j < lastIndex[nums[i]] + 1; j++) {
                    cout << "j: " << j << endl;
                    lastIndex.erase(nums[j]);
                    currentSum -= nums[j];
                }
                left = lastIndex[nums[i]] + 1;
                i = left;
                continue;
            }
            lastIndex[nums[i]] = i;
            currentSum += nums[i];
            cout << "currentSum: " << currentSum << endl;
            if (i - left + 1 == k) {
                maxSum = max(maxSum, currentSum);
                currentSum -= nums[left];
                left++;
            }
            i++;
        }
        return maxSum;
    }
};

int main() {
    Solution sol;
    vector<int> nums = {1,1,1,7,8,9};
    int k = 3;
    cout << sol.maximumSubarraySum(nums, k) << endl;
    return 0;
}
