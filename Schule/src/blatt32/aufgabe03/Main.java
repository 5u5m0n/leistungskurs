package blatt32.aufgabe03;

import schgraphs.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        SchGraphs sg = new SchGraphs();
        graph.addEdge(0, 1, false);
        graph.addEdge(0, 2, false);
        graph.addEdge(1, 2, false);
        graph.addEdge(1, 3, false);
        graph.addEdge(2, 4, false);
        graph.addEdge(2, 3, false);
        graph.addEdge(3, 4, false);
        graph.addEdge(3, 3, false);
        sg.step(graph.getAdjazenzmatrix());
        graph.exportGraph("graph");
        graph.exportHTML("graph");
        sg.start();
    }
}
