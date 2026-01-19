package blatt15;

import schisch_visualizer.SchischVisualizer;

import static blatt14.MultiArrays.*;
import static blatt13.Zufall.*;

public class Farben {

    static int[] spielerPosX = new int[8];
    static int[] spielerPosY = new int[8];
    static char[][] spielfeld;

    static SchischVisualizer sv = new SchischVisualizer();

    public static void initialisiereSpielfeld(int a, int b) {
        spielfeld = createEmpty2DCharArray(a, b);
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                if (i == 0 || j == 0 || i == a - 1 || j == b - 1) {
                    spielfeld[i][j] = '8';
                }
            }
        }
        sv.step(spielfeld);
    }

    public static void startPositionen() {
        for (int i = 0; i < spielerPosY.length; i++) {
            spielerPosY[i] = zufallGanz(1, spielfeld.length - 2);
            if (i < 4) {
                spielerPosX[i] = zufallGanz(1, spielfeld.length/2);
            } else {
                spielerPosX[i] = zufallGanz(spielfeld.length/2 + 1, spielfeld.length - 2);
            }
            spielfeld[spielerPosX[i]][spielerPosY[i]] = 'P';
        }
        sv.step(spielfeld);
    }

    public static int zaehlen(int team) {
        if (team >= 0 && team <= 2) {
            int n = 0;
            char[] f = new char[]{' ','7', '9'};
            for (int i = 0; i < spielfeld.length; i++) {
                for (int j = 0; j < spielfeld[i].length; j++) {
                    if (spielfeld[i][j] == f[team]) {
                        n++;
                    }
                }
            }
            for (int i = 1; i < 4; i++) {
                if (team == 1 && spielerPosX[i] > -1) {
                    n++;
                } else if (team == 2 && spielerPosX[i + 4] > -1) {
                    n++;
                }
            }
            return n;
        } else {
            return -1;
        }

    }

    public static void respawn(int spielernummer) {
        if (spielernummer >= 0 && spielernummer <= 7) {
            char[] f = new char[]{'7', '7', '7', '7', '9', '9', '9', '9'};
            int[] team = new int[]{1, 1, 1, 1, 2, 2, 2, 2};
            int sp = 0;
            for (int i = 1; i < 4; i++) {
                if (team[spielernummer] == 1 && spielerPosX[i] > -1) {
                    sp++;
                } else if (team[spielernummer] == 2 && spielerPosX[i + 4] > -1) {
                    sp++;
                }
            }
            int n = zaehlen(team[spielernummer]) - sp;
            if (n > 0) {
                int[][] p = new int[n][2];
                int k = 0;
                for (int i = 0; i < spielfeld.length; i++) {
                    for (int j = 0; j < spielfeld[i].length; j++) {
                        if (spielfeld[i][j] == f[spielernummer]) {
                            if (k < p.length) {
                                p[k][0] = i;
                                p[k][1] = j;
                                k++;
                            }
                        }
                    }
                }
                print2DArray(p);
                int z = zufallGanz(0, p.length);
                System.out.println(z);
                spielerPosX[spielernummer] = p[z][0];
                spielerPosY[spielernummer] = p[z][1];
            } else {
                while (true) {
                    spielerPosX[spielernummer] = zufallGanz(1, spielfeld.length - 1);
                    spielerPosY[spielernummer] = zufallGanz(1, spielfeld[0].length - 1);
                    if (spielfeld[spielerPosX[spielernummer]][spielerPosY[spielernummer]] != 'P' && spielfeld[spielerPosX[spielernummer]][spielerPosY[spielernummer]] != '8') {
                        break;
                    }
                }
            }
            spielfeld[spielerPosX[spielernummer]][spielerPosY[spielernummer]] = 'P';
            sv.step(spielfeld);
        }
    }

    public static void main(String[] args) {
        initialisiereSpielfeld(80, 80);
        /*
        for (int i = 0; i < spielfeld.length; i++) {

            for (int j = 0; j < spielfeld[i].length; j++) {
                if (zufall(0, 1) < 0.5) {
                    spielfeld[i][j] = '7';
                } else if (zufall(0, 1) < 0.5) {
                    spielfeld[i][j] = '9';
                }
            }
        }

         */
        spielfeld[12][34] = '7';
        spielfeld[59][38] = '7';
        sv.step(spielfeld);
        for (int i = 0; i < 8; i++) {
            spielerPosX[i] = -1;
            spielerPosY[i] = -1;
            respawn(i);
        }
        sv.start();
    }
}
