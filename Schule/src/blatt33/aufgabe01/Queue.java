package blatt33.aufgabe01;

import java.util.ArrayList;

public class Queue<T> {
    private ArrayList<T> queue;

    public Queue() {
        queue = new ArrayList<>();
    }

    public void add(T t) {
        queue.add(t);
    }

    public T pop() {
        return queue.removeFirst();
    }

    public ArrayList<T> getQueue() {
        return queue;
    }

    public T peek() {
        return queue.getFirst();
    }
}
