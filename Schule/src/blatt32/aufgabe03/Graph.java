package blatt32.aufgabe03;

import java.io.*;
import java.util.ArrayList;

import static blatt11.BubbleSort.bubbleSort;

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
        if (from >= adjazenzmatrix.length || to >= adjazenzmatrix.length || to < 0 || from < 0) {
            throw new RuntimeException();
        }
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
                if (i != 0 && i != 1) return true;
            }
        }
        return false;
    }

    public boolean isDirected() {
        for (int i = 0; i < this.adjazenzmatrix.length; i++) {
            for (int j = i + 1; j < this.adjazenzmatrix[i].length; j++) {
                if (this.adjazenzmatrix[i][j] != this.adjazenzmatrix[j][i]) return true;
            }
        }
        return false;
    }

    public int[][] getAdjazenzmatrix() {
        int[][] ret = new int[this.adjazenzmatrix.length][this.adjazenzmatrix[0].length];
        for (int i = 0; i < this.adjazenzmatrix.length; i++) {
            for (int j = 0; j < this.adjazenzmatrix[i].length; j++) {
                ret[i][j] = this.adjazenzmatrix[i][j];
            }
        }
        return ret;
    }

    public int[] getNeighbours(int vertex) {
        if (vertex < 0 || vertex >= this.adjazenzmatrix.length) throw new IllegalArgumentException();
        int n = 0;
        for (int i : this.adjazenzmatrix[vertex]) {
            if (i != 0) n++;
        }
        int[] neighbours = new int[n];
        n = 0;
        for (int i = 0; i < this.adjazenzmatrix[vertex].length; i++) {
            if (adjazenzmatrix[vertex][i] != 0) {
                neighbours[n] = i;
                n++;
            }
        }
        bubbleSort(neighbours);
        return neighbours;
    }

    public void exportHTML(String filename) {
        try {
            File htmlFile = new File("/home/simon/IdeaProjects/leistungskurs/Schule/export/" + filename + ".html");
            FileWriter fw = new FileWriter(htmlFile);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("<!DOCTYPE html>");
            bw.newLine();
            bw.write("<html>");
            bw.newLine();
            bw.write("<head>");
            bw.newLine();
            bw.write("<title>" + filename + " Adjazenzmatrix</title>");
            bw.newLine();
            bw.write("</head>");
            bw.newLine();
            bw.write("<body>");
            bw.newLine();
            bw.write("<table>");
            bw.newLine();
            for (int i = 0; i < this.adjazenzmatrix.length; i++) {
                bw.write("<tr>");
                bw.newLine();
                for (int j = 0; j < this.adjazenzmatrix[i].length; j++) {
                    bw.write("<th>" + this.adjazenzmatrix[i][j] + "</th>");
                    bw.newLine();
                }
                bw.write("</tr>");
                bw.newLine();
            }
            bw.write("</table>");
            bw.newLine();
            bw.write("</body>");
            bw.newLine();
            bw.write("</html>");
            bw.close();
            fw.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exportGraph(String filename) {
        try {
            File file = new File("/home/simon/IdeaProjects/leistungskurs/Schule/export/" + filename + ".txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(""+this.adjazenzmatrix.length);
            bw.newLine();
            for (int i = 0; i < this.adjazenzmatrix.length; i++) {
                for (int j = 0; j < this.adjazenzmatrix[i].length; j++) {
                    bw.write(""+this.adjazenzmatrix[i][j]);
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void importGraph(File file) {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            int n = Integer.parseInt(br.readLine());
            int[][] graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(br.readLine());
                }
            }
            this.adjazenzmatrix = graph;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
