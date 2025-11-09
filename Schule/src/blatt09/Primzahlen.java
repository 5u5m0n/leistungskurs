package blatt09;

import java.util.Arrays;

public class Primzahlen {

    /**
     * Überprüft, ob eine gegebene Zahl eine Primzahl ist
     * @param a gegebene Zahl
     * @return bool
     */
    public static boolean istPrim(int a) {
        if (a <= 1) {
            return false;
        } else if (a == 2) {
            return true;
        }
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Gibt alle Primzahlen aus, die unter einer gegebenen Grenze liegen
     * @param a gegebene Grenze
     */
    public static void printPrim(int a) {
        for (int i = 2; i <= a; i++) {
            if (istPrim(i)) {
                System.out.print(i + "; ");
            }
        }
        System.out.println("");
    }

    /**
     * Generiert ein Array mit den ersten n Primzahlen und gibt es zurück
     * @param n n
     * @return Array
     */
    public static int[] generierePrimzahlen(int n) {
        int[] a = new int[n];
        int i = 2;
        int k = 0;
        while (a[n - 1] == 0) {
            if (istPrim(i)) {
                a[k] = i;
                k++;
            }
            i++;
        }
        return a;
    }

    /**
     * Gibt die Prinfaktorzerlegung einer gegebenen Zahl aus
     * @param a gegebene Zahl
     */
    public static void primfaktorzerlegung(int a) {
        if (a == 1) {
            System.out.println("-");
            return;
        }
        System.out.print(a + " = ");
        int[] primzahlen = generierePrimzahlen(a / 2);
        int rest = a;
        for (int i = 0; i < primzahlen.length; i++) {
            if (istPrim(rest)) {
                System.out.println(rest);
                break;
            } else if (rest % primzahlen[i] == 0) {
                System.out.print(primzahlen[i] + " * ");
                rest /= primzahlen[i];
                i = -1;
            }
        }
    }

    public static void main(String[] args) {
        primfaktorzerlegung(1);
    }
}
