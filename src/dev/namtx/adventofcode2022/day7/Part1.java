package dev.namtx.adventofcode2022.day7;

import java.io.IOException;

class Part1 extends Solution {
    public static void main(String[] args) throws IOException {
        new Part1().solve();
    }

    public void solve() throws IOException {
        this.buildDirectoryTree();
        this.getDirectorySize(directoriesMap.get("/"));
        long ans = 0;
        for (Directory d : directoriesMap.values()) {
            if (d.size < 100_000) {
                ans += d.size;
            }
        }
        System.out.println(ans);
    }
}
