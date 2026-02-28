package blatt18;

public class Ackermann {

    /** Ackerman-Funktion in abhängigkeit von x und y
     * @param x x
     * @param y y
     * @return A(x, y)
     */
    public static int A(int x, int y) {
        if (x == 0) {
            return y + 1;
        } else if (y == 0) {
            return A(x - 1, 1);
        } else {
            return A(x - 1, A(x, y - 1));
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(A(4, 1));
        long end = System.currentTimeMillis();
        long dur = end - start;
        System.out.println(dur + " Millisekunden");
        System.out.println(dur/1000 + " Sekunden");
    }
}
