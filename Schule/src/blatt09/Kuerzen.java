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

    /**
     * Gibt einen gegebenen Bruch vollständig gekürzt aus
     * @param a Zähler
     * @param b Nenner
     */
    public static void kuerzen(int a, int b) {
        if (istKuerzbar(a, b)) {
            for (int i = a; i >= 2; i--) {
                if (istTeiler(a, i) && istTeiler(b, i)) {
                    System.out.println((a/i) + "/" + (b/i));
                    break;
                }
            }
        } else {
            System.out.println(a + "/" + b);
        }
    }

    public static void main(String[] args) {
    }
}
