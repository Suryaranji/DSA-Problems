package Heaps;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a MinHeap data structure.
 * A MinHeap is a binary heap where the parent node is always smaller than its child nodes.
 */
public class MinHeap implements Heap {
    // List to store the heap elements
    List<Integer> heap;

    /**
     * Constructor to initialize the MinHeap with a specific size.
     *
     * @param size Initial capacity of the heap.
     */
    public MinHeap(int size) {
        heap = new ArrayList<>(size);
    }

    /**
     * Default constructor to initialize the MinHeap with default capacity.
     */
    public MinHeap() {
        heap = new ArrayList<>();
    }

    /**
     * Inserts a value into the MinHeap and maintains the heap property.
     *
     * @param value The value to be inserted into the heap.
     */
    public void insert(int value) {
        heap.add(value);
        int parentIndex = (heap.size() - 2) / 2;
        int currentIndex = heap.size() - 1;

        // Bubble up the inserted value to maintain the heap property
        while (parentIndex >= 0 && heap.get(parentIndex) > heap.get(currentIndex)) {
            // Swap the parent and current node
            int temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(currentIndex));
            heap.set(currentIndex, temp);

            // Update indices
            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1) / 2;
        }
    }

    /**
     * Deletes the root element (minimum value) from the MinHeap and maintains the heap property.
     *
     * @return The removed value, or -1 if the heap is empty.
     */
    @Override
    public int delete() {
        if (heap.isEmpty()) {
            return -1;
        }
        if (heap.size() == 1) {
            return heap.remove(0); // Fix: Use remove(0) instead of removeFirst()
        }

        int removedValue = heap.get(0); // Fix: Use get(0) instead of getFirst()
        heap.set(0, heap.remove(heap.size() - 1)); // Fix: Use remove(size-1) instead of removeLast()
        heapify(0); // Restore the heap property
        return removedValue;
    }

    /**
     * Retrieves the root element (minimum value) of the MinHeap without removing it.
     *
     * @return The root element, or -1 if the heap is empty.
     */
    @Override
    public int getFirst() {
        return !heap.isEmpty() ? heap.get(0) : -1; // Fix: Use get(0) instead of getFirst()
    }

    /**
     * Checks if the MinHeap is empty.
     *
     * @return True if the heap is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return heap.isEmpty(); // Fix: Return the correct condition
    }

    /**
     * Retrieves the size of the MinHeap.
     *
     * @return The number of elements in the heap.
     */
    @Override
    public int getSize() {
        return heap.size(); // Fix: Return the correct size
    }

    /**
     * Retrieves the element at a specific index in the MinHeap.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     */
    @Override
    public int getElementAt(int index) {
        return heap.get(index); // Fix: Return the correct element
    }

    /**
     * Retrieves all elements in the MinHeap as a list.
     *
     * @return A list containing all elements in the heap.
     */
    @Override
    public List<Integer> getAllElements() {
        return heap;
    }

    /**
     * Restores the heap property by "heapifying" the subtree rooted at the given index.
     *
     * @param currentIndex The index of the root of the subtree to heapify.
     */
    @Override
    public void heapify(int currentIndex) {
        int leftChildIndex = 2 * currentIndex + 1;
        int rightChildIndex = 2 * currentIndex + 2;
        int temp = currentIndex;

        // Find the smallest among the current node and its children
        if (leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(temp)) {
            temp = leftChildIndex;
        }
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(temp)) {
            temp = rightChildIndex;
        }

        // Swap and continue heapifying if the current node is not the smallest
        if (temp == currentIndex) {
            return;
        }
        int swap = heap.get(currentIndex);
        heap.set(currentIndex, heap.get(temp));
        heap.set(temp, swap);
        heapify(temp);
    }

    /**
     * Swaps two elements in the heap at the specified indices.
     *
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
