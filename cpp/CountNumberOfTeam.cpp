#include <iostream>
#include <vector>

class Solution {
public:
  int numTeams(vector<int>& rating) {
    int count = 0;
    for (int i = 0; i < rating.size(); i++) {
      count += numTeams(rating, i, 1, true);
      count += numTeams(rating, i, 1, false);
    }
    return count;
  }

private:
  int numTeams(vector<int>&rating, int startIndex, int teamSize, bool increasing) {
    if (teamSize == 3) {
      return 1;
    }
    int count = 0;
    for (int i = startIndex; i < rating.size(); i++) {
      if (increasing && rating[i] > rating[startIndex]) {
        count += numTeams(rating, i, teamSize + 1, increasing);
      } else if (!increasing && rating[i] < rating[startIndex]) {
        count += numTeams(rating, i, teamSize + 1, increasing);
      }
    }
    return count;
  }
};
