#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Employee {
public:
  int id;
  int importance;
  vector<int> subordinates;
};

/**
 * Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
 * Output: 11
 */

/** Notes:
 * DFS
 */
class Solution {
public:
  int getImportance(vector<Employee *> employees, int id) {
    for (auto e : employees) {
      employeeMap[e->id] = e;
    }

    Employee *e = employeeMap[id];

    dfs(e);

    return ans;
  }

private:
  unordered_map<int, Employee *> employeeMap;
  int ans = 0;

  void dfs(Employee *employee) {
    ans += employee->importance;

    for (auto subordinate : employee->subordinates) {
      dfs(employeeMap[subordinate]);
    }
  }
};

int main(int argc, char *argv[]) {
  Employee *first = new Employee();
  first->id = 1;
  first->importance = 5;
  first->subordinates = {2, 3};
  Employee *second = new Employee();
  second->id = 2;
  second->importance = 3;
  Employee *third = new Employee();
  third->id = 3;
  third->importance = 3;

  vector<Employee *> employees = {first, second, third};
  cout << (new Solution())->getImportance(employees, 1);
  return 0;
}
