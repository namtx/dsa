#include <fstream>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<vector<int>> dirs = {
    {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1},
};

vector<string> readFile(const string &filename) {
  std::string line;
  std::ifstream file;
  file.open(filename);
  vector<string> result;
  if (file.is_open()) {
    while (std::getline(file, line)) {
      result.push_back(line);
    }
  }
  return result;
}

int part1(const string &filename) {
  int ans = 0;
  vector<string> lines = readFile(filename);
  for (int i = 0; i < lines.size(); i++) {
    string line = lines[i];
    int j = 0;
    while (j < line.size()) {
      int current = 0;
      bool adjacent = false;
      if (line[j] < '0' || line[j] > '9') {
        j++;
      } else {
        int current = 0;
        while (j < line.size() && (line[j] >= '0' && line[j] <= '9')) {
          if (!adjacent) {
            for (auto dir : dirs) {
              int dx = i + dir[0];
              int dy = j + dir[1];
              if (dx >= 0 && dx < lines.size() && dy >= 0 && dy < line.size() &&
                  lines[dx][dy] != '.' &&
                  (lines[dx][dy] < '0' || lines[dx][dy] > '9')) {
                adjacent = true;
                break;
              }
            }
          }
          current = current * 10 + (int)(line[j] - '0');
          j++;
        }
        if (adjacent) {
          cout << current << endl;
          ans += current;
        }
        j++;
      }
    }
  }
  return ans;
}

int part2(const string &filename) {
  int ans = 0;
  vector<string> lines = readFile(filename);
  vector<vector<int>> count(lines.size(), vector<int>(lines[0].size()));
  vector<vector<int>> mul(lines.size(), vector<int>(lines[0].size(), 1));
  for (int i = 0; i < lines.size(); i++) {
    string line = lines[i];
    int j = 0;
    while (j < line.size()) {
      int current = 0;
      bool adjacent = false;
      if (line[j] < '0' || line[j] > '9') {
        j++;
      } else {
        int current = 0;
        int startX = 0;
        int startY = 0;
        while (j < line.size() && (line[j] >= '0' && line[j] <= '9')) {
          if (!adjacent) {
            for (auto dir : dirs) {
              int dx = i + dir[0];
              int dy = j + dir[1];
              if (dx >= 0 && dx < lines.size() && dy >= 0 && dy < line.size() &&
                  lines[dx][dy] == '*') {
                startX = dx;
                startY = dy;
                adjacent = true;
                break;
              }
            }
          }
          current = current * 10 + (int)(line[j] - '0');
          j++;
        }
        if (adjacent) {
          cout << current << endl;
          count[startX][startY]++;
          mul[startX][startY] *= current;
        }
        j++;
      }
    }
  }
  for (int i = 0; i < count.size(); i++) {
    for (int j = 0; j < count[0].size(); j++) {
      if (count[i][j] == 2) {
        ans += mul[i][j];
      }
    }
  }
  return ans;
}

int main() {
  cout << part1("./adventofcode2023/day3.txt") << endl;
  cout << part2("./adventofcode2023/day3.txt") << endl;
}
