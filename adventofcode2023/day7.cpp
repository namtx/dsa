#include <__errc>
#include <cmath>
#include <fstream>
#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

unordered_map<char, long> cardPoints = {
    {'2', 2}, {'3', 3},  {'4', 4},  {'5', 5},  {'6', 6},  {'7', 7}, {'8', 8},
    {'9', 9}, {'T', 10}, {'J', 11}, {'Q', 12}, {'K', 13}, {'A', 14}};
unordered_map<char, long> cardPointsWithJoker = {
    {'2', 2}, {'3', 3},  {'4', 4}, {'5', 5},  {'6', 6},  {'7', 7}, {'8', 8},
    {'9', 9}, {'T', 10}, {'J', 1}, {'Q', 12}, {'K', 13}, {'A', 14}};

long getPoint(const string &hand, bool joker) {
  unordered_map<char, int> count;
  long r = 0;
  for (auto c : hand) {
    count[c]++;
    r = r * 100 + (joker ? cardPointsWithJoker[c] : cardPoints[c]);
  }

  bool isJokerApplied = joker && count.count('J') > 0;
  long typePoint;
  //
  // five of kind: 7
  // four of kind 6
  // full house 5
  // three of kind 4
  // two pair 3
  // one pair 2
  // diff 1
  //
  if (count.size() == 1) {
    typePoint = 7; // five of kind
  } else if (count.size() == 2) {
    if (count[hand[0]] == 1 || count[hand[0]] == 4) {
      typePoint = 6; // four of kind
      if (isJokerApplied) {
        typePoint = 7; // five of kind
      }
    } else {
      typePoint = 5; // full-house
      if (isJokerApplied) {
        typePoint = 7; // five of kind
      }
    }
  } else if (count.size() == 3) {
    // two pair
    if (count[hand[0]] == 2 || count[hand[1]] == 2) {
      typePoint = 3;
      if (isJokerApplied) {
        typePoint = (count['J'] == 2) ? 6 : 5; // four of kind or full-house
      }
      // three of a kind
    } else {
      typePoint = 4;
      if (isJokerApplied) {
        typePoint = 6;
      }
    }
  } else if (count.size() == 4) {
    typePoint = 2; // one pair
    if (isJokerApplied) {
      typePoint = 4; // three of kind
    }
  } else {
    typePoint = 1; // diff
    if (isJokerApplied) {
      typePoint = 2; // one pair
    }
  }

  return typePoint * pow(10, 12) + r;
}

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

unordered_map<string, long> points;

long winning(const string &filename, bool joker) {
  vector<string> lines = readLines(filename);
  unordered_map<string, long> bids;
  vector<string> hands;
  for (auto line : lines) {
    vector<string> splits = split(line, " ");
    hands.push_back(splits[0]);
    bids[splits[0]] = stol(splits[1]);
    points[splits[0]] = getPoint(splits[0], joker);
  }
  std::sort(hands.begin(), hands.end(),
            [](string a, string b) { return points[a] < points[b]; });

  long r = 0;
  long rank = 1;
  for (auto s : hands) {
    r += rank * bids[s];
    rank++;
  }

  return r;
}

long part1(const string &filename) { return winning(filename, false); }

long part2(const string &filename) { return winning(filename, true); }

int main(int argc, char *argv[]) {
  //
  /* cout << part1("./adventofcode2023/day7.test.txt") << endl; */
  cout << part1("./adventofcode2023/day7.txt") << endl;
  cout << part2("./adventofcode2023/day7.txt") << endl;
}
