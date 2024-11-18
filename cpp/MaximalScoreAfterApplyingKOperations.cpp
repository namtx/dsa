#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
  long long maxKelements(vector<int>& nums, int k) {
    // max heap
    long long ans = 0;
    priority_queue<int> pq;
    for (int i = 0; i < nums.size(); i++) {
      pq.push(nums[i]);
    }
    for (int i = 0; i < k; i++) {
      int top = pq.top();
      ans += top;
      pq.pop();
      pq.push(ceil(top/3.0));
    }
    return ans;
  }
};

int main (int argc, char *argv[]) {

  Solution sol;
  vector<int> v = {1, 10, 3,3,3};
  sol.maxKelements(v, 3);
  return 0;
}
