package blatt09;


public class Teiler {
    /**
     * Überprüft, ob eine natürliche Zahl teiler von einer anderen natürlichen Zahl
     * @param a Natürliche Zahl a
     * @param b Natürliche Zahl b
     * @return Ist b Teiler von a?
     */
    public static boolean istTeiler(int a, int b) {
        return a % b == 0;
    }

    /**
     * Gibt alle Teiler einer gegebenen Zahl aus
     * @param a gegebene Zahl
     */
    public static void alleTeiler(int a) {
        for (int i = 1; i < a; i++) {
            if (istTeiler(a, i)) {
                System.out.print(i + ", ");
            }
        }
        System.out.println(a);
    }

    /**
     * Gibt die Anzahl der Teiler einer gegebenen Zahl zurück
     * @param a gegebene Zahl
     * @return Anzahl Teiler
     */
    public static int anzahlTeiler(int a) {
        int n = 0;
        for (int i = 1; i <= a; i++) {
            if (istTeiler(a, i)) {
                n++;
            }
        }
        return n;
    }

    /**
     * Gibt eine Liste mit allen Teilern einer gegebenen Zahl zurück
     * @param a gegebene Zahl
     * @return Liste mit Teilern
     */
    public static int[] teiler(int a) {
        int[] n = new int[anzahlTeiler(a)];
        int j = 0;
        for (int i = 1; i <= a; i++) {
            if (istTeiler(a, i)) {
                n[j] = i;
                j++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
    }
}
