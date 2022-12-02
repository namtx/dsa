package dev.namtx.adventofcode2022.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class IterableFileReader implements Iterable<String> {
    private final BufferedReader reader;

    public IterableFileReader(String filePath) throws IOException {
        this.reader = new BufferedReader(new FileReader(filePath));
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                try {
                    return reader.ready();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public String next() {
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<String> spliterator() {
        return Iterable.super.spliterator();
    }
}
