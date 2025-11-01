package Heaps;

import java.util.List;

public interface Heap {
    public void insert(int value);
    public int delete();
    public int getFirst();
    public boolean isEmpty();
    public int getSize();
    public int getElementAt(int index);

    List<Integer> getAllElements();
    public  void heapify(int index);
}
