package blatt30.aufgabe01;

public class BinTree<T extends Comparable<T>> {
    private Node<T> root;

    //< und >=

    public BinTree(T n) {
        this.root = new Node<>(n);
    }

    public BinTree(Node<T> root) {
        this.root = root;
    }

    public BinTree() {
        this.root = null;
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public Node<T> find(T value) {
        Node<T> node = this.root;
        while (node != null && node.getValue().compareTo(value) != 0) {
            if (node.getValue().compareTo(value) < 0) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return node;
    }

    public void add(T value) {
        Node<T> node = this.root;
        Node<T> t = new Node<>(value);
        while (true) {
            if (t.getValue().compareTo(node.getValue()) == 0) {
                return;
            }
            if (node.getValue().compareTo(value) < 0) { // left
                if (node.getLeft() == null) {
                    node.setLeft(t);
                    return;
                } else {
                    node = node.getLeft();
                }
            } else if (node.getValue().compareTo(value) >= 0) { // right
                if (node.getRight() == null) {
                    node.setRight(t);
                    return;
                } else {
                    node = node.getRight();
                }
            }
        }
    }

    public void add(Node<T> t) {
        Node<T> node = this.root;
        while (true) {
            if (t.getValue().compareTo(node.getValue()) == 0) {
                return;
            }
            if (node.getValue().compareTo(t.getValue()) < 0) { // left
                if (node.getLeft() == null) {
                    node.setLeft(t);
                    return;
                } else {
                    node = node.getLeft();
                }
            } else if (node.getValue().compareTo(t.getValue()) >= 0) { // right
                if (node.getRight() == null) {
                    node.setRight(t);
                    return;
                } else {
                    node = node.getRight();
                }
            }
        }
    }

    public int depth(Node<T> node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        } else if (node.getLeft() != null && node.getRight() != null) {
            return Math.max(depth(node.getLeft()), depth(node.getRight())) + 1;
        } else if (node.getLeft() != null) {
            return depth(node.getLeft()) + 1;
        } else if (node.getRight() != null) {
            return depth(node.getRight()) + 1;
        }
        return 1;
    }

    public int count(Node<T> node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        } else if (node.getLeft() != null && node.getRight() != null) {
            return count(node.getLeft()) + count(node.getRight()) + 1;
        } else if (node.getLeft() != null) {
            return count(node.getLeft()) + 1;
        } else if (node.getRight() != null) {
            return count(node.getRight()) + 1;
        }
        return 1;
    }

    public Node<T> remove(T value) {
        Node<T> n = this.root;
        Node<T> parent = null;

        while (n != null && n.getValue().compareTo(value) != 0) {
            if (n.getValue().compareTo(value) < 0) {
                parent = new Node<T>(n);
                n = n.getLeft();
            } else {
                parent = new Node<T>(n);
                n = n.getRight();
            }
        }

        if (n.getLeft() != null && n.getRight() != null) { //Zwei Kinder
            Node<T> ION = n.findInOrderNeighbour()[1];
            this.remove(ION.getValue());

            ION.setLeft(n.getLeft());
            ION.setRight(n.getRight());

            if (parent.getLeft() == n) {
                parent.setLeft(ION);
            } else if (parent.getRight() == n) {
                parent.setRight(ION);
            }

            return n;
        } else {
            Node<T> temp = null;

            if (n.getLeft() != null) {
                temp = n.getLeft();
            } else if (n.getRight() != null) {
                temp = n.getRight();
            }

            if (parent.getLeft() == n) {
                parent.setLeft(temp);
            } else if (parent.getRight() == n) {
                parent.setRight(temp);
            }
            return n;
        }
    }
}
