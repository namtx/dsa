#include <fstream>
#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>
#define ll long long

using namespace std;

const string &filename = "./adventofcode2023/day8.txt";
const string &testFileName = "./adventofcode2023/day8.test.txt";

vector<string> readLines(bool isTest) {
  std::string line;
  std::ifstream file;
  file.open(isTest ? testFileName : filename);
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

int part1(bool isTest) {
  vector<string> lines = readLines(isTest);
  string instructions = lines[0];
  unordered_map<string, pair<string, string>> map;
  for (int i = 2; i < lines.size(); i++) {
    vector<string> splits = split(lines[i], " = ");
    vector<string> directions = split(splits[1].substr(1, 8), ", ");
    map[splits[0]] = pair<string, string>(directions[0], directions[1]);
  }
  int steps = 0;
  string current = "AAA";
  while (current != "ZZZ") {
    cout << current << endl;
    char step = instructions[steps % instructions.size()];
    if (step == 'L') {
      current = map[current].first;
    } else {
      current = map[current].second;
    }
    steps++;
  }
  return steps;
}

ll gcd(ll a, ll b) {
  if (b == 0)
    return a;
  return gcd(b, a % b);
}

ll lcm(vector<ll> arr) {
  ll ans = 1;
  for (auto n : arr) {
    ans = (ans * n) / gcd(ans, n);
  }
  return ans;
}

unordered_map<string, bool> pointsThatEndsWithZ;
bool isReached(vector<string> points) {
  bool r = true;
  for (auto p : points) {
    if (!pointsThatEndsWithZ[p])
      return false;
  }
  return r;
};

ll part2(bool isTest) {
  vector<string> lines = readLines(isTest);
  string instructions = lines[0];
  unordered_map<string, pair<string, string>> map;
  vector<string> startingPoints;
  for (int i = 2; i < lines.size(); i++) {
    vector<string> splits = split(lines[i], " = ");
    vector<string> directions = split(splits[1].substr(1, 8), ", ");
    char ending = splits[0][splits[0].size() - 1];
    if (ending == 'A') {
      startingPoints.push_back(splits[0]);
    }
    pointsThatEndsWithZ[splits[0]] = ending == 'Z';
    if (ending == 'Z') {
      cout << splits[0] << endl;
      cout << pointsThatEndsWithZ[splits[0]] << endl;
    }
    map[splits[0]] = pair<string, string>(directions[0], directions[1]);
  }

  vector<ll> steps;

  for (auto startingPoint : startingPoints) {
    ll step = 0;
    auto current = startingPoint;
    while (!pointsThatEndsWithZ[current]) {
      char instruction = instructions[step % (ll)instructions.size()];
      if (instruction == 'L') {
        current = map[current].first;
      } else {
        current = map[current].second;
      }
      step++;
    }

    steps.push_back(step);
  }
  return lcm(steps);
}
int main(int argc, char *argv[]) {
  /* cout << part1(false) << endl; */
  cout << part2(false) << endl;
  //
}
