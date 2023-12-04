#include <cmath>
#include <fstream>
#include <iostream>
#include <set>
#include <string>
#include <vector>

using namespace std;

vector<string> split(const string &s, const string &delimiter) {
  vector<string> tokens;
  size_t start = 0, end = 0;

  while (((end = s.find(delimiter, start)) != string::npos)) {
    tokens.push_back(s.substr(start, end - start));
    start = end + delimiter.length();
  }

  tokens.push_back(s.substr(start));

  return tokens;
}

vector<int> getNums(const string &numsStr) {
  vector<int> r;
  vector<string> nums = split(numsStr, " ");
  for (auto num : nums) {
    if (num == "") {
      continue;
    }
    r.push_back(stoi(num));
  }
  for (auto n : r) {
    cout << n << ", ";
  }
  cout << endl;
  return r;
}

int getMatchingPoint(const string &game) {
  vector<string> splits = split(split(game, ": ")[1], " | ");
  set<int> s;
  int count = 0;
  for (auto n : getNums(splits[1])) {
    s.insert(n);
  }
  for (auto n : getNums(splits[0])) {
    if (s.find(n) != s.end()) {
      count++;
    }
  }
  return count;
}

int part1(const string &filename) {
  std::string line;
  std::ifstream file;
  file.open(filename);
  int ans = 0;
  if (file.is_open()) {
    while (std::getline(file, line)) {
      int points = getMatchingPoint(line);
      if (points <= 1) {
        ans += points;
      } else {
        ans += pow(2, points - 1);
      }
    }
  }
  file.close();

  return ans;
};

int part2(const string &filename) {
  std::string line;
  std::ifstream file;
  file.open(filename);
  int ans = 0;
  vector<int> cards(300, 0);
  int maxGameNum = 0;
  int idx = 1;
  if (file.is_open()) {
    while (std::getline(file, line)) {
      int matchingPoint = getMatchingPoint(line);
      cards[idx]++;
      for (int i = 1; i <= matchingPoint; i++) {
        cards[idx + i] += cards[idx];
      }

      idx++;
    }
    file.close();
  }
  for (auto card : cards) {
    ans += card;
  }
  return ans;
}

int main(int argc, char *argv[]) {
  cout << part1("./adventofcode2023/day4.txt") << endl;
  cout << part2("./adventofcode2023/day4.txt") << endl;
  return 0;
}
