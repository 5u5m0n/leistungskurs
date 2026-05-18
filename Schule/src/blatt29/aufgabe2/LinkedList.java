package blatt29.aufgabe2;

public class LinkedList<T> {
    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public void printList() {
        Node<T> n = this.head;
        while (n != null) {
            System.out.println("[ " + n.getValue() + " ]");
            n = n.next();
        }
    }

    public int size() {
        int i = 0;
        Node<T> n = this.head;
        while (n != null) {
            i++;
            n = n.next();
        }
        return i;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        Node<T> n = this.head;
        for (int i = 0; i < index; i++) {
            if (n == null) {
                throw new IndexOutOfBoundsException();
            }
            n = n.next();
        }
        return n.getValue();
    }

    public boolean contains(T value) {
        Node<T> n = this.head;
        while (n != null) {
            if (n.getValue().equals(value)) {
                return true;
            }
            n = n.next();
        }
        return false;
    }

    public void add(T value) {
        Node<T> n = this.head;
        while (n.next() != null) {
            n = n.next();
        }
        Node<T> add = new Node<T>(value);
        n.setNext(add);
    }

    public void add(T value, int index) {
        Node<T> n = this.head;
        for (int i = 0; i < index; i++) {
            n = n.next();
        }
        Node<T> next = n.next();
        Node<T> add = new Node<T>(value);
        n.setNext(add);
        add.setNext(next);
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        Node<T> n = this.head;
        if (this.size() <= index) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < index - 1; i++) {
            n = n.next();
        }
        n.setNext(n.next().next());
    }

    public void clear() {
        this.head = null;
    }

}
