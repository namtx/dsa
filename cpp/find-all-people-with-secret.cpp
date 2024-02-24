// https://leetcode.com/problems/find-all-people-with-secret

#include <iostream>
#include <vector>

using namespace std;

static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();

class UnionFind {
public:
  vector<int> parent;
  int size;
  vector<bool> hasSecret;

  UnionFind(int size) {
    this->size = size;
    parent = vector<int>(size);
    hasSecret = vector<bool>(size);
    for (int i = 0; i < size; i++) {
      parent[i] = i;
    }
  }

  int find(int i) {
    if (parent[i] == i)
      return i;

    int result = find(parent[i]);

    parent[parent[i]] = result;
    hasSecret[parent[i]] = hasSecret[result];
    hasSecret[i] = hasSecret[result];

    return result;
  }

  void join(int i, int j) {
    int iRep = find(i);
    int jRep = find(j);

    if (hasSecret[jRep]) {
      parent[iRep] = jRep;
      hasSecret[iRep] = true;
      return;
    }

    this->parent[jRep] = iRep;
    hasSecret[jRep] = hasSecret[jRep];
  }
};

class Solution {
public:
  vector<int> findAllPeople(int n, vector<vector<int>> &meetings,
                            int firstPerson) {
    std::sort(meetings.begin(), meetings.end(),
              [](vector<int> a, vector<int> b) -> bool { return a[2] < b[2]; });

    vector<bool> hasSecret(n);
    UnionFind *unionFind = new UnionFind(n);
    unionFind->hasSecret[0] = true;
    unionFind->hasSecret[firstPerson] = true;

    int i = 0;
    while (i < meetings.size()) {
      int j = i;
      // loop through all meetings at the same time.
      bool secretShared = false;
      vector<int> people;
      while (j < meetings.size() && meetings[j][2] == meetings[i][2]) {
        people.push_back(meetings[j][0]);
        people.push_back(meetings[j][1]);
        unionFind->join(meetings[j][0], meetings[j][1]);
        j++;
      }
      for (auto p : people) {
        if (!unionFind->hasSecret[unionFind->find(p)]) {
          unionFind->parent[p] = p;
        }
      }
      i = j;
    }

    vector<int> ans;

    for (int i = 0; i < n; i++) {
      if (unionFind->hasSecret[i]) {
        ans.push_back(i);
      }
    }

    return ans;
  }
};
