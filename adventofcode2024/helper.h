#ifndef HELPER_H
#define HELPER_H

#include <vector>

using namespace std;

vector<string> split(string s, string delimiter) {
  vector<string> res;
  size_t pos = 0;
  string token;
  while ((pos = s.find(delimiter)) != string::npos) {
    token = s.substr(0, pos);
    res.push_back(token);
    s.erase(0, pos + delimiter.length());
  }
  res.push_back(s);
  return res;
}   

vector<string> read_lines(string filename) {
    ifstream file(filename);
    string line;
    vector<string> lines;
    while (getline(file, line)) {
        lines.push_back(line);
    }
    return lines;
}

#endif
