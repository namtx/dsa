#include <iostream>

using namespace std;

class Solution {
public:
  int minimumOneBitOperations(int n) {
    int res;
    for (res = 0; n > 0; n &= n - 1)
      res = -(res + (n ^ (n - 1)));
    return abs(res);
  }
};

int main(int argc, char *argv[]) {
  cout << (new Solution())->minimumOneBitOperations(4) << endl;
  return 0;
}
