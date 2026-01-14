package blatt15;

import schisch_visualizer.SchischVisualizer;

import static blatt14.MultiArrays.*;
import static blatt13.Zufall.*;
import static blatt14.Simulationen.*;

public class KomplexerKaese {

    static SchischVisualizer sv = new SchischVisualizer();
    static char[][][] kaese;

    public static void initialisiereKaese(double p) {
        if (kaese != null && p >= 0 && p <= 1) {
            for (int i = 0; i < kaese.length; i++) {
                for (int j = 0; j < kaese[i].length; j++) {
                    for (int k = 0; k < kaese[i][j].length; k++) {
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
}
