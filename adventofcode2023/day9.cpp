#include <fstream>
#include <iostream>
#include <string>
#include <vector>
#define ll long long

using namespace std;

const string &filename = "./adventofcode2023/day9.txt";
const string &testFileName = "./adventofcode2023/day9.test.txt";

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

vector<ll> diffs(vector<ll> nums) {
  vector<ll> ans;
  for (int i = 1; i < nums.size(); i++) {
    ans.push_back(nums[i] - nums[i - 1]);
  }
  return ans;
}

bool same(vector<ll> nums) {
  ll diff = nums[1] - nums[0];
  for (int i = 2; i < nums.size(); i++) {
    if (nums[i] - nums[i - 1] != diff)
      return false;
  }
  return true;
}

ll findHistory(vector<ll> nums, bool part2) {
  vector<vector<ll>> layers;
  layers.push_back(nums);
  vector<ll> layer = layers[layers.size() - 1];
  while (!same(layer)) {
    layers.push_back(diffs(layers[layers.size() - 1]));
    layer = layers[layers.size() - 1];
  }

  ll ans = 0;
  ll diff = layers[layers.size() - 1][1] - layers[layers.size() - 1][0];
  for (int i = layers.size() - 1; i >= 0; i--) {
    if (!part2) {
      diff = layers[i][layers[i].size() - 1] + diff;
    } else {
      diff = layers[i][0] - diff;
    }
  }
  return diff;
}

ll part1(bool isTest) {
  vector<string> lines = readLines(isTest);
  ll ans = 0;
  for (auto line : lines) {
    vector<ll> nums;
    for (auto num : split(line, " ")) {
      nums.push_back(stol(num));
    }

    ans += findHistory(nums, false);
  }
  return ans;
}

ll part2(bool isTest) {
  vector<string> lines = readLines(isTest);
  ll ans = 0;
  for (auto line : lines) {
    vector<ll> nums;
    for (auto num : split(line, " ")) {
      nums.push_back(stol(num));
    }

    ans += findHistory(nums, true);
  }
  return ans;
}

int main() {
  cout << part1(false) << endl;
  cout << part2(false) << endl;
}
