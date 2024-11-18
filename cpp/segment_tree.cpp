#include <iostream>
#include <vector>

using namespace std;

void build(vector<int> &a, vector<int> &t, int v, int tl, int tr) {
  if (tl == tr) {
    t[v] = a[tl];
  } else {
    int tm = (tl + tr) / 2;
    build(a, t, v * 2, tl, tm);
    build(a, t, v * 2 + 1, tm + 1, tr);
    t[v] = t[v * 2] + t[v * 2 + 1];
  }
}

int get(vector<int> &t, int nodeId, int l, int r, int u, int v) {
  if (r < u || v < l)
    return 0;
  if (u <= l && r <= v)
    return t[nodeId];
  int mid = (l + r) / 2;
  int t1 = get(t, nodeId * 2, l, mid, u, v);
  int t2 = get(t, nodeId * 2 + 1, mid + 1, r, u, v);
  return t1 + t2;
}

void update(vector<int> &t, vector<int> &a, int nodeId, int l, int r, int pos,
            int newVal) {
  if (pos < l && r < pos)
    return; // pos is not in range l..r
  if (l == r) {
    t[nodeId] = newVal;
    cout << "update " << l << " " << r << " " << pos << " " << newVal << endl;
    a[pos] = newVal;
    return;
  }

  int mid = (l + r) / 2;
  update(t, a, nodeId * 2, l, mid, pos, newVal);
  update(t, a, nodeId * 2 + 1, mid + 1, r, pos, newVal);
  t[nodeId] = t[nodeId * 2] + t[nodeId * 2 + 1];
}

int main(int argc, char *argv[]) {
  vector<int> a = {1, 3, 5, 2, 4, 6, 8, 7};
  vector<int> t = vector<int>(4 * a.size());
  build(a, t, 1, 0, a.size() - 1);
  cout << get(t, 1, 1, a.size(), 2, 5);
  update(t, a, 1, 1, a.size(), 4, 10);
  cout << get(t, 1, 1, a.size(), 2, 5);
  return 0;
}
