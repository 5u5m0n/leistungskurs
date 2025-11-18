package blatt13;

public class Umgebung {

    /**
     * Findet den Exponenten einer gegeben Zahl, der ihn möglichst nah an die gegebene Grenze bringt
     * @param b 0 < b < 1
     * @param e Grenze
     * @return Exponent, -1 -> Fehler
     */
    public static int findeExponent(double b, double e) {
        if (b > 0 && b < 1) {
            int x = 1;
            double p = b;
            while (p > e) {
                 x++;
                 p = Math.pow(b, x);
            }
            return x;
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
