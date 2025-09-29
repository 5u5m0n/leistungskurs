package blatt07;

public class Rechner {
    /**
     * Addiert zwei Gleitkommazahlen.
     * @param a Zahl 1
     * @param b Zahl 2
     * @return Zahl 1 + Zahl 2
     */
    public static double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtrahiert zwei Gleitkommazahlen.
     * @param a Zahl 1
     * @param b Zahl 2
     * @return Zahl 1 - Zahl 2
     */
    public static double sub(double a, double b) {
        return a - b;
    }

    /**
     * Multipliziert zwei Gleitkommazahlen.
     * @param a Zahl 1
     * @param b Zahl 2
     * @return Zahl 1 * Zahl 2
     */
    public static double mult(double a, double b) {
        return a * b;
    }

    /**
     * Dividiert zwei Gleitkommazahlen.
     * @param a Zahl 1
     * @param b Zahl 2
     * @return Zahl 1 / Zahl 2
     */
    public static double div(double a, double b) {
        return a / b;
    }

    /**
     * Addiert, Subtrahiert, Multipliziert und Dividiert zwei Gleitkommazahlen umd gibt sie aus.
     * @param a
     * @param b
     */
    public static void operation(double a, double b) {
        System.out.println(add(a, b));
        System.out.println(sub(a, b));
        System.out.println(mult(a, b));
        System.out.println(div(a, b));
    }

    public static  void main(String args[]) {
        operation(1.0, 2.0);
    }
}
