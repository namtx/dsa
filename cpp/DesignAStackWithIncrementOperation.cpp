class CustomStack {
public:
  int maxSize;
  vector<int> v;
  CustomStack(int maxSize) {
    maxSize = maxSize;
    v = vector<int>();
  }

  void push(int x) {
    if (v.size() < maxSize) {
      v.push_back(x);
    }
  }

  int pop() {
    if (v.size() == 0) {
      return -1;
    }
    v.pop_back();
  }

  void increment(int k, int val) {
    if (k > v.size()) {
      k = v.size();
    }
    for (int i = 0; i < k; i++) {
      v[i] += val;
    }
  }
};

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack* obj = new CustomStack(maxSize);
 * obj->push(x);
 * int param_2 = obj->pop();
 * obj->increment(k,val);
 */
