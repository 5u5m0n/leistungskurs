package blatt17;

import schisch_visualizer.SchischVisualizer;

import static blatt13.Zufall.*;
import static blatt14.MultiArrays.copy2DCharArray;
import static blatt14.MultiArrays.createEmpty2DCharArray;
import static blatt14.Simulationen.zaehlenVier;

public class Waldentwicklung {
    static char[][] wald = createEmpty2DCharArray(100, 100);
    static SchischVisualizer sv = new SchischVisualizer();

    public static void zeitschritt(double p, double q) {
        char[][] temp = copy2DCharArray(wald);
        for (int i = 0; i < wald.length; i++) {
            for (int j = 0; j < wald[i].length; j++) {
                if ((zufall(1) - zaehlenVier(wald, i, j, 'B', false) * 0.02 ) <= p) {
                    temp[i][j] = 'B';
                } else if (zufall(1) <= q && wald[i][j] == 'B') {
                    temp[i][j] = 'F';
                } else if (wald[i][j] == 'F') {
                    temp[i][j] = ' ';
                    if (i < wald.length - 1) {
                        if (wald[i + 1][j] == 'B') {
                            temp[i + 1][j] = 'F';
                        }
                    }
                    if (i > 0) {
                        if (wald[i - 1][j] == 'B') {
                            temp[i - 1][j] = 'F';
                        }
                    }
                    if (j < wald[i].length - 1) {
                        if (wald[i][j + 1] == 'B') {
                            temp[i][j + 1] = 'F';
                        }
                    }
                    if (j > 0) {
                        if (wald[i][j - 1] == 'B') {
                            temp[i][j - 1] = 'F';
                        }
                    }
                }
            }
        }
        wald = copy2DCharArray(temp);
        sv.step(wald);
    }

    public static void main(String[] args) {
        sv.step(wald);
        for (int i = 0; i < 8000; i++) {
            zeitschritt(0.05, 0.002);
        }
        sv.start();
    }
}
