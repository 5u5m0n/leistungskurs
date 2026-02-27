package blatt17;

import schisch_visualizer.SchischVisualizer;

import static blatt13.Zufall.zufall;
import static blatt14.MultiArrays.*;
import static blatt14.Simulationen.zaehlenAcht;
import static blatt16.Stroeme.*;

public class GameOfLife {
    static char[][] feld = createEmpty2DCharArray(100, 100);
    static SchischVisualizer sv = new SchischVisualizer();

    //1 => lebendig, 0 => tot
    public static void initRandom(double p) {
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                if (zufall(1) <= p) {
                    feld[i][j] = '1';
                } else {
                    feld[i][j] = '0';
                }
            }
        }
        sv.step(feld);
    }

    public static void weiter() {
        char[][] temp = copy2DCharArray(feld);
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                int n = zaehlenAcht(feld, i, j, '1', true);
                if (n == 3 && feld[i][j] == '0') {
                    temp[i][j] = '1';
                } else if (n < 2 || n > 3 && feld[i][j] == '1') {
                    temp[i][j] = '0';
                }
            }
        }
        feld = copy2DCharArray(temp);
        sv.step(feld);
    }

    public static void initOszillierend(int n) {
        char[][] arr = readCharArray("oszillierend0" + n + ".txt");
        zeichnen(arr);
        sv.step(feld);
    }

    public static void initRaumschiff(int n) {
        char[][] arr = readCharArray("raumschiff0" + n + ".txt");
        zeichnen(arr);
        sv.step(feld);
    }

    public static void initChaos(int n) {
        char[][] arr = readCharArray("chaos0" + n + ".txt");
        zeichnen(arr);
        sv.step(feld);
    }

    public static void zeichnen(char[][] arr) {
        int x = (feld.length / 2) - (arr.length / 2);
        int y = (feld[0].length / 2) - (arr[0].length / 2);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                feld[x + i][y + j] = arr[i][j];
            }
        }
    }

    public static void main(String[] args) {
        initRaumschiff(1);
        sv.start();
    }
}
