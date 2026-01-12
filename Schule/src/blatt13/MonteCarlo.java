package blatt13;

import static blatt13.Zufall.zufall;

public class MonteCarlo {

    static double x;
    static double y;

    public static void zufallsPunkt(int a, int b) {
        x = zufall(a, b);
        y = zufall(a, b);
    }

    public static double entfernung(int c, int d) { // TODO: Punktedifferenz
        double xv = 0;
        double yv = 0;
        double v = Math.sqrt(Math.pow(xv, 2) + Math.pow(yv, 2));
        return v;
    }

    public static double monteCarlo(int a, int b, int c, int d, int n) {
        int z = 0;
        for (int i = 0; i <= n; i++) {
            zufallsPunkt(a, b);
            double v = entfernung(c, d);
            if (v <= 1) {
                z++;
            }
        }
        return (z/n) * 4;
    }

    public static void main(String[] args) {
        System.out.println(MonteCarlo.monteCarlo(0, 1, 5, 6, 7));
    }

}
