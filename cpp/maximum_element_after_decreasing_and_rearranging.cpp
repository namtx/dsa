#include <bits/stdc++.h>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int maximumElementAfterDecrementingAndRearranging(vector<int> &arr) {
    sort(arr.begin(), arr.end());
    int max = 1;
    arr[0] = 1;
    for (int i = 1; i < arr.size(); i++) {
      if (arr[i] > arr[i - 1]) {
        arr[i] = arr[i - 1] + 1;
      }
    }

    return arr[arr.size() - 1];
  }
};

int main(int argc, char *argv[]) {
  Solution s;
  vector<int> arr = {1, 100, 1000};
  cout << s.maximumElementAfterDecrementingAndRearranging(arr) << endl;
  return 0;
}
