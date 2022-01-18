package dev.namtx.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://www.geeksforgeeks.org/topological-sorting/">Topological Sorting</a>
 */

public class TopologicalSorting {
    static class Graph {
        public final int V;
        public List<List<Integer>> adjacent;

        public Graph(int v) {
            this.V = v;
            this.adjacent = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                this.adjacent.add(new ArrayList<Integer>());
            }
        }

        public void addEdge(int v, int u) {
            this.adjacent.get(v).add(u);
        }

        public void topologicalSort() {
            Stack<Integer> s = new Stack<>();
            boolean[] visited = new boolean[V];

            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    topologicalSortUtil(i, visited, s);
                }
            }

            while(!s.isEmpty()) {
                System.out.println("-> " + s.pop());
            }
        }

        private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> s) {
            visited[v] = true;

            for (int a: adjacent.get(v)) {
                if (!visited[a]) {
                    topologicalSortUtil(a, visited, s);
                }
            }
            s.push(v);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Topological sort:");
        g.topologicalSort();
    }
}
