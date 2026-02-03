package blatt15;

import schisch_visualizer.SchischVisualizer;

import static blatt13.Zufall.*;
import static blatt14.MultiArrays.*;
import static blatt14.Simulationen.*;

public class Spiegel {

    public static void zufallSpiegel(char[][] spiegel, double p, boolean schwer) {
        for (int i = 1; i < spiegel.length - 1; i++) {
            for (int j = 1; j < spiegel[i].length - 1; j++) {
                if (zufall(1) <= p) {
                    if ((getNorden(spiegel, i, j, false) != '/' && getNorden(spiegel, i, j, false) != '\\'
                            && getSueden(spiegel, i, j, false) != '/' && getSueden(spiegel, i, j, false) != '\\'
                            && getWesten(spiegel, i, j, false) != '/' && getWesten(spiegel, i, j, false) != '\\'
                            && getOsten(spiegel, i, j, false) != '/' && getOsten(spiegel, i, j, false) != '\\')
                            || schwer) {
                        if (zufall(1) > 0.5) {
                            spiegel[i][j] = '/';
                        } else {
                            spiegel[i][j] = '\\';
                        }
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
                return getOsten(spiegel, i, j, false);
            case -1:
                return getWesten(spiegel, i, j, false);
            case -2:
                return getNorden(spiegel, i, j, false);
        }
        return '0';
    }

    public static char[][] bewegePfeileSchwer(char[][] spiegel, double q) {
        /*
                1
            2   /   -1   == * (-1)
               -2
 /
                1
            2   \   -1   ==
               -2
         */
        int[] mx = new int[]{0, -1, 0, 0, 1};
        int[] my = new int[]{-1, 0, 0, 1, 0};
        char[] zeichen = new char[]{'^', '<', ' ', 'V', '>'};
        int dir = 0;
        char[][] spiegelKopie = copy2DCharArray(spiegel);
        for (int i = 0; i < spiegel.length; i++) {
            for (int j = 0; j < spiegel[i].length; j++) {
                dir = 0;
                if (spiegel[i][j] == '>') {
                    dir = 2;
                    if (i + mx[dir + 2] >= spiegel.length) {
                        dir = 0;
                        spiegelKopie[i][j] = ' ';
                    }
                } else if (spiegel[i][j] == '<') {
                    dir = -1;
                    if (i + mx[dir + 2] < 0) {
                        dir = 0;
                        spiegelKopie[i][j] = ' ';
                    }
                } else if (spiegel[i][j] == '^') {
                    dir = -2;
                    if (j + my[dir + 2] < 0) {
                        dir = 0;
                        spiegelKopie[i][j] = ' ';
                    }
                } else if (spiegel[i][j] == 'V') {
                    dir = 1;
                    if (j + my[dir + 2] > spiegel[i].length) {
                        dir = 0;
                        spiegelKopie[i][j] = ' ';
                    }
                }
                if (dir != 0) {
                    char feld;
                    int x = i;
                    int y = j;
                    spiegelKopie[i][j] = ' ';
                    do {
                        feld = getDirection(spiegel, dir, x, y);
                        System.out.println(feld);
                        if (i + mx[dir + 2] < spiegel.length && j + my[dir + 2] < spiegel[i].length && i + mx[dir + 2] >= 0 && j + my[dir + 2] >= 0) {
                            if (feld == ' ') {
                                x += mx[dir + 2];
                                y += my[dir + 2];
                                feld = '-';
                            } else if (feld == 'O') {
                                x += mx[dir + 2];
                                y += my[dir + 2];
                                dir = 0;
                                feld = '-';
                            } else if (feld == '/') {
                                x += mx[dir + 2];
                                y += my[dir + 2];
                                dir *= -1;
//                                x += mx[dir + 2];
//                                y += my[dir + 2];
                                if (zufall(1) <= q) {
                                    spiegelKopie[x][y] = '\\';
                                }
                            } else if (feld == '\\') {
                                x += mx[dir + 2];
                                y += my[dir + 2];
                                if (dir == 2 || dir == -1) {
                                    dir--;
                                } else {
                                    dir++;
                                }
//                                x += mx[dir + 2];
//                                y += my[dir + 2];
                                if (zufall(1) <= q) {
                                    spiegelKopie[x][y] = '/';
                                }
                            } else {
                                x += mx[dir + 2];
                                y += my[dir + 2];
                                dir = 0;
                                feld = '-';
                            }
                        } else {
                            spiegelKopie[i][j] = ' ';
                        }
                    } while (feld == '/' || feld == '\\');
                    spiegelKopie[x][y] = zeichen[dir + 2];
                }
            }
        }
        spiegel = copy2DCharArray(spiegelKopie);
        return spiegel;
    }

    public static char[][] bewegePfeile(char[][] spiegel, double q) {
        /*
                1
            2   /   -1
               -2
 /
                1
            2   \   -1
               -2
         */
        int[] mx = new int[]{0, -1, 0, 0, 1};
        int[] my = new int[]{-1, 0, 0, 1, 0};
        char[] zeichen = new char[]{'^', '<', '0', 'V', '>'};
        int dir = 0;
        char[][] spiegelKopie = copy2DCharArray(spiegel);
        for (int i = 0; i < spiegel.length; i++) {
            for (int j = 0; j < spiegel[i].length; j++) {
                dir = 0;
                if (spiegel[i][j] == '>') {
                    dir = 2;
                    if (i + mx[dir + 2] >= spiegel.length) {
                        dir = 0;
                        spiegelKopie[i][j] = ' ';
                    }
                } else if (spiegel[i][j] == '<') {
                    dir = -1;
                    if (i + mx[dir + 2] < 0) {
                        dir = 0;
                        spiegelKopie[i][j] = ' ';
                    }
                } else if (spiegel[i][j] == '^') {
                    dir = -2;
                    if (j + my[dir + 2] < 0) {
                        dir = 0;
                        spiegelKopie[i][j] = ' ';
                    }
                } else if (spiegel[i][j] == 'V') {
                    dir = 1;
                    if (j + my[dir + 2] > spiegel[i].length) {
                        dir = 0;
                        spiegelKopie[i][j] = ' ';
                    }
                }
                if (dir != 0) {
                    char feld = getDirection(spiegel, dir, i, j);
                    if (i + mx[dir + 2] < spiegel.length && j + my[dir + 2] < spiegel[i].length && i + mx[dir + 2] >= 0 && j + my[dir + 2] >= 0) {
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
                            dir *= -1;
                            x += mx[dir + 2];
                            y += my[dir + 2];
                            spiegelKopie[x][y] = zeichen[dir + 2];
                            if (zufall(1) <= q) {
                                spiegelKopie[x][y] = '\\';
                            }
                        } else if (feld == '\\') {
                            spiegelKopie[i][j] = ' ';
                            int x = i + mx[dir + 2];
                            int y = j + my[dir + 2];
                            if (dir == 2 || dir == -1) {
                                dir--;
                            } else {
                                dir++;
                            }
                            x += mx[dir + 2];
                            y += my[dir + 2];
                            spiegelKopie[x][y] = zeichen[dir + 2];
                            if (zufall(1) <= q) {
                                spiegelKopie[x][y] = '/';
                            }
                        } else {
                            spiegelKopie[i + mx[dir + 2]][j + my[dir + 2]] = ' ';
                            spiegelKopie[i][j] = ' ';
                        }
                    } else {
                        spiegelKopie[i][j] = ' ';
                    }
                }
            }
        }
        spiegel = copy2DCharArray(spiegelKopie);
        return spiegel;
    }

    public static void spiegelSimulation(int n, double q, int abs, boolean schwer) {
        char[][] spiegel = createEmpty2DCharArray(40, 40);
        SchischVisualizer sv = new SchischVisualizer();
        zufallSpiegel(spiegel, 0.3, schwer);
        sv.step(spiegel);
        zufallZiele(spiegel, 0.1);
        sv.step(spiegel);
        /*
        spiegel[zufallGanz(spiegel.length) - 1][zufallGanz(spiegel[0].length) - 1] = '^';
        spiegel[zufallGanz(spiegel.length) - 1][zufallGanz(spiegel[0].length) - 1] = 'V';
        spiegel[zufallGanz(spiegel.length) - 1][zufallGanz(spiegel[0].length) - 1] = '<';
        sv.step(spiegel);
         */
        for (int i = 0; i < n; i++) {
            if (schwer) {
                spiegel = bewegePfeileSchwer(spiegel, q);
            } else {
                spiegel = bewegePfeile(spiegel, q);
            }
            if (i % abs == 0) {
                generierePfeil(spiegel);
            }
            sv.step(spiegel);
        }
        boolean sieg = true;
        for (int i = 0; i < spiegel.length; i++) {
            for (int j = 0; j < spiegel[i].length; j++) {
                if (spiegel[i][j] == 'O') {
                    sieg = false;
                }
            }
        }
        System.out.println(sieg);
        sv.start();
    }

    public static void main(String[] args) {
        spiegelSimulation(100, 0.5, 4, true);
    }

}
