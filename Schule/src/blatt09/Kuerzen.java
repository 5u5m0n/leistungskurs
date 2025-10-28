package blatt09;

import static blatt09.Teiler.istTeiler;

public class Kuerzen {

    /**
     * Überprüft, ob ein gegebener Bruch kürzbar ist
     * @param a Zähler
     * @param b Nenner
     * @return Ist der Bruch kürzbar?
     */
    public static boolean istKuerzbar(int a, int b) {
        for (int i = a; i >= 2; i--) {
            if (istTeiler(a, i) && istTeiler(b, i)) {
                return true;
            }
        }
        return false;
    }

    public static void kuerzen(int a, int b) {
        if (istKuerzbar(a, b)) {

        } else {
            System.out.println(a + "/" + b);
        }
    }

    public static void main(String[] args) {
        System.out.println(istKuerzbar(7, 3));
        System.out.println(istKuerzbar(2, 8));
    }
}
