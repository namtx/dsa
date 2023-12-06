#include <climits>
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

int doFilter(int seed, vector<int> filter) {
  if (seed >= filter[1] && seed <= filter[1] + filter[2] - 1) {
    return seed + (filter[0] - filter[1]);
  }
  return seed;
}

long part1(const string &filename) {
  auto lines = readLines(filename);
  vector<long> seeds;
  vector<vector<vector<long>>> maps;
  bool readingSoilMap = false;
  int part = -1;
  for (auto line : lines) {
    // seeds: 79 14 55 13
    if (part == -1 && line.rfind("seeds: ") == 0) {
      for (auto seed : split(split(line, ": ")[1], " ")) {
        seeds.push_back(stol(seed));
      }
    } else if (line == "") {
      part++;
      maps.push_back(vector<vector<long>>());
    } else if (line[0] >= '0' && line[0] <= '9') {
      vector<string> nums = split(line, " ");
      maps[part].push_back({stol(nums[0]), stol(nums[1]), stol(nums[2])});
    }
  }
  long min = LONG_MAX;
  for (auto seed : seeds) {
    cout << "seed: " << seed << endl;
    for (auto map : maps) {
      for (auto filter : map) {
        if (seed >= filter[1] && seed <= filter[1] + filter[2] - 1) {
          seed = seed + (filter[0] - filter[1]);
          cout << seed << endl;
          break;
        }
      }
    }
    if (min > seed) {
      min = seed;
    }
  }

  return min;
}

long part2(const string &filename) {
  auto lines = readLines(filename);
  vector<long> seeds;
  vector<vector<vector<long>>> maps;
  bool readingSoilMap = false;
  int part = -1;
  for (auto line : lines) {
    // seeds: 79 14 55 13
    if (part == -1 && line.rfind("seeds: ") == 0) {
      for (auto seed : split(split(line, ": ")[1], " ")) {
        seeds.push_back(stol(seed));
      }
    } else if (line == "") {
      part++;
      maps.push_back(vector<vector<long>>());
    } else if (line[0] >= '0' && line[0] <= '9') {
      vector<string> nums = split(line, " ");
      maps[part].push_back({stol(nums[0]), stol(nums[1]), stol(nums[2])});
    }
  }
  long min = LONG_MAX;
  for (int i = 0; i < seeds.size(); i += 2) {
    for (long seed = seeds[i]; seed <= seeds[i] + seeds[i + 1] - 1; seed++) {
      long s = seed;
      for (auto map : maps) {
        for (auto filter : map) {
          if (seed >= filter[1] && seed <= filter[1] + filter[2] - 1) {
            seed = seed + (filter[0] - filter[1]);
            break;
          }
        }
      }
      if (min > seed) {
        min = seed;
      }

      seed = s;
    }
  }

  return min;
}

int main(int argc, char *argv[]) {
  /* cout << part1("./adventofcode2023/day5.txt") << endl; */
  /* cout << part2("./adventofcode2023/day5.txt") << endl; */
  cout << part2("./adventofcode2023/day5.txt") << endl;
  ///
  return 0;
}
