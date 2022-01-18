package dev.namtx.geeksforgeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnTopologicalSorting {
    static class Graph {
        public int V;
        public List<List<Integer>> adjacent;
        public int[] inDegrees;
        
        public Graph(int v) {
            this.V = v;
            this.inDegrees = new int[V];
            this.adjacent = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                this.adjacent.add(new ArrayList<Integer>());
            }
        }

        public void addEdge(int v, int u) {
            this.adjacent.get(v).add(u);
            this.inDegrees[u]++;
        }

        public void topologicalSort() {
            Queue<Integer> q = new LinkedList<>();
            List<Integer> topOrder = new ArrayList<>();
            int visitedNodes = 0;
            
            for (int i = 0; i < V; i++) {
                if (this.inDegrees[i] == 0) {
                    q.add(i);
                    visitedNodes++;
                }
            }

            while(!q.isEmpty()) {
                int e = q.poll();
                topOrder.add(e);

                for (int a: this.adjacent.get(e)) {
                    this.inDegrees[a]--;
                    if (this.inDegrees[a] == 0) {
                        q.add(a);
                        visitedNodes++;
                    }
                }
            }

            if (visitedNodes != V) {
                System.out.println("The graph doesn't have topological sort");
            } else {
                for (int i: topOrder) {
                    System.out.println(i);
                }
            }
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
        
        System.out.println("Following is a Topological Sort");

        g.topologicalSort();
    }
}
