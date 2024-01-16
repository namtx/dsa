#include <cstdlib>
#include <iostream>
#include <set>
#include <vector>

using namespace std;

static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();

class RandomizedSet {
public:
  vector<int> keys;
  set<int> set;
  RandomizedSet() {}

  bool insert(int val) {
    if (set.find(val) == set.end()) {
      keys.push_back(val);
      set.insert(val);
      return true;
    }
    return false;
  }

  bool remove(int val) {
    auto it = set.find(val);
    if (it == set.end()) {
      return false;
    }
    set.erase(it);
    auto keysIt = std::find(keys.begin(), keys.end(), val);
    keys.erase(keysIt);
    return true;
  }

  int getRandom() {
    int randValue = keys[std::rand() % static_cast<int>(keys.size())];
    return *set.find(randValue);
  }
};

int main(int argc, char *argv[]) {
  RandomizedSet *set = new RandomizedSet();
  set->insert(1);
  set->remove(2);
  set->insert(2);
  cout << set->getRandom() << endl;
  return 0;
}
