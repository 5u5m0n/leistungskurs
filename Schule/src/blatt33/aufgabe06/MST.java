package blatt33.aufgabe06;

import blatt32.aufgabe03.Graph;

import java.util.ArrayList;

public class MST {

    public static Graph primMst(Graph g) {
        Graph primMst = new Graph(g.size());
        boolean directed = g.isDirected();
        int[][] adjmat = g.getAdjazenzmatrix();
        Vertex[] v = new Vertex[g.size()];
        for (int i = 0; i < v.length; i++) {
            v[i] = new Vertex(i);
        }

        v[0].visited = true;
        boolean terminate = false;
        while (!terminate) {
            //find Possible Edges
            ArrayList<EdgeVector> possEdges = new ArrayList<>();
            for (Vertex ver : v) {
                if (ver.visited) {
                    for (int i : g.getNeighbours(ver.get())) {
                        if (!v[i].visited) {
                            possEdges.add(new EdgeVector(ver.get(), i, adjmat[ver.get()][i]));
                        }
                    }
                }
            }

            //find min edge
            EdgeVector min = possEdges.get(0);
            for (EdgeVector e : possEdges) {
                if (e.weight < min.weight) {
                    min = e;
                }
            }

            //add Edge
            primMst.addEdge(min.from, min.to, min.weight, directed);
            v[min.to].visited = true;

            //terminate
            terminate = true;
            for (Vertex ver : v) {
                if (!ver.visited) {
                    terminate = false;
                }
            }
        }
        return primMst;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addEdge(0, 8, 5, false);
        g.addEdge(0, 7, 2, false);
        g.addEdge(1, 10, 4, false);
        g.addEdge(1, 3, 2, false);
        g.addEdge(2, 5, 2, false);
        g.addEdge(2, 9, 1, false);
        g.addEdge(3, 11, 1, false);
        g.addEdge(4, 8, 2, false);
        g.exportGraph("Graph4");
    }
}
