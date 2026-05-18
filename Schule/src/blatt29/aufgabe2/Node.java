package blatt29.aufgabe2;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> next() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void printNode() {
        System.out.println(this.value);
    }
}
