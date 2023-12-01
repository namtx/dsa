#include <fstream>
#include <iostream>
#include <string>

using namespace std;

/**
 * check if a character at i is a number?
 */
int extract(string line, int i, bool stringAccepted) {
  if (line[i] >= '0' && line[i] <= '9')
    return (int)(line[i] - '0');

  if (!stringAccepted)
    return 0;

  if (line.substr(i, 3) == "one")
    return 1;
  if (line.substr(i, 3) == "two")
    return 2;

  if (line.substr(i, 5) == "three")
    return 3;

  if (line.substr(i, 4) == "four")
    return 4;

  if (line.substr(i, 4) == "five")
    return 5;

  if (line.substr(i, 3) == "six")
    return 6;

  if (line.substr(i, 5) == "seven")
    return 7;

  if (line.substr(i, 5) == "eight")
    return 8;

  if (line.substr(i, 4) == "nine")
    return 9;

  return 0;
}

int getSum(bool stringAccepted, string fileName) {
  std::string line;
  std::ifstream file;
  int ans = 0;
  file.open(fileName);
  if (file.is_open()) {
    while (getline(file, line)) {
      std::cout << line << std::endl;
      int left = 0;
      int right = line.size() - 1;
      int l = extract(line, left, stringAccepted);
      while (l == 0) {
        left++;
        l = extract(line, left, stringAccepted);
      }
      int r = extract(line, right, stringAccepted);
      while (r == 0) {
        right--;
        r = extract(line, right, stringAccepted);
      }
      ans += l * 10 + r;
    }
    return ans;
  } else {
    std::cout << "Could not open file" << std::endl;
  }
  return 0;
}

int main(int argc, char *argv[]) {
  std::cout << getSum(false, "./adventofcode2023/day1.txt") << std::endl;
  std::cout << getSum(true, "./adventofcode2023/day1.txt") << std::endl;
  return 0;
}
