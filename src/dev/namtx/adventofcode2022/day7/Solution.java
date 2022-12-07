package dev.namtx.adventofcode2022.day7;

import dev.namtx.adventofcode2022.utils.IterableFileReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public abstract class Solution {
    private static final String FILE_PATH = "./src/dev/namtx/adventofcode2022/day7/input.txt";
    final Map<String, Directory> directoriesMap = new HashMap<>();

    public abstract void solve() throws IOException;

    long getDirectorySize(Directory directory) {
        if (directory.size != -1) return directory.size;
        long ans = 0;
        for (File file : directory.files) {
            ans += file.size;
        }
        for (Directory sub : directory.subDirectories) {
            ans += getDirectorySize(sub);
        }
        directory.size = ans;
        return ans;
    }

    public void buildDirectoryTree() throws IOException {
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
}
