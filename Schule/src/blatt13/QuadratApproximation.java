package blatt13;

public class QuadratApproximation {

    /**
     * Berechnet die Fläche des Quadrates mit der gegebenen Seitenlänge
     * @param a Seitenlänge
     * @return Fläche
     */
    public static int flaecheQuadrat(int a) {
        return a * a;
    }

    /**
     * Gibt eine Approximation der Seitenlänge eines gegebenen Quadrates zurück
     * @param a Fläche des Quadrates
     * @return Approximation der Seitenlänge
     */
    public static double sucheSeitenlaenge(int a) {
        double l = 1;
        double r = a;
        double x = (l+r)/2;
        while (Math.abs(a - x * x) > 0.00001) {
            if (x * x > a) {
                r = x;
            } else {
                l = x;
            }
            x = (l+r)/2;
        }
        return x;
    }

    public static void main(String[] args) {
    }
}
