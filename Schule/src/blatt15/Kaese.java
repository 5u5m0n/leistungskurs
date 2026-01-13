package blatt15;

import schisch_visualizer.SchischVisualizer;

import static blatt14.MultiArrays.*;
import static blatt13.Zufall.*;
import static blatt14.Simulationen.*;

public class Kaese {

    static char[][] kaese;
    static SchischVisualizer sv = new SchischVisualizer();
    static boolean undicht = false;
    static boolean laeuft = true;
    static char[][] kaeseB;
    static boolean change = false;

    public static void initialisiereKaese(int a, int b, double p) {
        kaese = createEmpty2DCharArray(a, b);
        if (kaese != null && p >= 0 && p <= 1) {
            for (int i = 0; i < kaese.length; i++) {
                for (int j = 0; j < kaese[i].length; j++) {
                    if (kaese[i][j] == ' ' && zufall(1) <= p) {
                        kaese[i][j] = '5';
                    }
                }
            }
        }
        sv.step(kaese);
    }

    public static void initialisiereWasser() {
        for (int i = 0; i < kaese.length; i++) {
            if (kaese[i][0] == ' ') {
                kaese[i][0] = '2';
            }
        }
        sv.step(kaese);
    }

    public static void gravitation() {
        kaeseB = createEmpty2DCharArray(kaese.length, kaese[0].length);
        change = false;
        for (int i = 0; i < kaese.length; i++) {
            for (int j = 0; j < kaese[i].length; j++) {
                if (kaese[i][j] == '2' && getSueden(kaese, i, j, false) == ' ') {
                    kaeseB[i][j + 1] = '2';
                    change = true;
                }
                if (kaese[i][j] == '2' && getOsten(kaese, i, j, false) == ' ') {
                    kaeseB[i + 1][j] = '2';
                    change = true;
                }
                if (kaese[i][j] == '2' && getWesten(kaese, i, j, false) == ' ') {
                    kaeseB[i - 1][j] = '2';
                    change = true;
                }
            }
            for (int j = 0; j < kaese[kaese.length - 1].length; j++) {
                if (kaese[kaese.length - 1][j] == '2') {
                    laeuft = false;
                    undicht = true;
                }
            }
        }
        for (int i = 0; i < kaese.length; i++) {
            for (int j = 0; j < kaese[i].length; j++) {
                if (kaeseB[i][j] == '2') {
                    kaese[i][j] = kaeseB[i][j];
                }
            }
        }
        if (!change) {
            laeuft = false;
        }
        sv.step(kaese);
    }

    public static void simulation() {
        initialisiereKaese(20, 20, 0.6);
        initialisiereWasser();
        while (laeuft) {
            gravitation();
        }
        System.out.println("Undicht: " + undicht);

    }

    public static void main(String[] args) {
        simulation();
        sv.start();
    }
}
