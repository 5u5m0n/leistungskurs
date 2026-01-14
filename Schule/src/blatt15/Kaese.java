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
        kaeseB = copy2DCharArray(kaese);
        for (int i = 0; i < kaese.length; i++) {
            for (int j = 0; j < kaese[i].length; j++) {
                if (kaese[i][j] == '2' && getSueden(kaese, i, j, false) == ' ') {
                    kaeseB[i][j + 1] = '2';
                }
                if (kaese[i][j] == '2' && getOsten(kaese, i, j, false) == ' ') {
                    kaeseB[i + 1][j] = '2';
                }
                if (kaese[i][j] == '2' && getWesten(kaese, i, j, false) == ' ') {
                    kaeseB[i - 1][j] = '2';
                }
                if (kaese[i][j] == '2' && getNorden(kaese, i, j, false) == ' ') {
                    kaeseB[i][j-1] = '2';
                }
            }

        }
        if (istIdentisch(kaese, kaeseB)) {
            laeuft = false;
        } else {
            kaese = copy2DCharArray(kaeseB);
        }

        sv.step(kaese);
    }

    public static void simulation(int a, int b, double p) {
        initialisiereKaese(a, b, p);
        initialisiereWasser();
        while (laeuft) {
            gravitation();
        }
        for (int i = 0; i < kaese.length; i++) {
            if (kaese[i][kaese[i].length - 1] == '2') {
                undicht = true;
            }
        }
        System.out.println("Undicht: " + undicht);

    }

    public static void main(String[] args) {
        simulation(500, 250, 0.4);
        sv.start();
    }
}
