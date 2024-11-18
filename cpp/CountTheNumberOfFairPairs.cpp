#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    long long countFairPairs(vector<int>& nums, int lower, int upper) {
        vector<pair<int, int>> pairs;
        for (int i = 0; i < nums.size(); ++i) {
            pairs.push_back({nums[i], i});
        }
        sort(pairs.begin(), pairs.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
            return a.first < b.first;
        });

        for (int i = 0; i < pairs.size(); ++i) {
            cout << pairs[i].first << " " << pairs[i].second << endl;
        }
        cout << "------------\n";
        long long result = 0;
        auto it = upper_bound(pairs.begin(), pairs.end(), lower - pairs[0].first, [](int b, const pair<int, int>& a) {
            cout << "b: " << b << " a: " << a.first << endl;
            return a.first > b;
        });
        auto it2 = lower_bound(pairs.begin(), pairs.end(), upper - pairs[0].first, [](const pair<int, int>& a, int b) {
            cout << "b: " << b << " a: " << a.first << endl;
            return a.first < b;
        });

        cout << it->second << " " << it2->second << endl;

        for (auto j = it; j != it2; ++j) {
            if (j->second > pairs[0].second) {
                ++result;
            }
        }
        for (int i = 1; i < pairs.size(); ++i) {
            while (pairs[i].first + it->first > lower) {
                it--;
            }
            while (pairs[i].first + it2->first > upper) {
                --it2;
            }
            for (auto j = it; j != it2; ++j) {
                if (j->second > pairs[i].second) {
                    ++result;
                }
            }
        }
        return result;
    }
};

int main() {
    Solution sol;
    vector<int> nums = {0, 1, 7, 4, 4, 5};
    cout << sol.countFairPairs(nums, 3, 6) << endl;
    return 0;
}