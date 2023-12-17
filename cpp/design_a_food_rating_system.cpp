#include <iostream>
#include <set>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

static auto _ = []() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  return nullptr;
}();

struct FoodRating {
  string food;
  int rating;

  FoodRating(string f, int r) : food(f), rating(r){};

  bool operator==(const FoodRating &other) const { return other.food == food; }
  bool operator<(const FoodRating &other) const {
    if (other.rating == rating) {
      return food < other.food;
    } else {
      return rating > other.rating;
    }
  }
};

class FoodRatings {
public:
  FoodRatings(vector<string> &foods, vector<string> &cuisines,
              vector<int> &ratings) {

    for (int i = 0; i < foods.size(); i++) {
      foodAndCuisinceMapping[foods[i]] = cuisines[i];
      foodAndRatingMapping[foods[i]] = ratings[i];
      if (m.find(cuisines[i]) == m.end()) {
        m[cuisines[i]] = set<FoodRating>();
      }
      m[cuisines[i]].insert(FoodRating(foods[i], ratings[i]));
    }
  }

  void changeRating(string food, int newRating) {
    int oldRating = foodAndRatingMapping[food];
    foodAndRatingMapping[food] = newRating;
    auto old =
        m[foodAndCuisinceMapping[food]].find(FoodRating(food, oldRating));
    m[foodAndCuisinceMapping[food]].erase(old);
    m[foodAndCuisinceMapping[food]].insert(FoodRating(food, newRating));
  }

  string highestRated(string cuisine) {
    auto p = *m[cuisine].begin();
    return p.food;
  }

private:
  unordered_map<string, set<FoodRating>> m;
  unordered_map<string, string> foodAndCuisinceMapping;
  unordered_map<string, int> foodAndRatingMapping;
};
