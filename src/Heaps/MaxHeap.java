package Heaps;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap implements Heap {
    List<Integer> heap;

    public MaxHeap(int size) {
        heap = new ArrayList<>(size);
    }

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    @Override
    public void insert(int value) {
        heap.add(value);
        int parentIndex = (heap.size() - 2) / 2;
        int currentIndex = heap.size() - 1;
        while (parentIndex >= 0 && heap.get(parentIndex) < heap.get(currentIndex)) {
            //swap
            swap(parentIndex, currentIndex);
            currentIndex = parentIndex;
            parentIndex = (parentIndex-1) / 2;
        }


    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    @Override
    public int delete() {

        if (heap.isEmpty()) {
            return -1;
        }
        int removedValue = heap.getFirst();
        if (heap.size() == 1) {
            return heap.removeFirst();
        }
        heap.set(0, heap.removeLast());
        heapify(0);
        return removedValue;
    }

    @Override
    public int getFirst() {
        return heap.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int getElementAt(int index) {
        return 0;
    }

    @Override
    public List<Integer> getAllElements() {
        return heap;
    }

    @Override
    public void heapify(int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }
        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }
        if (largest != index) {
            swap(largest,index);
            heapify(largest);
        }

    }
}
