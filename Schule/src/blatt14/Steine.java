package blatt14;

import schisch_visualizer.SchischVisualizer;

import static blatt14.MultiArrays.*;
import static blatt13.Zufall.*;
import static blatt14.Simulationen.*;

public class Steine {
    static char[][] spielfeld;
    static SchischVisualizer sv = new SchischVisualizer();
    static int[] rot = new int[] {1, 2, -1, -2};
    static int[]steinx = new int[4];
    static int[]steiny = new int[4];

    /**
     * Initialisiert das Spielfeld
     * @param a Breite
     * @param b Höhe
     */
    public static void initialisiereSpielfeld(int a, int b) {
        spielfeld = createEmpty2DCharArray(a, b);
        //sv.step(spielfeld);
    }

    public static void zeichneI(int posX, int posY, boolean vertikal) {
        if (vertikal) {
            if (posY + 3 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 4;
            }
            spielfeld[posX][posY] = '6';
            spielfeld[posX][posY+1] = '6';
            spielfeld[posX][posY+2] = '6';
            spielfeld[posX][posY+3] = '6';
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
            spielfeld[posX][posY] = '6';
            spielfeld[posX+1][posY] = '6';
            spielfeld[posX+2][posY] = '6';
            spielfeld[posX+3][posY] = '6';
            steinx[0] = posX;
            steiny[0] = posY;
            steinx[1] = posX+1;
            steiny[1] = posY;
            steinx[2] = posX+2;
            steiny[2] = posY;
            steinx[3] = posX+3;
            steiny[3] = posY;
        }
    }

    public static void zeichneO(int posX, int posY) {
        if (posX + 1 >= spielfeld.length) {
            posX = spielfeld.length - 2;
        }
        if (posY + 1 >= spielfeld[posX].length) {
            posY = spielfeld[posX].length - 2;
        }
        spielfeld[posX][posY] = '5';
        spielfeld[posX+1][posY] = '5';
        spielfeld[posX][posY+1] = '5';
        spielfeld[posX+1][posY+1] = '5';
    }

    public static void zeichneT(int posX, int posY, int rotation) {
        if (rotation % 2 != 0 && rotation >= 0) {
            if (posX + 2 >= spielfeld.length) {
                posX = spielfeld.length - 3;
            }
            if (posY + 1 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 2;
            }
            spielfeld[posX+1][posY] = '7';
            spielfeld[posX][posY+1] = '7';
            spielfeld[posX+1][posY+1] = '7';
            spielfeld[posX+2][posY+1] = '7';
        } else if (rotation % 2 != 0 && rotation <= 0) {
            if (posX + 2 >= spielfeld.length) {
                posX = spielfeld.length - 3;
            }
            if (posY + 1 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 2;
            }
            spielfeld[posX][posY] = '7';
            spielfeld[posX+1][posY] = '7';
            spielfeld[posX+2][posY] = '7';
            spielfeld[posX+1][posY+1] = '7';
        } else if (rotation % 2 == 0 && rotation >= 0) {
            if (posX + 1 >= spielfeld.length) {
                posX = spielfeld.length - 2;
            }
            if (posY + 2 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 3;
            }
            spielfeld[posX][posY] = '7';
            spielfeld[posX][posY+1] = '7';
            spielfeld[posX][posY+2] = '7';
            spielfeld[posX+1][posY+1] = '7';
        } else if (rotation % 2 == 0 && rotation <= 0) {
            if (posX + 1 >= spielfeld.length) {
                posX = spielfeld.length - 2;
            }
            if (posY + 2 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 3;
            }
            spielfeld[posX+1][posY] = '7';
            spielfeld[posX+1][posY+1] = '7';
            spielfeld[posX+1][posY+2] = '7';
            spielfeld[posX][posY+1] = '7';
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
            spielfeld[posX][posY] = '9';
            spielfeld[posX][posY+1] = '9';
            spielfeld[posX+1][posY+1] = '9';
            spielfeld[posX+1][posY+2] = '9';

        } else {
            if (posX + 2 >= spielfeld.length) {
                posX = spielfeld.length - 3;
            }
            if (posY + 1 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 2;
            }
            spielfeld[posX+1][posY] = '9';
            spielfeld[posX+2][posY] = '9';
            spielfeld[posX][posY+1] = '9';
            spielfeld[posX+1][posY+1] = '9';
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

            spielfeld[posX+1][posY] = '4';
            spielfeld[posX+1][posY+1] = '4';
            spielfeld[posX][posY+1] = '4';
            spielfeld[posX][posY+2] = '4';

        } else {
            if (posX + 2 >= spielfeld.length) {
                posX = spielfeld.length - 3;
            }
            if (posY + 1 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 2;
            }
            spielfeld[posX][posY] = '4';
            spielfeld[posX+1][posY] = '4';
            spielfeld[posX+1][posY+1] = '4';
            spielfeld[posX+2][posY+1] = '4';
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
            spielfeld[posX][posY] = '2';
            spielfeld[posX][posY+1] = '2';
            spielfeld[posX+1][posY+1] = '2';
            spielfeld[posX+2][posY+1] = '2';
        } else if (rotation % 2 != 0 && rotation <= 0) {
            if (posX + 2 >= spielfeld.length) {
                posX = spielfeld.length - 3;
            }
            if (posY + 1 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 2;
            }
            spielfeld[posX][posY] = '2';
            spielfeld[posX+1][posY] = '2';
            spielfeld[posX+2][posY] = '2';
            spielfeld[posX+2][posY+1] = '2';
        } else if (rotation % 2 == 0 && rotation >= 0) {
            if (posX + 1 >= spielfeld.length) {
                posX = spielfeld.length - 2;
            }
            if (posY + 2 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 3;
            }
            spielfeld[posX][posY] = '2';
            spielfeld[posX][posY+1] = '2';
            spielfeld[posX][posY+2] = '2';
            spielfeld[posX+1][posY] = '2';
        } else if (rotation % 2 == 0 && rotation <= 0) {
            if (posX + 1 >= spielfeld.length) {
                posX = spielfeld.length - 2;
            }
            if (posY + 2 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 3;
            }
            spielfeld[posX+1][posY] = '2';
            spielfeld[posX+1][posY+1] = '2';
            spielfeld[posX+1][posY+2] = '2';
            spielfeld[posX][posY+2] = '2';
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
            spielfeld[posX+2][posY] = 'A';
            spielfeld[posX][posY+1] = 'A';
            spielfeld[posX+1][posY+1] = 'A';
            spielfeld[posX+2][posY+1] = 'A';
        } else if (rotation % 2 != 0 && rotation <= 0) {
            if (posX + 2 >= spielfeld.length) {
                posX = spielfeld.length - 3;
            }
            if (posY + 1 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 2;
            }
            spielfeld[posX][posY] = 'A';
            spielfeld[posX+1][posY] = 'A';
            spielfeld[posX+2][posY] = 'A';
            spielfeld[posX][posY+1] = 'A';
        } else if (rotation % 2 == 0 && rotation >= 0) {
            if (posX + 1 >= spielfeld.length) {
                posX = spielfeld.length - 2;
            }
            if (posY + 2 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 3;
            }
            spielfeld[posX][posY] = 'A';
            spielfeld[posX][posY+1] = 'A';
            spielfeld[posX][posY+2] = 'A';
            spielfeld[posX+1][posY+2] = 'A';
        } else if (rotation % 2 == 0 && rotation <= 0) {
            if (posX + 1 >= spielfeld.length) {
                posX = spielfeld.length - 2;
            }
            if (posY + 2 >= spielfeld[posX].length) {
                posY = spielfeld[posX].length - 3;
            }
            spielfeld[posX+1][posY] = 'A';
            spielfeld[posX+1][posY+1] = 'A';
            spielfeld[posX+1][posY+2] = 'A';
            spielfeld[posX][posY] = 'A';
        }
    }

    public static void zufallsStein() {
        int z = zufallGanz(1,7);
        int posX = zufallGanz(spielfeld.length);
        int posY = 0;
        switch(z) {
            case 1:
                zeichneI(posX, posY, zufallGanz(1,2) % 2 == 0);
                break;
            case 2:
                zeichneJ(posX, posY, rot[zufallGanz(rot.length-1)]);
                break;
            case 3:
                zeichneL(posX, posY, rot[zufallGanz(rot.length-1)]);
                break;
            case 4:
                zeichneO(posX, posY);
                break;
            case 5:
                zeichneS(posX, posY, zufallGanz(1,2) % 2 == 0);
                break;
            case 6:
                zeichneZ(posX, posY, zufallGanz(1,2) % 2 == 0);
                break;
            case 7:
                zeichneT(posX, posY, rot[zufallGanz(rot.length-1)]);
        }
    }

    public static void main(String[] args) {
        /*
        initialisiereSpielfeld(10, 40);
        sv.step(spielfeld);
        zeichneI(0, 0, false);
        sv.step(spielfeld);
        initialisiereSpielfeld(10, 40);
        zeichneI(0, 0, true);
        sv.step(spielfeld);
        initialisiereSpielfeld(10, 40);
        zeichneI(80, 0, false);
        sv.step(spielfeld);
        initialisiereSpielfeld(10, 40);
        zeichneO(0, 0);
        sv.step(spielfeld);
        initialisiereSpielfeld(10, 40);
        zeichneO(80, 0);
        sv.step(spielfeld);
        for (int i = 0; i < rot.length; i++) {
            initialisiereSpielfeld(10, 40);
            zeichneT(0, 0, rot[i]);
            sv.step(spielfeld);
        }
        for (int i = 0; i < rot.length; i++) {
            initialisiereSpielfeld(10, 40);
            zeichneT(80, 0, rot[i]);
            sv.step(spielfeld);
        }
        initialisiereSpielfeld(10, 40);
        zeichneS(0, 0, false);
        sv.step(spielfeld);
        initialisiereSpielfeld(10, 40);
        zeichneS(0, 0, true);
        sv.step(spielfeld);
        initialisiereSpielfeld(10, 40);
        zeichneS(80, 0, false);
        sv.step(spielfeld);
        initialisiereSpielfeld(10, 40);
        zeichneS(80, 0, true);
        sv.step(spielfeld);
        initialisiereSpielfeld(10, 40);
        zeichneZ(0, 0, false);
        sv.step(spielfeld);
        initialisiereSpielfeld(10, 40);
        zeichneZ(0, 0, true);
        sv.step(spielfeld);
        initialisiereSpielfeld(10, 40);
        zeichneZ(80, 0, false);
        sv.step(spielfeld);
        initialisiereSpielfeld(10, 40);
        zeichneZ(80, 0, true);
        sv.step(spielfeld);
        for (int i = 0; i < rot.length; i++) {
            initialisiereSpielfeld(10, 40);
            zeichneJ(0, 0, rot[i]);
            sv.step(spielfeld);
        }
        for (int i = 0; i < rot.length; i++) {
            initialisiereSpielfeld(10, 40);
            zeichneJ(80, 0, rot[i]);
            sv.step(spielfeld);
        }
        for (int i = 0; i < rot.length; i++) {
            initialisiereSpielfeld(10, 40);
            zeichneL(0, 0, rot[i]);
            sv.step(spielfeld);
        }
        for (int i = 0; i < rot.length; i++) {
            initialisiereSpielfeld(10, 40);
            zeichneL(80, 0, rot[i]);
            sv.step(spielfeld);
        }
        */
        for (int i = 0; i < 20; i++) {
            initialisiereSpielfeld(10, 40);
            zufallsStein();
            sv.step(spielfeld);
        }
        sv.start();
    }
}
