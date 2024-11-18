#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<int> decrypt(vector<int>& code, int k) {
        vector<int> result(code.size(), 0);
        if (k == 0) {
            return result;
        }

        if (k > 0) {
            for (int i = 0; i < code.size(); ++i) {
                for (int j = 1; j <= k; ++j) {
                    result[i] += code[(i + j) % code.size()];
                }
            }
        } else {
            for (int i = 0; i < code.size(); ++i) {
                for (int j = 1; j <= -k; ++j) {
                    result[i] += code[(i - j + code.size()) % code.size()];
                }
            }
        }
        return result;
    }
};