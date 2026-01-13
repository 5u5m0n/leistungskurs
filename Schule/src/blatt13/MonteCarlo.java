package blatt13;

import static blatt13.Zufall.zufall;

public class MonteCarlo {

    static double x;
    static double y;

    /**
     * Platziert einen Zufällgen Punkt auf das Feld
     * @param a Breite
     * @param b Länge
     */
    public static void zufallsPunkt(int a, int b) {
        x = zufall(0, a);
        y = zufall(0, b);
    }

    /**
     * Gibt die Entfernung des Punktes zu einem gegebenen Punkt zurück
     * @param c x-Koordinate
     * @param d y-Koordinate
     * @return Entfernung
     */
    public static double entfernung(double c, double d) {
        double xv = x - c;
        double yv = y - d;
        double v = Math.sqrt(Math.pow(xv, 2) + Math.pow(yv, 2));
        return v;
    }

    /**
     * Berechnet Pi
     * @param a Breite
     * @param b Länge
     * @param c x-Koordinate
     * @param d y-Koordinate
     * @param n Dürchläufe
     * @return Pi
     */
    public static double monteCarlo(int a, int b, double c, double d, int n) {
        int z = 0;
        for (int i = 0; i <= n; i++) {
            zufallsPunkt(a, b);
            double v = entfernung(c, d);
            if (v <= 0.5) {
                z++;
            }
        }
        return (double) z/n * 4;
    }

    public static void main(String[] args) {
        System.out.println(MonteCarlo.monteCarlo(1, 1, 0.5, 0.5, (int) Math.pow(10, 10)));
    }

    /* c)
    -Der Brunnen hat keine Wand
    -Es regnet durchgehend gleichmäßig auf dem Feld
     */

    /* d)
    Die Simulation ist nur aussagekräftig, wenn die genaue Anzahl der Regentropfen bekannt wäre.
     */
}
