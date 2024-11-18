#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    string addSpaces(string s, vector<int>& spaces) {
        int i = 0, j = 0;
        vector<char> result;
        while (i < s.size()) {
            if (j < spaces.size() && i == spaces[j]) {
                result.push_back(' ');
                ++j;
            }
            result.push_back(s[i]);
            ++i;
        }
        return string(result.begin(), result.end());
    }
};

int main() {
    Solution sol;
    string s = "LeetcodeHelpsMeLearn";
    vector<int> spaces = {8, 13, 15};
    cout << sol.addSpaces(s, spaces) << endl;
    return 0;
}