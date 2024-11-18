#include <iostream>

using namespace std;

class Solution {
  public:
    int findTheWinner(int n, int k) {
      vector<int> arr(n);
      for (int i = 0; i < n; i++) {
        arr[i] = i + 1;
      }
      int index = 0;
      while(arr.size() > 1) {
        index = (index + k - 1) % arr.size();
        arr.erase(arr.begin() + index);
        for (int i = 0; i < arr.size(); i++) {
          cout << arr[i] << " ";
        }
        cout << endl;
      }

      return arr[0];
    }
};

int main() {
  Solution solution;
  int n = 5, k = 2;
  cout << solution.findTheWinner(n, k) << endl;
  return 0;
}

