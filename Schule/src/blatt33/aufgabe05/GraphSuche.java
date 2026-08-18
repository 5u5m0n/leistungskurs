package blatt33.aufgabe05;

import blatt32.aufgabe03.Graph;
import blatt33.aufgabe01.Stack;
import blatt33.aufgabe06.EdgeVector;

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


}
