#include <iostream>

class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
      vector<int> beams(n, 0);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < bank[i].length; j++) {
          if (bank[i][j] == '1') {
            beams[i]++;
          }
        }
      }
      int total = 0;
      int prev = 0;
      for (int i = 0; i < n-1; i++) {
        total += beams[i] * prev;
        if (beams[i] > 0) {
          prev = beams[i];
        }
      }
      return total;
    }
};
