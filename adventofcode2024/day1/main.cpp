#include <iostream>
#include <fstream>
#include <vector>
#include <unordered_map>
#include "../helper.h"

using namespace std;

int part1(vector< vector<int> > input) {
    sort(input[0].begin(), input[0].end());
    sort(input[1].begin(), input[1].end());
    int result = 0;
    for (int i = 0; i < input[0].size(); i++) {
        result += abs(input[0][i] - input[1][i]);
    }
    return result;
}

long long part2(vector< vector<int> > input) {
    unordered_map<int, int> m;
    long long result = 0;
    for (int i = 0; i < input[1].size(); i++) {
        m[input[1][i]]++;
    }
    for (int i = 0; i < input[0].size(); i++) {
        result += input[0][i] * m[input[0][i]];
    }
    return result;
}

int main(int argc, char* argv[]) {
    ifstream file(argv[1]);
    string line;
    vector< vector<int> > input = {{}, {}};
    while (getline(file, line)) {
        vector<string> tokens = split(line, "   ");
        input[0].push_back(stoi(tokens[0]));
        input[1].push_back(stoi(tokens[1]));
    }

    cout << part1(input) << endl;
    cout << part2(input) << endl;

    return 0;
}
