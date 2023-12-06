#include <cmath>
#include <fstream>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<string> readLines(const string &filename) {
  std::string line;
  std::ifstream file;
  file.open(filename);
  vector<string> lines;
  if (file.is_open()) {
    while (std::getline(file, line)) {
      lines.push_back(line);
    }
  }
  file.close();
  return lines;
}

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

long part1(const string &filename) {
  vector<string> lines = readLines(filename);
  vector<long> times;
  vector<long> distances;
  for (auto s : split(lines[0], " ")) {
    if (s.size() > 0 && s[0] >= '0' && s[0] <= '9') {
      times.push_back(stol(s));
    }
  }
  for (auto s : split(lines[1], " ")) {
    if (s.size() > 0 && s[0] >= '0' && s[0] <= '9') {
      distances.push_back(stol(s));
    }
  }

  long ans = 1;

  for (int i = 0; i < times.size(); i++) {
    long count = 0;
    for (int j = 1; j < times[i]; j++) {
      if (j * (times[i] - j) > distances[i]) {
        count++;
      }
    }
    if (count != 0) {
      ans *= count;
    }
  }

  return ans;
}

long part2(const string &filename) {
  vector<string> lines = readLines(filename);
  long long time = 0;
  long long distance = 0;
  for (auto s : split(lines[0], " ")) {
    if (s.size() > 0 && s[0] >= '0' && s[0] <= '9') {
      time = time * (pow(10, s.size())) + stol(s);
    }
  }
  for (auto s : split(lines[1], " ")) {
    if (s.size() > 0 && s[0] >= '0' && s[0] <= '9') {
      distance = distance * pow(10, s.size()) + stol(s);
    }
  }

  long long count = 0;
  for (long long j = 1; j < time; j++) {
    if (j * (time - j) > distance) {
      count++;
    }
  }
  return count;
}

int main(int argc, char *argv[]) {
  cout << part1("./adventofcode2023/day6.txt") << endl;
  cout << part2("./adventofcode2023/day6.txt") << endl;
  return 0;
}
