package dev.namtx.ds;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap {
    List<Integer> heap;

    public BinaryHeap() {
        this.heap = new ArrayList<>();
    }

    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap();
        binaryHeap.insert(1);
        binaryHeap.insert(2);
        binaryHeap.insert(3);
        binaryHeap.insert(0);
        binaryHeap.insert(4);
        System.out.println(binaryHeap.poll());
        System.out.println(binaryHeap.poll());
        binaryHeap.remove(2);
    }

    public void insert(int n) {
        heap.add(n);
        int i = heap.size() - 1;
        while (i > 0 && heap.get(i) < heap.get(parent(i))) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int poll() {
        int result = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapify(0);
        return result;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void heapify(int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;
        if (left < heap.size() && heap.get(left) < heap.get(largest)) {
            largest = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(largest)) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    private void remove(int n) {
        int i = 0;
        while (i < heap.size()) {
            if (heap.get(i) == n) {
                heap.set(i, heap.get(heap.size() - 1));
                heap.remove(heap.size() - 1);
                heapify(i);
                return;
            }
            i++;
        }
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }
}
