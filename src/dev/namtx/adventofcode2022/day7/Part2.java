package dev.namtx.adventofcode2022.day7;

import java.io.IOException;

class Part2 extends Solution {
    public static void main(String[] args) throws IOException {
        new Part2().solve();
    }

    public void solve() throws IOException {
        buildDirectoryTree();
        getDirectorySize(directoriesMap.get("/"));
        long currentUnusedSpace = 70_000_000 - directoriesMap.get("/").size;
        long ans = Long.MAX_VALUE;
        for (Directory d : directoriesMap.values()) {
            if (d.size + currentUnusedSpace >= 30_000_000) {
                ans = Math.min(d.size, ans);
            }
        }
        System.out.println(ans);
    }
}
