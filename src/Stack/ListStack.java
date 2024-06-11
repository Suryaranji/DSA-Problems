package Stack;

import java.util.Iterator;
import java.util.LinkedList;

public class ListStack<T> implements stack<T>,Iterable<T>{

    public LinkedList<T> stack=new LinkedList<>();

    @Override
    public  void push(T element) {
          stack.add(element);
    }

    @Override
    public T pop() {
        return stack.removeLast();
    }

    @Override
    public T peek() {
        return stack.peek();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public Iterator<T> iterator() {
        return stack.iterator();
    }
}
