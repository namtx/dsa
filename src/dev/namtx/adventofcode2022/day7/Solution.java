package dev.namtx.adventofcode2022.day7;

import dev.namtx.adventofcode2022.utils.IterableFileReader;

import java.io.IOException;
import java.util.*;

public class Solution {
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day7/input.txt";
    static long part1Ans = 0;
    private static Map<String, Directory> directoriesMap = new HashMap<>();

    public static long getDirectorySize(Directory directory) {
        if (directory.size != -1) return directory.size;
        long ans = 0;
        for (File file : directory.files) {
            ans += file.size;
        }
        for (Directory sub : directory.subDirectories) {
            ans += getDirectorySize(sub);
        }
        if (ans < 100000) {
            System.out.println(directory.path);
            part1Ans += ans;
        }
        directory.size = ans;
        return ans;
    }

    public static void buildDirectoryTree() throws IOException {
        IterableFileReader fileReader = new IterableFileReader(FILE_PATH);
        // keep track the current path
        Stack<Directory> stack = new Stack<>();
        Directory rootDirectory = new Directory("/");
        directoriesMap.put("/", rootDirectory);

        fileReader.forEach(s -> {
            String[] parts = s.split(" ");
            if (parts[0].equals("$") && parts[1].equals("cd")) {
                if (parts[2].equals("..")) {
                    if (stack.isEmpty()) {
                        throw new RuntimeException("Invalid command: " + "s");
                    } else stack.pop();
                } else {
                    if (stack.isEmpty()) {
                        Directory newDirectory = new Directory(parts[2]);
                        directoriesMap.put(parts[2], newDirectory);
                        stack.push(newDirectory);
                    } else {
                        Directory parentDirectory = stack.peek();
                        String newFilePath;
                        if (parentDirectory.path.equals("/")) {
                            newFilePath = parentDirectory.path + parts[2];
                        } else {
                            newFilePath = parentDirectory.path + "/" + parts[2];
                        }
                        Directory newDirectory = new Directory(newFilePath);
                        directoriesMap.put(newFilePath, newDirectory);
                        parentDirectory.subDirectories.add(newDirectory);
                        stack.push(newDirectory);
                    }
                }
            } else if (!parts[0].equals("$")) {
                Directory currentDirectory = stack.peek();
                if (!parts[0].equals("dir")) {
                    String newFilePath;
                    if (currentDirectory.path.equals("/")) {
                        newFilePath = currentDirectory.path + parts[1];
                    } else {
                        newFilePath = currentDirectory.path + "/" + parts[1];
                    }
                    File newFile = new File(Long.parseLong(parts[0]), newFilePath);
                    currentDirectory.files.add(newFile);
                }
            }
        });
    }

    static class Directory {
        List<Directory> subDirectories;
        List<File> files;
        long size;
        String path;

        public Directory(String path) {
            this.size = -1;
            this.subDirectories = new ArrayList<>();
            this.files = new ArrayList<>();
            this.path = path;
        }
    }

    static class File {
        long size;
        String name;

        public File(long size, String name) {
            this.size = size;
            this.name = name;
        }
    }

    static class Part1 {
        public static void main(String[] args) throws IOException {
            buildDirectoryTree();
            getDirectorySize(directoriesMap.get("/"));
            System.out.println(part1Ans);
        }
    }

    static class Part2 {
        public static void main(String[] args) throws IOException {
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
}
