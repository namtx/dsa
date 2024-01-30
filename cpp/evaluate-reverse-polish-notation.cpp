// https://leetcode.com/problems/evaluate-reverse-polish-notation

#include <iostream>
#include <stack>
#include <vector>

using namespace std;

static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();

class Solution {
public:
  int evalRPN(vector<string> &tokens) {
    stack<int> s;
    int ans = 0;
    for (auto token : tokens) {
      if (token == "+" || token == "-" || token == "*" || token == "/") {
        s.push(operate(s, token));
      } else {
        s.push(stoi(token));
      }
    }

    return s.top();
  }

  int operate(stack<int> &s, string op) {
    int second = s.top();
    s.pop();
    int first = s.top();
    s.pop();

    if (op == "+")
      return first + second;
    if (op == "-")
      return first - second;
    if (op == "*")
      return first * second;
    if (op == "/")
      return first / second;
    return -1;
  }
};
