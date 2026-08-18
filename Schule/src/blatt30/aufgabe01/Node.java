package blatt30.aufgabe01;

public class Node<T extends Comparable<T>> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node(Node<T> node) {
        this.value = node.getValue();
        this.left = node.getLeft();
        this.right = node.getRight();
    }

    public T getValue() {
        return this.value;
    }

    public Node<T> getLeft() {
        return this.left;
    }

    public Node<T> getRight() {
        return this.right;
    }

    public void setValue(T value) {
        this.value = value;
    }
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T>[] findInOrderNeighbour() {
        Node<T>[] result = new Node[2];
        result[0] = this.left;
        result[1] = this.right;
        while (result[0].getRight() != null || result[1].getLeft() != null) {
            if (result[1].getLeft() != null) {
                result[1] = result[1].getLeft();
            }
            if (result[0].getRight() != null) {
                result[0] = result[0].getRight();
            }
        }
        return result;
    }
}
