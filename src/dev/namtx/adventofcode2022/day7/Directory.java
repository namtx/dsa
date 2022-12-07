package dev.namtx.adventofcode2022.day7;

import java.util.ArrayList;
import java.util.List;

class Directory {
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
