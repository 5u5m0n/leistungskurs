package blatt18;

public class Summe {

    /**
     * Bildet die Summe der ersten n Zahlen
     * @param n n
     * @return Summe
     */
    public static int summe(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + summe(n-1);
        }
    }
}
