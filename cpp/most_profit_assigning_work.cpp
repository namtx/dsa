#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maxProfitAssignment(vector<int>& difficulty, vector<int>& profit, vector<int>& worker) {
        int profitSum = 0;
        vector<pair<int,int>> dp;
        for (int i = 0; i < difficulty.size(); i++) {
            dp.push_back({difficulty[i], profit[i]});
        }
        // sort by profit, desc
        std::sort(dp.begin(), dp.end(), [](pair<int,int> a, pair<int,int> b) {
            return a.second > b.second;
        });

        for (int i = 0; i < worker.size(); i++) {
          int j = 0;
          while(j < dp.size() && worker[i] < dp[j].first) {
            j++;
          }
          if (j < dp.size()) {
            profitSum  += dp[j].second;
          }
        }

        return profitSum;
    }
};

int main (int argc, char *argv[]) {

  vector<int> difficulty = {2, 4, 6, 8, 10};
  vector<int> profit = {10, 20, 30, 40, 50};
  vector<int> worker = {4, 5, 6, 7};
  Solution s;
  cout << "profit: " << s.maxProfitAssignment(difficulty, profit, worker);
  return 0;
}
