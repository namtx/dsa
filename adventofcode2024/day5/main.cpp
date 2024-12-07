#include <iostream>
#include <vector>
#include <fstream>
#include "../helper.h"
#include <unordered_map>
#include <unordered_set>

using namespace std;

struct Node {
    int value;
    unordered_set<int> before;
    unordered_set<int> after;
};

unordered_map<int, Node> graph;

vector<int> split_to_ints(string line, string delimiter) {
    vector<int> numbers;
    vector<int> result;
    for (string s : split(line, delimiter)) {
        result.push_back(stoi(s));
    }
    return result;
}

void parse_line(string line) { 
    if (line.find("|") != string::npos) {
        vector<int> numbers = split_to_ints(line, "|");
        graph[numbers[0]].after.insert(numbers[1]);
        graph[numbers[1]].before.insert(numbers[0]);
    }
}

bool validate_node(Node node, int i, vector<int> numbers) {
    for (int j = 0; j < i; j++) {
        if (node.before.find(numbers[j]) == node.before.end()) {
            return false;
        }
    }

    for (int j = i + 1; j < numbers.size(); j++) {
        if (node.after.find(numbers[j]) == node.after.end()) {
            return false;
        }
    }

    return true;
}

long long part1(vector<string> lines) {
    long long result = 0;
    for (string line : lines) {
        if (line.find("|") != string::npos) {
            parse_line(line);
        } else if (line.find(",") != string::npos) {
            vector<int> numbers = split_to_ints(line, ",");
            bool valid = true;
            for (int i = 0; i < numbers.size(); i++) {
                if (!validate_node(graph[numbers[i]], i, numbers)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
               result += numbers[numbers.size()/2];
            }
        }
    }

    return result;
}

long long part2(vector<string> lines) {
    long long result = 0;
    for (string line : lines) {
        if (line.find("|") != string::npos) {
            parse_line(line);
        } else if (line.find(",") != string::npos) {
            vector<int> numbers = split_to_ints(line, ",");
            bool valid = true;
            for (int i = 0; i < numbers.size(); i++) {
                if (!validate_node(graph[numbers[i]], i, numbers)) {
                    valid = false;
                    break;
                }
            }
            if (!valid) {
                // find a node that have balance before and after
                for (int i = 0; i < numbers.size(); i++) {
                    int before = 0;
                    int after = 0;
                    for (int j = 0; j <numbers.size() ; j++) {
                        if (i != j && graph[numbers[i]].before.find(numbers[j]) != graph[numbers[i]].before.end()) {
                            before++;
                        }
                    }
                    for (int j = 0; j <numbers.size() ; j++) {
                        if (i != j && graph[numbers[i]].after.find(numbers[j]) != graph[numbers[i]].after.end()) {
                            after++;
                        }
                    }
                    if (before == after) {
                        result += numbers[i];
                    }
                }
            }
        }
    }

    return result;
}

int main(int argc, char** argv) {
    vector<string> lines = read_lines(argv[1]);
    cout << part1(lines) << endl;
    cout << part2(lines) << endl;
}
