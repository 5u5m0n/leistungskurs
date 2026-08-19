package blatt33.aufgabe06;

public class EdgeVector implements Comparable<EdgeVector> {
    public int from;
    public int to;
    public int weight;

    public EdgeVector(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(EdgeVector o) {
        if (weight == o.weight) {
            return 0;
        }
        return weight > o.weight ? 1 : -1;
    }
}
