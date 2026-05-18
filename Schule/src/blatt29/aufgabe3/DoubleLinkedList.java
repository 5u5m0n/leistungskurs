package blatt29.aufgabe3;

import blatt29.aufgabe2.LinkedList;
import blatt29.aufgabe2.Node;

public class DoubleLinkedList<T> extends LinkedList<T> {
    Node<T> tail;

    public DoubleLinkedList() {
        super();
        this.tail = null;
    }

    public DoubleLinkedList(Node<T> head) {
        super(head);
        this.tail = this.Tail();
    }

    private Node<T> Tail() {
        Node<T> n = this.getHead();
        while (n.next() != null) {
            n = n.next();
        }
        return n;
    }

    public Node<T> getTail() {
        return tail;
    }

    @Override
    public void add(T value) {
        super.add(value);
        this.tail = this.Tail();
    }

    @Override
    public void add(T value, int index) {
        super.add(value, index);
        this.tail = this.Tail();
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        super.remove(index);
        this.tail = this.Tail();
    }

    @Override
    public void clear() {
        super.clear();
        this.tail = null;
    }
}
