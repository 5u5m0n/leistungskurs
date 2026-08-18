package blatt33;

import blatt32.aufgabe03.Graph;
import schgraphs.SchGraphs;

public class aufgabe04 {

    public static Graph graph1() {
        Graph g = new Graph();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addEdge(0, 1, false);
        g.addEdge(0, 2, false);
        g.addEdge(1, 2, false);
        g.addEdge(1, 3, false);
        g.addEdge(2, 3, false);
        g.addEdge(2, 4, false);
        g.addEdge(3, 4, false);
        g.addEdge(3, 0, false);
        g.addEdge(4, 0, false);
        g.addEdge(4, 1, false);
        return g;
    }

    public static Graph graph2() {
        Graph g = new Graph();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addEdge(0, 1, true);
        g.addEdge(2, 3, true);
        return g;
    }

    public static Graph graph3() {
        Graph g = new Graph();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addEdge(0, 1, 2, false);
        g.addEdge(1, 2, 3, false);
        g.addEdge(2, 3, 1, false);
        g.addEdge(3, 0, 5, false);
        g.addEdge(3, 1, 4675, false);
        return g;
    }

    public static Graph graph4() {
        Graph g = new Graph();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addEdge(0, 1, 1, true);
        g.addEdge(0, 2, 2, true);
        g.addEdge(1, 0, 3, true);
        g.addEdge(1, 2, 4, true);
        g.addEdge(2, 0, 5, true);
        g.addEdge(2, 1, 6, true);
        return g;
    }

    public static void main(String[] args) {
        SchGraphs sg = new SchGraphs();
        sg.step(graph4().getAdjazenzmatrix());
        sg.start();
    }
}
