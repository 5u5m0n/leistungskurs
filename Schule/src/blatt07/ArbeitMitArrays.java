package blatt07;



public class ArbeitMitArrays {

    /**
     * Druckt einen Array aus.
     * @param a Array
     */
    public static void printArray(int[] a) {
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1) {
                System.out.print(" | ");
            } else {
                System.out.println(" ]");
            }
        }
    }

    /**
     * Druckt einen Array aus.
     * @param a Array
     */
    public static void printArray(byte[] a) {
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1) {
                System.out.print(" | ");
            } else {
                System.out.println(" ]");
            }
        }
    }

    /**
     * Druckt einen Array aus.
     * @param a Array
     */
    public static void printArray(double[] a) {
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1) {
                System.out.print(" | ");
            } else {
                System.out.println(" ]");
            }
        }
    }

    /**
     * Druckt einen Array aus.
     * @param a Array
     */
    public static void printArray(boolean[] a) {
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1) {
                System.out.print(" | ");
            } else {
                System.out.println(" ]");
            }
        }
    }

    /**
     * Druckt einen Array aus.
     * @param a Array
     */
    public static void printArray(char[] a) {
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1) {
                System.out.print(" | ");
            } else {
                System.out.println(" ]");
            }
        }
    }

    /**
     * Druckt einen Array aus.
     * @param a Array
     */
    public static void printArray(String[] a) {
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1) {
                System.out.print(" | ");
            } else {
                System.out.println(" ]");
            }
        }
    }

    /**
     * Überprüft, ob ein int-array von klein nach groß sortiert ist.
     * @param a Array
     * @return boolean
     */
    public static boolean istSortiert(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Addiert zwei integer-Arrays
     * @param a integer-Array 1
     * @param b integer-Array 2
     * @return Ergebnis integer-Array
     */
    public static int[] addieren(int[] a, int[] b) {
        int len = a.length;
        if (b.length >= a.length) {
            len = b.length;
        }
        int[] c = new int[len];
        for (int i = 0; i < len; i++) {
            if (i < a.length && i < b.length) {
                c[i] = a[i] + b[i];
            } else if (i >= a.length) {
                c[i] = b[i];
            } else if (i >= b.length) {
                c[i] = a[i];
            }
        }
        return c;
    }

    /**
     * Verschiebt ein Ganzzahl-Array um eine Stelle nach links
     * @param a Array
     */
    public static void shiftLeft(int[] a) {
        int first = a[0];
        for (int i = 0; i < a.length - 1; i++) {
            a[i] = a[i+1];
        }
        a[a.length - 1] = first;
    }

    /**
     * Verschiebt ein Ganzzahl-Array um eine Stelle nach rechts
     * @param a Array
     */
    public static void shiftRight(int[] a) {
        int last = a[a.length - 1];
        for (int i = a.length - 1; i > 0; i--) {
            a[i] = a[i-1];
        }
        a[0] = last;
    }

    /**
     * Verschiebt ein Ganzzahl-Array um eine Stelle nach links. Die Herausgeschobene Zahl wird durch 0 ersetzt.
     * @param a Array
     */
    public static void shiftLeftAbsolute(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            a[i] = a[i+1];
        }
        a[a.length - 1] = 0;
    }

    /**
     * Verschiebt ein Ganzzahl-Array um eine Stelle nach rechts. Die Herausgeschobene Zahl wird durch 0 ersetzt.
     * @param a Array
     */
    public static void shiftRightAbsolute(int[] a) {
        int last = a[a.length - 1];
        for (int i = a.length - 1; i > 0; i--) {
            a[i] = a[i-1];
        }
        a[0] = 0;
    }

    public static void main(String args[]) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        printArray(a);
        shiftLeft(a);
        printArray(a);
    }
}
