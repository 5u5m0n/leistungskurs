package blatt14;

import schisch_visualizer.SchischVisualizer;

import static blatt07.ArbeitMitArrays.*;
import static blatt14.MultiArrays.*;
import static blatt13.Zufall.*;
import static blatt14.Simulationen.*;

public class Steine {
    static char[][] spielfeld;
    static SchischVisualizer sv = new SchischVisualizer();
    static int[] rot = new int[] {1, 2, -1, -2};
    static int[] steinx = new int[4];
    static int[] steiny = new int[4];
    static boolean lose = false;
    static boolean istGefallen = false;

    /**
     * Initialisiert das Spielfeld
     * @param a Breite
     * @param b Höhe
     */
    public static void initialisiereSpielfeld(int a, int b) {
        spielfeld = createEmpty2DCharArray(a, b);
        sv.step(spielfeld);
    }

    public static void zeichneI(int posX, int posY, boolean vertikal) {
        if (vertikal) {
            if (posY + 3 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 4;
            }
            steinx[0] = posX;
            steiny[0] = posY+3;
            steinx[1] = posX;
            steiny[1] = posY+2;
            steinx[2] = posX;
            steiny[2] = posY+1;
            steinx[3] = posX;
            steiny[3] = posY;
        } else {
            if (posX + 3 >= spielfeld.length) {
                posX = spielfeld.length - 4;
            }
            steinx[0] = posX;
            steiny[0] = posY;
            steinx[1] = posX+1;
            steiny[1] = posY;
            steinx[2] = posX+2;
            steiny[2] = posY;
            steinx[3] = posX+3;
            steiny[3] = posY;

        }
        for (int i = 0; i < steinx.length; i++) {
            if (spielfeld[steinx[i]][steiny[i]] != ' ') {
                lose = true;
            }
        }
        if (!lose) {
            spielfeld[steinx[0]][steiny[0]] = '6';
            spielfeld[steinx[1]][steiny[1]] = '6';
            spielfeld[steinx[2]][steiny[2]] = '6';
            spielfeld[steinx[3]][steiny[3]] = '6';
        }

    }

    public static void zeichneO(int posX, int posY) {
        if (posX + 1 >= spielfeld.length) {
            posX = spielfeld.length - 2;
        }
        if (posY + 1 >= spielfeld[posX].length) {
            posY = spielfeld[posX].length - 2;
        }
        steinx[0] = posX;
        steiny[0] = posY;
        steinx[1] = posX+1;
        steiny[1] = posY;
        steinx[2] = posX;
        steiny[2] = posY+1;
        steinx[3] = posX+1;
        steiny[3] = posY+1;
        for (int i = 0; i < steinx.length; i++) {
            if (spielfeld[steinx[i]][steiny[i]] != ' ') {
                lose = true;
            }
        }
        if (!lose) {
            spielfeld[steinx[0]][steiny[0]] = '5';
            spielfeld[steinx[1]][steiny[1]] = '5';
            spielfeld[steinx[2]][steiny[2]] = '5';
            spielfeld[steinx[3]][steiny[3]] = '5';
        }
    }

    public static void zeichneT(int posX, int posY, int rotation) {
        if (rotation % 2 != 0 && rotation >= 0) {
            if (posX + 2 >= spielfeld.length) {
                posX = spielfeld.length - 3;
            }
            if (posY + 1 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 2;
            }
            steinx[0] = posX+1;
            steiny[0] = posY;
            steinx[1] = posX;
            steiny[1] = posY+1;
            steinx[2] = posX+1;
            steiny[2] = posY+1;
            steinx[3] = posX+2;
            steiny[3] = posY+1;
        } else if (rotation % 2 != 0 && rotation <= 0) {
            if (posX + 2 >= spielfeld.length) {
                posX = spielfeld.length - 3;
            }
            if (posY + 1 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 2;
            }
            steinx[0] = posX;
            steiny[0] = posY;
            steinx[1] = posX+1;
            steiny[1] = posY;
            steinx[2] = posX+2;
            steiny[2] = posY;
            steinx[3] = posX+1;
            steiny[3] = posY+1;
            } else if (rotation % 2 == 0 && rotation >= 0) {
            if (posX + 1 >= spielfeld.length) {
                posX = spielfeld.length - 2;
            }
            if (posY + 2 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 3;
            }
            steinx[0] = posX;
            steiny[0] = posY;
            steinx[1] = posX;
            steiny[1] = posY+1;
            steinx[2] = posX;
            steiny[2] = posY+2;
            steinx[3] = posX+1;
            steiny[3] = posY+1;
        } else if (rotation % 2 == 0 && rotation <= 0) {
            if (posX + 1 >= spielfeld.length) {
                posX = spielfeld.length - 2;
            }
            if (posY + 2 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 3;
            }
            steinx[0] = posX+1;
            steiny[0] = posY;
            steinx[1] = posX+1;
            steiny[1] = posY+1;
            steinx[2] = posX+1;
            steiny[2] = posY+2;
            steinx[3] = posX;
            steiny[3] = posY+1;
        }
        for (int i = 0; i < steinx.length; i++) {
            if (spielfeld[steinx[i]][steiny[i]] != ' ') {
                lose = true;
            }
        }
        if (!lose) {
            spielfeld[steinx[0]][steiny[0]] = '7';
            spielfeld[steinx[1]][steiny[1]] = '7';
            spielfeld[steinx[2]][steiny[2]] = '7';
            spielfeld[steinx[3]][steiny[3]] = '7';
        }

    }

    public static void zeichneS(int posX, int posY, boolean vertikal) {
        if (vertikal) {
            if (posX + 1 >= spielfeld.length) {
                posX = spielfeld.length - 2;
            }
            if (posY + 2 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 3;
            }
            steinx[0] = posX;
            steiny[0] = posY;
            steinx[1] = posX;
            steiny[1] = posY+1;
            steinx[2] = posX+1;
            steiny[2] = posY+1;
            steinx[3] = posX+1;
            steiny[3] = posY+2;
        } else {
            if (posX + 2 >= spielfeld.length) {
                posX = spielfeld.length - 3;
            }
            if (posY + 1 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 2;
            }
            steinx[0] = posX+1;
            steiny[0] = posY;
            steinx[1] = posX+2;
            steiny[1] = posY;
            steinx[2] = posX;
            steiny[2] = posY+1;
            steinx[3] = posX+1;
            steiny[3] = posY+1;
        }
        for (int i = 0; i < steinx.length; i++) {
            if (spielfeld[steinx[i]][steiny[i]] != ' ') {
                lose = true;
            }
        }
        if (!lose) {
            spielfeld[steinx[0]][steiny[0]] = '9';
            spielfeld[steinx[1]][steiny[1]] = '9';
            spielfeld[steinx[2]][steiny[2]] = '9';
            spielfeld[steinx[3]][steiny[3]] = '9';
        }

    }

    public static void zeichneZ(int posX, int posY, boolean vertikal) {
        if (vertikal) {
            if (posX + 1 >= spielfeld.length) {
                posX = spielfeld.length - 2;
            }
            if (posY + 2 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 3;
            }
            steinx[0] = posX+1;
            steiny[0] = posY;
            steinx[1] = posX+1;
            steiny[1] = posY+1;
            steinx[2] = posX;
            steiny[2] = posY+1;
            steinx[3] = posX;
            steiny[3] = posY+2;
        } else {
            if (posX + 2 >= spielfeld.length) {
                posX = spielfeld.length - 3;
            }
            if (posY + 1 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 2;
            }
            steinx[0] = posX;
            steiny[0] = posY;
            steinx[1] = posX+1;
            steiny[1] = posY;
            steinx[2] = posX+1;
            steiny[2] = posY+1;
            steinx[3] = posX+2;
            steiny[3] = posY+1;
        }
        for (int i = 0; i < steinx.length; i++) {
            if (spielfeld[steinx[i]][steiny[i]] != ' ') {
                lose = true;
            }
        }
        if (!lose) {
            spielfeld[steinx[0]][steiny[0]] = '4';
            spielfeld[steinx[1]][steiny[1]] = '4';
            spielfeld[steinx[2]][steiny[2]] = '4';
            spielfeld[steinx[3]][steiny[3]] = '4';
        }

    }

    public static void zeichneJ(int posX, int posY, int rotation) {
        if (rotation % 2 != 0 && rotation >= 0) {
            if (posX + 2 >= spielfeld.length) {
                posX = spielfeld.length - 3;
            }
            if (posY + 1 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 2;
            }
            steinx[0] = posX;
            steiny[0] = posY;
            steinx[1] = posX;
            steiny[1] = posY+1;
            steinx[2] = posX+1;
            steiny[2] = posY+1;
            steinx[3] = posX+2;
            steiny[3] = posY+1;
        } else if (rotation % 2 != 0 && rotation <= 0) {
            if (posX + 2 >= spielfeld.length) {
                posX = spielfeld.length - 3;
            }
            if (posY + 1 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 2;
            }
            steinx[0] = posX;
            steiny[0] = posY;
            steinx[1] = posX+1;
            steiny[1] = posY;
            steinx[2] = posX+2;
            steiny[2] = posY;
            steinx[3] = posX+2;
            steiny[3] = posY+1;
        } else if (rotation % 2 == 0 && rotation >= 0) {
            if (posX + 1 >= spielfeld.length) {
                posX = spielfeld.length - 2;
            }
            if (posY + 2 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 3;
            }
            steinx[0] = posX;
            steiny[0] = posY;
            steinx[1] = posX;
            steiny[1] = posY+1;
            steinx[2] = posX;
            steiny[2] = posY+2;
            steinx[3] = posX+1;
            steiny[3] = posY;
        } else if (rotation % 2 == 0 && rotation <= 0) {
            if (posX + 1 >= spielfeld.length) {
                posX = spielfeld.length - 2;
            }
            if (posY + 2 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 3;
            }
            steinx[0] = posX+1;
            steiny[0] = posY;
            steinx[1] = posX+1;
            steiny[1] = posY+1;
            steinx[2] = posX+1;
            steiny[2] = posY+2;
            steinx[3] = posX;
            steiny[3] = posY+2;
        }
        for (int i = 0; i < steinx.length; i++) {
            if (spielfeld[steinx[i]][steiny[i]] != ' ') {
                lose = true;
            }
        }
        if (!lose) {
            spielfeld[steinx[0]][steiny[0]] = '2';
            spielfeld[steinx[1]][steiny[1]] = '2';
            spielfeld[steinx[2]][steiny[2]] = '2';
            spielfeld[steinx[3]][steiny[3]] = '2';
        }

    }

    public static void zeichneL(int posX, int posY, int rotation) {
        if (rotation % 2 != 0 && rotation >= 0) {
            if (posX + 2 >= spielfeld.length) {
                posX = spielfeld.length - 3;
            }
            if (posY + 1 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 2;
            }
            steinx[0] = posX+2;
            steiny[0] = posY;
            steinx[1] = posX;
            steiny[1] = posY+1;
            steinx[2] = posX+1;
            steiny[2] = posY+1;
            steinx[3] = posX+2;
            steiny[3] = posY+1;
        } else if (rotation % 2 != 0 && rotation <= 0) {
            if (posX + 2 >= spielfeld.length) {
                posX = spielfeld.length - 3;
            }
            if (posY + 1 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 2;
            }
            steinx[0] = posX;
            steiny[0] = posY;
            steinx[1] = posX+1;
            steiny[1] = posY;
            steinx[2] = posX+2;
            steiny[2] = posY;
            steinx[3] = posX;
            steiny[3] = posY+1;
        } else if (rotation % 2 == 0 && rotation >= 0) {
            if (posX + 1 >= spielfeld.length) {
                posX = spielfeld.length - 2;
            }
            if (posY + 2 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 3;
            }
            steinx[0] = posX;
            steiny[0] = posY;
            steinx[1] = posX;
            steiny[1] = posY+1;
            steinx[2] = posX;
            steiny[2] = posY+2;
            steinx[3] = posX+1;
            steiny[3] = posY+2;
        } else if (rotation % 2 == 0 && rotation <= 0) {
            if (posX + 1 >= spielfeld.length) {
                posX = spielfeld.length - 2;
            }
            if (posY + 2 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 3;
            }
            steinx[0] = posX+1;
            steiny[0] = posY;
            steinx[1] = posX+1;
            steiny[1] = posY+1;
            steinx[2] = posX+1;
            steiny[2] = posY+2;
            steinx[3] = posX;
            steiny[3] = posY;
        }
        for (int i = 0; i < steinx.length; i++) {
            if (spielfeld[steinx[i]][steiny[i]] != ' ') {
                lose = true;
            }
        }
        if (!lose) {
            spielfeld[steinx[0]][steiny[0]] = 'A';
            spielfeld[steinx[1]][steiny[1]] = 'A';
            spielfeld[steinx[2]][steiny[2]] = 'A';
            spielfeld[steinx[3]][steiny[3]] = 'A';
        }

    }

    public static void zufallsStein() {
        int z = zufallGanz(1,7);
        int r;
        boolean v;
        switch(z) {
            case 1:
                v = zufallGanz(1,2) % 2 == 0;
                if (v) {
                    zeichneI(zufallGanz(spielfeld.length-1), 0, v);
                } else {
                    zeichneI(zufallGanz(spielfeld.length-4), 0, v);
                }
                break;
            case 2:
                r = rot[zufallGanz(rot.length-1)];
                if (r < 0) {
                    zeichneJ(zufallGanz(spielfeld.length - 2), 0, r);
                } else {
                    zeichneJ(zufallGanz(spielfeld.length - 3), 0, r);
                }
                break;
            case 3:
                r = rot[zufallGanz(rot.length-1)];
                if (r < 0) {
                    zeichneL(zufallGanz(spielfeld.length - 2), 0, r);
                } else {
                    zeichneL(zufallGanz(spielfeld.length - 3), 0, r);
                }
                break;
            case 4:
                zeichneO(zufallGanz(spielfeld.length-2), 0);
                break;
            case 5:
                v = zufallGanz(1,2) % 2 == 0;
                if (v) {
                    zeichneS(zufallGanz(spielfeld.length-2), 0, v);
                } else {
                    zeichneS(zufallGanz(spielfeld.length-3), 0, v);
                }
                break;
            case 6:
                v = zufallGanz(1,2) % 2 == 0;
                if (v) {
                    zeichneZ(zufallGanz(spielfeld.length-2), 0, v);
                } else {
                    zeichneI(zufallGanz(spielfeld.length-3), 0, v);
                }
                break;
            case 7:
                r = rot[zufallGanz(rot.length-1)];
                if (r < 0) {
                    zeichneT(zufallGanz(spielfeld.length - 2), 0, r);
                } else {
                    zeichneT(zufallGanz(spielfeld.length - 3), 0, r);
                }
                break;
        }
        sv.step(spielfeld);
    }

    public static void fallen() {
        char p = spielfeld[steinx[0]][steiny[0]];
        boolean fall = true;
        //int[] zs = new int[]{-1, -1, -1, -1};
        /*
        for (int i = 0; i < steinx.length; i++) {
            int z = steinx[i];
            int max = 0;
            for (int j = 0; j < steinx.length; j++) {
                if (steinx[j] == z && steiny[j] > steiny[max]) {
                    max = j;
                }
            }
            if (getSueden(spielfeld, steinx[max], steiny[max], false) != ' ') {
                fall = false;
            }
        }
         */

        spielfeld[steinx[0]][steiny[0]] = ' ';
        spielfeld[steinx[1]][steiny[1]] = ' ';
        spielfeld[steinx[2]][steiny[2]] = ' ';
        spielfeld[steinx[3]][steiny[3]] = ' ';
        for (int i = 0; i < steiny.length; i++) {
            if (steiny[i] + 1 >= spielfeld[i].length) {
                fall = false;
                break;
            }
            if (spielfeld[steinx[i]][steiny[i] + 1] != ' ') {
                fall = false;
                break;
            }
        }
        if (fall) {
            steiny[0]++;
            steiny[1]++;
            steiny[2]++;
            steiny[3]++;
            spielfeld[steinx[0]][steiny[0]] = p;
            spielfeld[steinx[1]][steiny[1]] = p;
            spielfeld[steinx[2]][steiny[2]] = p;
            spielfeld[steinx[3]][steiny[3]] = p;
            sv.step(spielfeld);
        } else {
            spielfeld[steinx[0]][steiny[0]] = p;
            spielfeld[steinx[1]][steiny[1]] = p;
            spielfeld[steinx[2]][steiny[2]] = p;
            spielfeld[steinx[3]][steiny[3]] = p;
            istGefallen = true;
        }
    }

    public static void shiftDown(int s) {
        for (int i = 0; i < spielfeld.length; i++) {
            for (int k = s; k > 0; k--) {
                spielfeld[i][k] = spielfeld[i][k - 1];
            }
            spielfeld[i][0] = ' ';
        }
    }

    public static void reihenEntfernen() {
        boolean voll;
        for (int i = 0; i < spielfeld[0].length; i++) {
            voll = true;
            for (int j = 0; j < spielfeld.length; j++) {
                if (spielfeld[j][i] == ' ') {
                    voll = false;
                    break;
                }
            }
            if (voll) {
                shiftDown(i);
            }
        }
        sv.step(spielfeld);
    }

    public static void tetris() {
        while (true) {
            zufallsStein();
            if (lose) {
                break;
            }
            while (!istGefallen) {
                fallen();
            }
            reihenEntfernen();
            istGefallen = false;
        }
    }

    public static void main(String[] args) {
        initialisiereSpielfeld(10, 40);
        tetris();
        sv.start();
    }
}
