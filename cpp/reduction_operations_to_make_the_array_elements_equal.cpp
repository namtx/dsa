#include <iostream>
#include <queue>
#include <set>
#include <unordered_map>
#include <vector>

using namespace std;

static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();

class Solution {
public:
  int reductionOperations(vector<int> &nums) {
    unordered_map<int, int> occurences;
    set<int> set;
    priority_queue<int> queue;
    int min = 5 * 10000;

    for (auto num : nums) {
      if (num < min) {
        min = num;
      }
      occurences[num]++;
      if (set.count(num) == 0) {
        queue.push(num);
        set.insert(num);
      }
    }
    int operations = 0;
    while (queue.top() != min) {
      int t = queue.top();
      queue.pop();
      operations += occurences[t];
      occurences[queue.top()] += occurences[t];
    }

    return operations;
  }
};

int main(int argc, char *argv[]) {
  vector<int> nums = {1, 1, 1};
  cout << (new Solution())->reductionOperations(nums) << endl;
  return 0;
}
