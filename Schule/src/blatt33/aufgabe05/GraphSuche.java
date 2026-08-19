package blatt33.aufgabe05;

import blatt32.aufgabe03.Graph;
import blatt33.aufgabe01.Queue;
import blatt33.aufgabe01.Stack;
import blatt33.aufgabe06.EdgeVector;
import schgraphs.SchGraphs;

import java.io.File;

import static blatt07.ArbeitMitArrays.printArray;

public class GraphSuche {

    public static boolean isPath(Graph g, EdgeVector e) {
        return g.getAdjazenzmatrix()[e.from][e.to] != 0;
    }

    public static int pathLength(Graph g, EdgeVector e) {
        return g.getAdjazenzmatrix()[e.from][e.to];
    }

    public static boolean zyklensuche(Graph g, int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[g.getAdjazenzmatrix().length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        stack.push(start);
        visited[start] = true;
        while (!stack.getStack().isEmpty()) {
            int u = stack.pop();
            for (int v : g.getNeighbours(u)) {
                if (visited[v]) {
                     return true;
                } else {
                     stack.push(v);
                     visited[v] = true;
                }
            }
        }
        return false;
    }

    public static boolean zyklensucheVisuell(Graph g, int start, SchGraphs sg) {
        Stack<Integer> stack = new Stack<>();
        sg.step(g.getAdjazenzmatrix());
        sg.colorNode(start, 'g');
        sg.step();
        boolean[] visited = new boolean[g.getAdjazenzmatrix().length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        stack.push(start);
        visited[start] = true;
        while (!stack.getStack().isEmpty()) {
            int u = stack.pop();
            for (int v : g.getNeighbours(u)) {
                if (visited[v]) {
                    sg.colorEdge(u, v, 'g', false);
                    sg.colorNode(v, 'g');
                    sg.step();
                    return true;
                } else {
                    stack.push(v);
                    visited[v] = true;
                    sg.colorEdge(u, v, 'g', false);
                    sg.colorNode(v, 'g');
                    sg.step();
                }
            }
        }
        return false;
    }

    public static boolean[] erreichbarkeit(Graph g, int start) {
        boolean[] visited = new boolean[g.getAdjazenzmatrix().length];
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        queue.add(start);

        while (!queue.getQueue().isEmpty()) {
            int u = queue.pop();
            for (int v : g.getNeighbours(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        return visited;
    }

    public static boolean erreichbarkeit(Graph g, int from, int to) {
        return erreichbarkeit(g, from)[to];
    }

    public static void main(String[] args) {
        SchGraphs sg = new SchGraphs();
        Graph g = new Graph();
        File file = new File("/home/simon/IdeaProjects/leistungskurs/Schule/export/graph04.txt");
        g.importGraph(file);
        g.addEdge(3, 1, true);
        g.addEdge(3, 11, true);
        g.addEdge(1, 3, 0, true);
        g.addEdge(11, 3, 0, true);

        sg.step(g.getAdjazenzmatrix());
        System.out.println(erreichbarkeit(g, 0, 3));
        sg.start();
    }


}
