#include <iostream>
#include <fstream>
#include <vector>
#include "../helper.h"

using namespace std;

vector<string> findAllStrings(vector< vector<char> > grid, int i, int j, int length) {
  vector<string> result;
  // forward horizontal
  string forward_horizontal = "";
  if (j + length - 1 < grid[i].size()) {
    for (int k = 0; k < length; k++) {
      forward_horizontal += grid[i][j + k];
    }
    result.push_back(forward_horizontal);
  }
  // backward horizontal
  string backward_horizontal = "";
  if (j - length + 1 >= 0) {
    for (int k = 0; k < length; k++) {
      backward_horizontal += grid[i][j - k];
    }
    result.push_back(backward_horizontal);
  }
  // forward vertical
  string forward_vertical = "";
  if (i + length - 1 < grid.size()) {
    for (int k = 0; k < length; k++) {
      forward_vertical += grid[i + k][j];
    }
    result.push_back(forward_vertical);
  }
  // backward vertical
  string backward_vertical = "";
  if (i - length + 1 >= 0) {
    for (int k = 0; k < length; k++) {
      backward_vertical += grid[i - k][j];
    }
    result.push_back(backward_vertical);
  }
  // forward diagonal
  string forward_diagonal = "";
  if (i + length - 1 < grid.size() && j + length - 1 < grid[i].size()) {
    for (int k = 0; k < length; k++) {
      forward_diagonal += grid[i + k][j + k];
    }
    result.push_back(forward_diagonal);
  }
  // backward diagonal
  string backward_diagonal = "";
  if (i - length + 1 >= 0 && j - length + 1 >= 0) { 
    for (int k = 0; k < length; k++) {
      backward_diagonal += grid[i - k][j - k];
    }
    result.push_back(backward_diagonal);
  }

  // forward diagonal 2
  string forward_diagonal_2 = "";
  if (i + length - 1 < grid.size() && j - length + 1 >= 0) {
    for (int k = 0; k < length; k++) {
      forward_diagonal_2 += grid[i + k][j - k];
    }
    result.push_back(forward_diagonal_2);
  }

  // backward diagonal 2
  string backward_diagonal_2 = "";
  if (i - length + 1 >= 0 && j + length - 1 < grid[i].size()) {
    for (int k = 0; k < length; k++) {
      backward_diagonal_2 += grid[i - k][j + k];
    }
    result.push_back(backward_diagonal_2);
  }

  return result;
}

int part1(vector< vector<char> > grid) {
  int result = 0;
  for (int i = 0; i < grid.size(); i++) {
    for (int j = 0; j < grid[i].size(); j++) {
      if (grid[i][j] == 'X') {
        vector<string> strings = findAllStrings(grid, i, j, 4);
        for (auto s: strings) {
          if (s == "XMAS") {
            result++;
          }
        }
      }
    }
  }

  return result;
}

bool isMAS(vector<vector<char>> grid, int i, int j) {
  if (i + 1 < grid.size() && j + 1 < grid[i].size() && j - 1 >= 0 && i - 1 >= 0) {
    if (((grid[i-1][j-1] == 'M' && grid[i+1][j+1] == 'S') || (grid[i-1][j-1] == 'S' && grid[i+1][j+1] == 'M')) && 
        ((grid[i-1][j+1] == 'M' && grid[i+1][j-1] == 'S') || (grid[i-1][j+1] == 'S' && grid[i+1][j-1] == 'M'))) {
      return true;
    }
  }
  return false;
}

int part2(vector< vector<char> > grid) {
  int result = 0;
  for (int i = 0; i < grid.size(); i++) {
    for (int j = 0; j < grid[i].size(); j++) {
      if (grid[i][j] == 'A') {
        if (isMAS(grid, i, j)) {
          result++;
        }
      }
    }
  }

  return result;
}

int main(int argc, char *argv[]) {
  ifstream input(argv[1]);
  string line;
  vector<string> lines;
  while (getline(input, line)) {
    lines.push_back(line);
  }
  vector< vector<char> > grid;

  for (auto line: lines) {
    vector<char> row;
    for (auto c: line) {
      row.push_back(c);
    }
    grid.push_back(row);
  }
  cout << part1(grid) << endl;
  cout << part2(grid) << endl;
}
