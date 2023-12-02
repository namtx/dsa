#include <fstream>
#include <iostream>
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

bool isValid(const string &line) {
  vector<string> gameLoads = split(line, "; ");
  for (string g : gameLoads) {
    vector<string> dices = split(g, ", ");
    for (string d : dices) {
      vector<string> dice = split(d, " ");
      if (dice[1] == "red") {
        if (stoi(dice[0]) > 12) {
          return false;
        }
      } else if (dice[1] == "green") {
        if (stoi(dice[0]) > 13) {
          return false;
        }
      } else if (dice[1] == "blue") {
        if (stoi(dice[0]) > 14) {
          return false;
        }
      }
    }
  }
  return true;
}

int gemSet(const string &line) {
  vector<int> s(3);
  vector<string> gameLoads = split(line, "; ");
  for (string g : gameLoads) {
    vector<string> dices = split(g, ", ");
    for (string d : dices) {
      vector<string> dice = split(d, " ");
      int gem = stoi(dice[0]);

      if (dice[1] == "red") {
        s[0] = max(s[0], gem);
      } else if (dice[1] == "green") {
        s[1] = max(s[1], gem);
      } else if (dice[1] == "blue") {
        s[2] = max(s[2], gem);
      }
    }
  }
  return s[0] * s[1] * s[2];
}

int part1(const string &filename) {
  std::string line;
  std::ifstream file;
  file.open(filename);
  int ans = 0;
  if (file.is_open()) {
    while (std::getline(file, line)) {
      vector<string> splits = split(line, ": ");
      int gameIdx = stoi(split(splits[0], " ")[1]);
      if (isValid(splits[1])) {
        ans += gameIdx;
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
  if (file.is_open()) {
    while (std::getline(file, line)) {
      vector<string> splits = split(line, ": ");
      int gameIdx = stoi(split(splits[0], " ")[1]);
      ans += gemSet(splits[1]);
    }
  }
  file.close();

  return ans;
};

int main() {
  cout << part1("./adventofcode2023/day2.txt") << endl;

  cout << part2("./adventofcode2023/day2.txt");
}
