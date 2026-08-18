package blatt33.aufgabe06;

public class Vertex {
    private int n;
    public boolean visited;

    public Vertex(int n) {
        this.n = n;
        this.visited = false;
    }

    public int get() {
        return n;
    }
}
