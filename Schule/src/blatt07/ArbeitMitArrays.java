package blatt07;



public class ArbeitMitArrays {

    public static void printArray(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1) {
                System.out.print("|");
            } else {
                System.out.print("]");
            }
        }
    }

    public static void printArray(double[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1) {
                System.out.print("|");
            } else {
                System.out.print("]");
            }
        }
    }

    public static void printArray(boolean[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1) {
                System.out.print("|");
            } else {
                System.out.print("]");
            }
        }
    }

    public static void printArray(char[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1) {
                System.out.print("|");
            } else {
                System.out.print("]");
            }
        }
    }

    public static void printArray(String[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1) {
                System.out.print("|");
            } else {
                System.out.print("]");
            }
        }
    }

    /**
     * Überprüft, ob ein int-array von klein nach groß sortiert ist.
     * @param a Array
     * @return boolean
     */
    public static boolean istSortiert(int[] a) {
        boolean boool = true;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                boool = false;
            }
        }
        return boool;
    }
    public static int[] addieren(int[] a, int[] b) {
        int len;
        if (a.length >= b.length) {
            len = a.length;
        } else {
            len = b.length;
        }
        int[] c = new int[len];
        for (int i = 0; i < len; i++) {
            if (i < a.length && i < b.length) {}
            c[i] = a[i] + b[i];
        }
        return c;
    }

    public static void main(String args[]) {
        int[] a = new int[]{1, 2, 3, 4, 5, -6, 7, 8, 9, 10};
        printArray(a);
    }
}
