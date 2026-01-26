package blatt15;

import schisch_visualizer.SchischVisualizer;

import static blatt14.MultiArrays.*;
import static blatt13.Zufall.*;
import static blatt14.Simulationen.*;

public class KomplexerKaese {

    static SchischVisualizer sv = new SchischVisualizer();
    static char[][][] kaese;
    static char[][][] kaeseB;
    static boolean change = true;
    static boolean undicht = false;

    public static void initialisiereKaese(double p) {
        int l = 80;
        kaese = new char[l][l][l];
        if (p >= 0 && p <= 1) {
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    for (int k = 0; k < l; k++) {
                        if (zufall(1) <= p) {
                            kaese[i][j][k] = '5';
                        } else {
                            kaese[i][j][k] = ' ';
                        }
                    }

                }
            }
        }
        sv.step(kaese[0]);
    }

    public static void initialisiereWasser() {
        for (int i = 0; i < kaese.length; i++) {
            for (int j = 0; j < kaese[i].length; j++) {
                if (kaese[0][i][j] == ' ') {
                    kaese[0][i][j] = '2';
                }
            }
        }
        sv.step(kaese[0]);
    }

    public static char yPlus(int x, int y, int z) {
        int ys = y - 1;
        if (ys < 0) {
            return '-';
        }
        return kaese[x][ys][z];
    }

    public static char yMinus(int x, int y, int z) {
        int ys = y + 1;
        if (ys > kaese[x].length - 1) {
            return '-';
        }
        return kaese[x][ys][z];
    }

    public static char xMinus(int x, int y, int z) {
        int xs = x - 1;
        if (xs < 0) {
            return '-';
        }
        return kaese[xs][y][z];
    }

    public static char xPlus(int x, int y, int z) {
        int xs = x + 1;
        if (xs > kaese.length - 1) {
            return '-';
        }
        return kaese[xs][y][z];
    }

    public static char zPlus(int x, int y, int z) {
        int zs = z + 1;
        if (zs > kaese[x][y].length - 1) {
            return '-';
        }
        return kaese[x][y][zs];
    }

    public static char zMinus(int x, int y, int z) {
        int zs = z - 1;
        if (zs < 0) {
            return '-';
        }
        return kaese[x][y][zs];
    }

    public static void gravitation() {
        kaeseB = new char[kaese.length][kaese[0].length][kaese[0][0].length];
        for (int i = 0; i < kaese.length; i++) {
            for (int j = 0; j < kaese[i].length; j++) {
                for (int k = 0; k < kaese[i][j].length; k++) {
                    if (kaese[i][j][k] == '2') {
                        if (xPlus(i, j, k) == ' ' && i + 1 < kaese.length) {
                            kaeseB[i + 1][j][k] = '2';
                        }
                        if (xMinus(i, j, k) == ' ' && i - 1 > 0) {
                            kaeseB[i - 1][j][k] = '2';
                        }
                        if (yPlus(i, j, k) == ' ' && j + 1 < kaese[i].length) {
                            kaeseB[i][j + 1][k] = '2';
                        }
                        if (yMinus(i, j, k) == ' ' && j - 1 > 0) {
                            kaeseB[i][j - 1][k] = '2';
                        }
                        if (zPlus(i, j, k) == ' ' && k + 1 < kaese[i][j].length) {
                            kaeseB[i][j][k + 1] = '2';
                        }
                        if (zMinus(i, j, k) == ' ' && k - 1 > 0) {
                            kaeseB[i][j][k - 1] = '2';
                        }
                    }
                }
            }
        }
        for (int i = 0; i < kaese.length; i++) {
            for (int j = 0; j < kaese[i].length; j++) {
                for (int k = 0; k < kaese[i][j].length; k++) {
                    if (kaeseB[i][j][k] == '2') {
                        if (kaese[i][j][k] != '2') {
                            kaese[i][j][k] = '2';
                            change = true;
                        }
                    }
                }
            }
        }

    }

    public static void simulation(double p) {
        initialisiereKaese(p);
        initialisiereWasser();
        while (change) {
            change = false;
            gravitation();
        }
        for (int i = 0; i < kaese.length; i++) {
            for (int j = 0; j < kaese[i].length; j++) {
                for (int k = 0; k < kaese[i][j].length; k++) {
                    if (kaese[kaese.length - 1][i][j] == '2') {
                        undicht = true;
                    }
                }
            }
        }
        System.out.println(undicht);
        sv.step(kaese[kaese.length - 1]);
    }

    public static void main(String[] args) {
        simulation(0.6);
        sv.start();
    }
}
