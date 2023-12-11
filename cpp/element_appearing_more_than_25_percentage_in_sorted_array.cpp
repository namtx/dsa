#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int findSpecialInteger(vector<int> &arr) {
    int count = 1;
    for (int i = 1; i < arr.size(); i++) {
      if (arr[i] == arr[i - 1]) {
        count++;
        if (count >= arr.size() / 4)
          return arr[i];
      } else {
        count = 1;
      }
    }
    return arr[0];
  }
};

int main(int argc, char *argv[]) {

  vector<int> v{1};
  cout << (new Solution())->findSpecialInteger(v) << endl;
  return 0;
}
