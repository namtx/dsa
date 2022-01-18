package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-to-connect-all-points/">Minimum Cost to Connect All Points</a>
 */
public class MinimumCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        Vertex[] vertices = new Vertex[points.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Vertex minVertex = null;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            vertices[i] = new Vertex(points[i][0], points[i][1]);
        }

        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                if (i == j) continue;

                int cost = Math.abs(vertices[i].x - vertices[j].x) + Math.abs(vertices[i].y - vertices[j].y);
                vertices[i].connect(vertices[j], cost);
                if (cost < min) {
                    min = cost;
                    minVertex = vertices[i];
                }
            }
        }

        addEdge(minVertex, pq);

        int minCost = 0;
        int edgeCount = 0;
        while (!pq.isEmpty() && edgeCount < points.length - 1) {
            Edge me = pq.poll();
            if (me.to.visited) {
                continue;
            }
            minCost += me.cost;
            edgeCount++;
            addEdge(me.to, pq);
        }

        return minCost;
    }

    public void addEdge(Vertex v, PriorityQueue<Edge> pq) {
        v.visited = true;
        for (Edge e : v.edges) {
            if (!e.to.visited) {
                pq.add(e);
            }
        }
    }

    static class Vertex {
        public int x;
        public int y;
        public boolean visited = false;
        public List<Edge> edges;

        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
            this.edges = new ArrayList<>();
        }

        public void connect(Vertex v, int cost) {
            this.edges.add(new Edge(this, v, cost));
            this.edges.add(new Edge(v, this, cost));
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static class Edge implements Comparable<Edge> {
        public Vertex from;
        public Vertex to;
        public int cost;

        public Edge(Vertex from, Vertex to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", cost=" + cost +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };
        System.out.println(new MinimumCostToConnectAllPoints().minCostConnectPoints(points));
    }
}