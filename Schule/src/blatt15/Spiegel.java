package blatt15;

import schisch_visualizer.SchischVisualizer;

import static blatt13.Zufall.*;
import static blatt14.MultiArrays.*;
import static blatt14.Simulationen.*;

public class Spiegel {

    public static void zufallSpiegel(char[][] spiegel, double p) {
        for (int i = 1; i < spiegel.length - 1; i++) {
            for (int j = 1; j < spiegel[i].length - 1; j++) {
                if (zufall(1) <= p && getNorden(spiegel, i, j, false) != '/' && getNorden(spiegel, i, j, false) != '\\' && getSueden(spiegel, i, j, false) != '/' && getSueden(spiegel, i, j, false) != '\\' && getWesten(spiegel, i, j, false) != '/' && getWesten(spiegel, i, j, false) != '\\' && getOsten(spiegel, i, j, false) != '/' && getOsten(spiegel, i, j, false) != '\\') {
                    if (zufall(1) > 0.5) {
                        spiegel[i][j] = '/';
                    } else {
                        spiegel[i][j] = '\\';
                    }
                }
            }
        }
    }

    public static void zufallZiele(char[][] spiegel, double p) {
        for (int i = 1; i < spiegel.length - 1; i++) {
            for (int j = 1; j < spiegel[i].length - 1; j++) {
                if (zufall(1) <= p && getNorden(spiegel, i, j, false) != 'O' && getSueden(spiegel, i, j, false) != 'O' && getWesten(spiegel, i, j, false) != 'O' && getOsten(spiegel, i, j, false) != 'O' && spiegel[i][j] == ' ') {
                    spiegel[i][j] = 'O';
                }
            }
        }
    }

    public static void generierePfeil(char[][] spiegel) {
        spiegel[0][spiegel.length / 2] = '>';
    }

    public static char getDirection(char[][] spiegel, int dir, int i, int j) {
        switch (dir) {
            case 1:
                return getSueden(spiegel, i, j, false);
            case 2:
                System.out.println("OSTEN");
                return getOsten(spiegel, i, j, false);
            case -1:
                return getWesten(spiegel, i, j, false);
            case -2:
                return getNorden(spiegel, i, j, false);
        }
        return '0';
    }

    public static char[][] bewegePfeile(char[][] spiegel) {
        /*
                1
            2   /   -1   == Wenn dir = 1 || dir = -2 : - (-1); Else : + (-1)
               -2
 /
                1
            2   \   -1   == * (-1)
               -2
         */
        int dir = 0;
        char[][] spiegelKopie = copy2DCharArray(spiegel);
        for (int i = 0; i < spiegel.length; i++) {
            for (int j = 0; j < spiegel[i].length; j++) {
                dir = 0;
                if (spiegel[i][j] == '>') {
                    dir = 2;
                } else if (spiegel[i][j] == '<') {
                    dir = -1;
                } else if (spiegel[i][j] == '^') {
                    dir = -2;
                } else if (spiegel[i][j] == 'V') {
                    dir = 1;
                }
                if (dir != 0) {
                    char feld = getDirection(spiegel, dir, i, j);
                    int[] mx = new int[]{0, -1, 0, 0, 1};
                    int[] my = new int[]{1, 0, 0, -1, 0};
                    char[] zeichen = new char[]{'^', '<', '0', 'V', '>'};
                    if (i + mx[dir + 2] < spiegel.length && j + my[dir + 2] < spiegel[i].length && i + mx[dir + 2] > 0 && j + my[dir + 2] > 0) {
                        if (feld == ' ') {
                            spiegelKopie[i + mx[dir + 2]][j + my[dir + 2]] = spiegel[i][j];
                            spiegelKopie[i][j] = ' ';
                        } else if (feld == 'O') {
                            spiegelKopie[i + mx[dir + 2]][j + my[dir + 2]] = ' ';
                            spiegelKopie[i][j] = ' ';

                        } else if (feld == '/') {
                            spiegelKopie[i][j] = ' ';
                            int x = i + mx[dir + 2];
                            int y = j + my[dir + 2];
                            if (dir == 1 || dir == -2) {
                                dir++;
                            } else {
                                dir--;
                            }
                            spiegelKopie[x + mx[dir + 2]][y + my[dir + 2]] = zeichen[dir + 2];
                        } else if (feld == '\\') {
                            spiegelKopie[i][j] = ' ';
                            int x = i + mx[dir + 2];
                            int y = j + my[dir + 2];
                            dir *= -1;
                            spiegelKopie[x + mx[dir + 2]][y + my[dir + 2]] = zeichen[dir + 2];
                        } else {
                            spiegelKopie[i + mx[dir + 2]][j + my[dir + 2]] = ' ';
                            spiegelKopie[i][j] = ' ';
                        }
                    }
                }
            }
        }
        spiegel = copy2DCharArray(spiegelKopie);
        return spiegel;
    }

    public static void spiegelSimulation(int n, double q, int abs) {
        char[][] spiegel = createEmpty2DCharArray(40, 40);
        SchischVisualizer sv = new SchischVisualizer();
        zufallSpiegel(spiegel, 0.3);
        sv.step(spiegel);
        zufallZiele(spiegel, 0.1);
        sv.step(spiegel);
        for (int i = 0; i < n; i++) {
            spiegel = bewegePfeile(spiegel);
            if (i % abs == 0) {
                generierePfeil(spiegel);
            }
            sv.step(spiegel);
        }
        sv.start();
    }

    public static void main(String[] args) {
        spiegelSimulation(100, 0.5, 4 );
    }

}
