package blatt30.aufgabe1;

public class AVLTree<T extends Comparable<T>> extends BinTree<T> {

    public int getBalance(Node<T> node) { return depth(node.getRight()) - depth(node.getLeft()); }

    public void left(Node<T> node) {
        Node<T> n = this.getRoot();
        Node<T> parent = null;

        while (n != null && n.getValue().compareTo(n.getValue()) != 0) {
            if (n.getValue().compareTo(n.getValue()) < 0) {
                parent = new Node<T>(n);
                n = n.getLeft();
            } else {
                parent = new Node<T>(n);
                n = n.getRight();
            }
        }

        Node<T> right = n.getRight();

        Node<T> rightChild = right.getLeft();

        if (parent.getLeft() == n) {
            parent.setLeft(right);
        } else if (parent.getRight() == n) {
            parent.setRight(right);
        }

        right.setLeft(n);

        n.setRight(rightChild);
    }

    public void right(Node<T> node) {
        Node<T> n = this.getRoot();
        Node<T> parent = null;

        while (n != null && n.getValue().compareTo(n.getValue()) != 0) {
            if (n.getValue().compareTo(n.getValue()) < 0) {
                parent = new Node<T>(n);
                n = n.getLeft();
            } else {
                parent = new Node<T>(n);
                n = n.getRight();
            }
        }

        Node<T> left = n.getLeft();

        Node<T> leftChild = left.getRight();

        if (parent.getLeft() == n) {
            parent.setLeft(left);
        } else if (parent.getRight() == n) {
            parent.setRight(left);
        }

        left.setLeft(n);

        n.setRight(leftChild);
    }

    public void balance() {
        int[] fall = new int[2];
        // 1 => R
        //-1 => L
        if (getBalance(getRoot()) >= 2) {
            fall[0] = 1;
            if (getBalance(getRoot().getRight()) >= 1) {
                fall[1] = 1;
            } else if (getBalance(getRoot().getRight()) <= -1) {
                fall[1] = -1;
            }
        } else if (getBalance(getRoot()) <= -2) {
            fall[0] = -1;
            if (getBalance(getRoot().getLeft()) >= 1) {
                fall[1] = 1;
            } else if (getBalance(getRoot().getLeft()) <= -1) {
                fall[1] = -1;
            }
        }

    }

}
