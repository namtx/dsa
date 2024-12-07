#include <iostream>
#include <fstream>
#include <vector>
#include "../helper.h"


using namespace std;

struct Expression {
    int position;
    string content;
};

bool is_digit(char c) {
    return c >= '0' && c <= '9';
}

vector<Expression> find_expressions(string line) {
    vector<Expression> expressions;
    auto i = 0;
    while (i < line.size()) {
        if (line[i] == 'm') {
            if (line.substr(i, 4) == "mul(") {
                auto start = i + 4;
                auto end = line.find(")", start);
                // validate the expression is valid
                if (end != string::npos) {
                    // find comma
                    auto comma = line.find(",", start);
                    bool valid = true;
                    if (comma < end) {
                        for (auto j = start; j < comma; j++) {
                            if (!is_digit(line[j])) {
                                valid = false;
                                break;
                            }
                        }
                        for (auto j = comma + 1; j < end; j++) {
                            if (!is_digit(line[j])) {
                                valid = false;
                                break;
                            }
                        }
                    } else {
                        valid = false;
                    }
                    if (valid) {
                        expressions.push_back({start, line.substr(start, end - start)});
                        i = end + 1;
                        continue;
                    }
                }
            }
        } else if (line[i] == 'd') {
            if (line.substr(i, 4) == "do()") {
                expressions.push_back({i, "do()"});
                i = i + 4;
                continue;
            } else if (line.substr(i, 7) == "don't()") {
                expressions.push_back({i, "don't()"});
                i = i + 7;
                continue;
            }
        }
        i++;
    }
    return expressions;
}

long long eval_expression(Expression expression) {
    auto comma = expression.content.find(",");
    auto first = stoll(expression.content.substr(0, comma));
    auto second = stoll(expression.content.substr(comma + 1));
    return first * second;
}

long long part1(vector<string> lines) {
    long long result = 0;
    for (auto line : lines) {
        auto expressions = find_expressions(line);
        for (auto expression : expressions) {
            if (expression.content != "don't()" && expression.content != "do()") {
                // cout << expression.content << endl;
                result += eval_expression(expression);
            }
        }
    }
    return result;
}

long long part2(vector<string> lines) {
    long long result = 0;
    bool dont = false;
    for (auto line : lines) {
        auto expressions = find_expressions(line);
        for (auto expression : expressions) {
            if (expression.content == "don't()") {
                dont = true;
            } else if (expression.content == "do()") {
                dont = false;
            } else {
                if (!dont) {
                    result += eval_expression(expression);
                }
            }
        }
    }
    return result;
}

int main(int argc, char **argv) {
    ifstream file(argv[1]);
    string line;
    vector<string> lines;
    while (getline(file, line)) {
        lines.push_back(line);
    }
    cout << part1(lines) << endl;
    cout << part2(lines) << endl;
}
