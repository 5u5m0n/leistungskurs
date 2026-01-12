package blatt13;

import static blatt07.ArbeitMitArrays.printArray;

public class Zufall {

    /**
     * Gibt eine Zufallszahl zwischen 0 und b zurück
     * @param b b
     * @return Zahl
     */
    public static double zufall(int b) {
        return Math.random() * b;
    }

    /**
     * Gibt eine zufällige Ganzzahl zwischen 0 und b zurück
     * @param b b
     * @return Zahl
     */
    public static int zufallGanz(int b) {
        return (int) Math.random() * (b+1);
    }

    /**
     * Gibt eine Zahl zwischen a und b zurück
     * @param a a
     * @param b b
     * @return Zahl
     */
    public static double zufall(int a, int b) {
        return Math.random() * Math.abs(b-a) + a;
    }

    /**
     * Gibt eine zufällige Ganzzahl zwischen a und b zurück
     * @param a a
     * @param b b
     * @return Zahl
     */
    public static int zufallGanz(int a, int b) {
        return (int) (Math.random() * (Math.abs(b-a) + 1)) + a;
    }

    /**
     * Gibt einen Ganzzahl-Array der länge l, bestehend aus zufälligen Ganzzahlen zwischen a und b, zurück
     * @param l l
     * @param a a
     * @param b b
     * @return Zahl
     */
    public static int[] zufallArray(int l, int a, int b) {
        int[] arr = new int[l];
        for (int i = 0; i < l; i++) {
            arr[i] = zufallGanz(a, b);
        }
        return arr;
    }

    public static void main(String[] args) {
        printArray(zufallArray((int) Math.pow(10, 8), 1, 3));
    }
}
