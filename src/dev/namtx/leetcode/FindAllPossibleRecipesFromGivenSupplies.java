package dev.namtx.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
 *
 * tags: topological sort, dfs
 */
public class FindAllPossibleRecipesFromGivenSupplies {
    public static final int UNVISITED = 0;
    public static final int IMPOSSIBLE = 1;
    public static final int POSSIBLE = 2;

    public static void main(String[] args) {
        String[] recipes = new String[]{"bread"};
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(new ArrayList<String>() {{
            add("yeast");
            add("flour");
        }});
        String[] supplies = new String[]{"yeast"};

        System.out.println(new FindAllPossibleRecipesFromGivenSupplies().findAllRecipes(recipes, ingredients, supplies));
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> suppliesMap = new HashMap<>();
        for (String supply : supplies) suppliesMap.put(supply, POSSIBLE);
        List<String> answer = new ArrayList<>();
        List<String> recipeList = new ArrayList<>(Arrays.asList(recipes));

        for (String recipe : recipes) {
            if (dfs(recipeList, recipe, ingredients, suppliesMap)) {
                answer.add(recipe);
            }
        }

        return answer;
    }

    private boolean dfs(List<String> recipeList, String recipe, List<List<String>> ingredients, Map<String, Integer> suppliesMap) {
        int recipeIndex = recipeList.indexOf(recipe);

        int recipeStatus = suppliesMap.getOrDefault(recipe, UNVISITED);
        if (recipeStatus != UNVISITED) {
            return recipeStatus == POSSIBLE;
        }

        if (recipeIndex == -1) return false;

        suppliesMap.put(recipe, IMPOSSIBLE);
        for (int i = 0; i < ingredients.get(recipeIndex).size(); i++) {
            String ingredient = ingredients.get(recipeIndex).get(i);
            int status = suppliesMap.getOrDefault(ingredient, UNVISITED);
            if (status == POSSIBLE) {
                continue;
            }

            if (status == IMPOSSIBLE || !dfs(recipeList, ingredient, ingredients, suppliesMap)) {
                return false;
            }
        }

        suppliesMap.put(recipe, POSSIBLE);

        return true;
    }
}
