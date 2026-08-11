package blatt32.aufgabe03;

import java.util.ArrayList;
import static blatt12.SelectionSort.selectionSort;

public class Graph {
    private int[][] adjazenzmatrix;

    public Graph(int n) {
        this.adjazenzmatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjazenzmatrix[i][j] = 0;
            }
        }
    }

    public Graph() {
        this.adjazenzmatrix = new int[0][0];
    }

    public void addVertex() {
        int n = this.adjazenzmatrix.length + 1;
        int[][] newMatrix = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                newMatrix[i][j] = this.adjazenzmatrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            newMatrix[n - 1][i] = 0;
            newMatrix[i][n - 1] = 0;
        }
        this.adjazenzmatrix = newMatrix;
    }

    public void addEdge(int from, int to, int weight, boolean isDirected) {
        if (from != to) {
            this.adjazenzmatrix[from][to] = weight;
            if (!isDirected) {
                this.adjazenzmatrix[to][from] = weight;
            }
        }
    }

    public void addEdge(int from, int to, int weight) {
        this.addEdge(from, to, weight, true);
    }

    public void addEdge(int from, int to) {
        this.addEdge(from, to, 1, true);
    }

    public void addEdge(int from, int to, boolean isDirected) {
        this.addEdge(from, to, 1, isDirected);
    }

    public int size() { return this.adjazenzmatrix.length; }

    public boolean isWeighted() {
        for (int[] j : this.adjazenzmatrix) {
            for (int i : j) {
                if (i != 0 || i != 1) return true;
            }
        }
        return false;
    }

    public boolean isDirected() {
        for (int i = 0; i < this.adjazenzmatrix.length; i++) {
            for (int j = 0; j < this.adjazenzmatrix[i].length; j++) {
                if (this.adjazenzmatrix[i][j] != this.adjazenzmatrix[j][i]) return true;
            }
        }
        return false;
    }

    public int[][] getAdjazenzmatrix() {
        for (int i = 0; i < this.adjazenzmatrix.length; i++) {
            for (int j = 0; j < this.adjazenzmatrix[i].length; j++) {

            }
        }
    }

    public int[] getNeighbours(int vertex) {
        int n = 0;
        for (int i : this.adjazenzmatrix[vertex]) {
            if (i != 0) n++;
        }
        int[] neighbours = new int[n];
        n = 0;
        for (int i : this.adjazenzmatrix[vertex]) {
            if (i != 0) {
                neighbours[n] = i;
                n++;
            }
        }
        selectionSort(neighbours, false);
        return neighbours;
    }
}
