package blatt33.aufgabe06;

import blatt32.aufgabe03.Graph;
import blatt33.aufgabe01.Queue;
import schgraphs.SchGraphs;

import java.io.File;
import java.util.ArrayList;

import static blatt33.aufgabe05.GraphSuche.erreichbarkeit;

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

    public static Graph kruskalMst(Graph g) {
        Graph kruskalMst = new Graph(g.size());
        boolean directed = g.isDirected();
        int[][] adjmat = g.getAdjazenzmatrix();
        ArrayList<EdgeVector> edges = new ArrayList<>();
        for (int i = 0; i < g.size(); i++) {
            for (int j = 0; j < adjmat[i].length; j++) {
                if (adjmat[i][j] != 0) edges.add(new EdgeVector(i, j, adjmat[i][j]));
            }
        }
        edges.sort((e1, e2) -> e1.weight - e2.weight);

        for (int k = 0; k < edges.size(); k++) {
            if (!erreichbarkeit(kruskalMst, edges.get(k).from, edges.get(k).to)) {
                kruskalMst.addEdge(edges.get(k).from, edges.get(k).to, edges.get(k).weight, directed);
                System.out.println("a");
            } else System.out.println("b");
        }
        return kruskalMst;
    }

    public static void main(String[] args) {
        SchGraphs sg = new SchGraphs();
        Graph g = new Graph();
        File file = new File("/home/simon/IdeaProjects/leistungskurs/Schule/export/graph04.txt");
        g.importGraph(file);
        sg.step(g.getAdjazenzmatrix());
        sg.step(kruskalMst(g).getAdjazenzmatrix());
        sg.start();
    }
}
