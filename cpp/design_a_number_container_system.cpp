#include <iostream>
#include <set>
#include <unordered_map>

using namespace std;

class NumberContainers {
public:
  NumberContainers() {}

  void change(int index, int number) {
    if (m.find(number) == m.end()) {
      m[number] = set<int>();
    }
    if (values.find(index) == values.end()) {
      values[index] = number;
      m[number].insert(index);
    } else {
      auto it = m[values[index]].find(index);
      m[values[index]].erase(it);
      m[number].insert(index);
      values[index] = number;
    }
  }

  int find(int number) {
    auto it = m.find(number);
    if (it == m.end() || it->second.empty())
      return -1;

    return *m[number].begin();
  }

private:
  std::unordered_map<int, std::set<int>> m;
  std::unordered_map<int, int> values;
};

int main(int argc, char *argv[]) {
  NumberContainers *nc = new NumberContainers();
  nc->change(1, 10);
  cout << nc->find(10) << endl;
  nc->change(1, 20);
  cout << nc->find(10) << endl;
  cout << nc->find(20) << endl;
  cout << nc->find(30) << endl;
  return 0;
}
