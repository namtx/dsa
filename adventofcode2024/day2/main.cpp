#include <iostream>
#include <vector>
#include <fstream>
#include "../helper.h"

using namespace std;

bool isSafe(vector<int> row) {
    bool increasing = row[0] < row[1];
    for (int i = 0; i < row.size() -1; i++) {
        if (row[i] == row[i+1]) return false;
        if (row[i] > row[i+1] && increasing) return false;
        if (row[i] < row[i+1] && !increasing) return false;
        if (abs(row[i] - row[i+1]) > 3) return false;
    }
    return true;
}

bool isSafe2(vector<int> row) {
    if (isSafe(row)) return true;
    for (int i = 0; i < row.size(); i++) {
        vector<int> newRow = row;
        newRow.erase(newRow.begin() + i);
        if (isSafe(newRow)) return true;
    }
    return false;
}

int part1(vector< vector<int> > input) {
    int safeRows = 0;
    for (vector<int> row : input) {
        if (isSafe(row)) safeRows++;
    }
    return safeRows;
}

int part2(vector< vector<int> > input) {
    int safeRows = 0;
    for (vector<int> row : input) {
        if (isSafe2(row)) safeRows++;
    }
    return safeRows;
}

int main(int argc, char* argv[]) {
    ifstream file(argv[1]);
    vector< vector<int> > input;
    string line;
    while (getline(file, line)) {
        vector<int> row;
        vector<string> tokens = split(line, " ");
        for (string token : tokens) {
            row.push_back(stoi(token));
        }
        input.push_back(row);
    }

    cout << part1(input) << endl;
    cout << part2(input) << endl;
}
