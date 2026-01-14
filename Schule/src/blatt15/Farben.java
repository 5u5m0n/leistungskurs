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
            boolean c = false;
            char[] f = new char[]{'7', '7', '7', '7', '9', '9', '9', '9'};
            for (int i = 0; i < spielfeld.length; i++) {
                for (int j = 0; j < spielfeld[i].length; j++) {
                    if (spielfeld[i][j] == f[spielernummer]) {
                        c = true;
                    }
                }
            }
            while (true && c) {
                spielerPosX[spielernummer] = zufallGanz(1, spielfeld.length-2);
                spielerPosY[spielernummer] = zufallGanz(1, spielfeld[0].length-2);
                if (spielfeld [spielerPosX[spielernummer]][spielerPosY[spielernummer]] == f[spielernummer]) {
                    spielfeld [spielerPosX[spielernummer]][spielerPosY[spielernummer]] = 'P';
                    break;
                }
            }
            while (!c) {
                spielerPosX[spielernummer] = zufallGanz(1, spielfeld.length-2);
                spielerPosY[spielernummer] = zufallGanz(1, spielfeld[0].length-2);
                if (spielfeld [spielerPosX[spielernummer]][spielerPosY[spielernummer]] != 'P') {
                    spielfeld [spielerPosX[spielernummer]][spielerPosY[spielernummer]] = 'P';
                    c = true;
                }
            }

        }
    }

    public static void main(String[] args) {
        initialisiereSpielfeld(80, 80);
        startPositionen();
        sv.start();
    }
}
