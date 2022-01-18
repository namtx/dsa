package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindCriticalAndPseudoCriticalEdgesInMST {
    static class Vertex {
         public int v;
         public boolean visited = false;
         public List<Edge> edges;

         public Vertex(int v) {
             this.v = v;
             this.edges = new ArrayList<>();
         }

         public void connect(Vertex u, int cost) {
             this.edges.add(new Edge(this, u, cost));
             this.edges.add(new Edge(u, this, cost));
         }
    }

    static class Edge implements Comparable<Edge> {
        public Vertex from;
        public Vertex to;
        public final int cost;

        public Edge(Vertex from, Vertex to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return 0;
        }
    }

    static int mst(Edge pickedEdge, int n) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        addEdge(pickedEdge.from, pq);
        int edgeCount = 0;
        int cost = 0;

        while(!pq.isEmpty() && edgeCount < n - 1) {
            Edge e = pq.poll();
            if (e.to.visited) continue;

            edgeCount++;
            cost += e.cost;

            addEdge(e.to, pq);
        }

        return cost;
    }



    static void addEdge(Vertex v, PriorityQueue<Edge> pq) {
        v.visited = true;
        for (Edge e : v.edges) {
            if (!e.to.visited) pq.add(e);
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        Edge[] edgeArr = new Edge[edges.length];
        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i);
        }

        for (int i = 0; i < edges.length; i++) {
            vertices[edges[i][0]].connect(vertices[edges[i][1]], edges[i][2]);
        }
    }
}
