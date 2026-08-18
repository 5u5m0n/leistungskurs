package blatt33.aufgabe01;

import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        return stack.removeLast();
    }

    public ArrayList<T> getStack() {
        return stack;
    }

    public T peek() {
        return stack.getLast();
    }
}
