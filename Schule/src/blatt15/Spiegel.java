package blatt15;

import schisch_visualizer.SchischVisualizer;

import static blatt13.Zufall.*;
import static blatt14.MultiArrays.*;
import static blatt14.Simulationen.*;

public class Spiegel {

    public static void zufallSpiegel(char[][] spiegel, double p, int a) {
        spiegel = createEmpty2DCharArray(a, a);
        for (int i = 1; i < spiegel.length - 1; i++) {
            for (int j = 1; j < spiegel[i].length - 1; j++) {
                if (zufall(1) <= p && getNorden(spiegel, i, j, false) != '/' && getNorden(spiegel, i, j, false) != '\\' && getSueden(spiegel, i, j, false) != '/' && getSueden(spiegel, i, j, false) != '\\' && getWesten(spiegel, i, j, false) != '/' && getWesten(spiegel, i, j, false) != '\\' && getOsten(spiegel, i, j, false) != '/' && getOsten(spiegel, i, j, false) != '\\') {
                    if (zufall(1) > 0.5) {
                        spiegel[i][j] = '/';
                    } else {
                        spiegel[i][j] = '\\';
                    }
                }
            }
        }
    }

    public static void zufallZiele(char[][] spiegel, double p) {
        for (int i = 1; i < spiegel.length - 1; i++) {
            for (int j = 1; j < spiegel[i].length - 1; j++) {
                if (zufall(1) <= p && getNorden(spiegel, i, j, false) != 'O' && getSueden(spiegel, i, j, false) != 'O' && getWesten(spiegel, i, j, false) != 'O' && getOsten(spiegel, i, j, false) != 'O') {
                    spiegel[i][j] = 'O';
                }
            }
        }
    }

    public static void generierePfeil(char[][] spiegel) {
        spiegel[0][spiegel.length / 2] = '>';
    }

    public static void spiegelSimulation(int n, double q, int abs) {
        char[][] spiegel = createEmpty2DCharArray(40, 40);
        SchischVisualizer sv = new SchischVisualizer();
        zufallSpiegel(spiegel, 0.3, 40);
        sv.step(spiegel);
        zufallZiele(spiegel, 0.1);
        sv.step(spiegel);
        generierePfeil(spiegel);
        sv.step(spiegel);
        sv.start();
    }

    public static void main(String[] args) {
        spiegelSimulation(100, 0.5, 4);
    }

}
