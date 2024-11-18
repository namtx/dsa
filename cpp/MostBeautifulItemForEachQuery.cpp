#include <iostream>
#include <vector>

using namespace std;
static const int _ = [](){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    return 0;
}();

class Solution {
public:
    vector<int> maximumBeauty(vector<vector<int>>& items, vector<int>& queries) {
        sort(items.begin(), items.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });

        vector<int> maxBeauty(items.size(), 0);
        maxBeauty[0] = items[0][1];
        for (int i = 1; i < items.size(); ++i) {
            maxBeauty[i] = max(maxBeauty[i - 1], items[i][1]);
        }

        vector<int> result;
        for (int i = 0; i < queries.size(); ++i) {
            int query = queries[i];
            int left = 0, right = items.size() - 1;
            int upper = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (items[mid][0] <= query) {
                    upper = mid + 1;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            result.push_back(upper == 0 ? 0 : maxBeauty[right]);
        }
        return result; 
    }
};