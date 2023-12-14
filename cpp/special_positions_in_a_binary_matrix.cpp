#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int numSpecial(vector<vector<int>> &mat) {
    int n = mat.size();
    int m = mat[0].size();

    vector<int> rows(n, 0);
    vector<int> cols(n, 0);
    int count = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (mat[i][j] == 1) {
          rows[i]++;
          cols[j]++;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
          count++;
        }
      }
    }
    return count;
  }
};

int main(int argc, char *argv[]) {
  vector<vector<int>> mat{{0, 0, 0, 0, 0, 1, 0, 0},
                          {0, 0, 0, 0, 1, 0, 0, 1},
                          {0, 0, 0, 0, 1, 0, 0, 0},
                          {1, 0, 0, 0, 1, 0, 0, 0},
                          {0, 0, 1, 1, 0, 0, 0, 0}

  };

  cout << (new Solution())->numSpecial(mat) << endl;
  return 0;
}
