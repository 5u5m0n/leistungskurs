package blatt14;

import static blatt13.Zufall.zufall;
import static blatt13.Zufall.zufallGanz;
import static blatt07.ArbeitMitArrays.shiftLeft;

public class MultiArrays {
    /**
     * Gibt einen Zweidimensionalen Array aus.
     * @param array Ganzzahl-Array
     */
    public static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (j != array[i].length - 1) {
                    System.out.print("|");
                } else {
                    System.out.println("]");
                }
            }
        }
    }

    /**
     * Gibt einen Zweidimensionalen Array aus.
     * @param array Gleitkommazahl-Array
     */
    public static void print2DArray(double[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (j != array[i].length - 1) {
                    System.out.print("|");
                } else {
                    System.out.println("]");
                }
            }
        }
    }

    /**
     * Gibt einen Zweidimensionalen Array aus.
     * @param array Zeichen-Array
     */
    public static void print2DArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (j != array[i].length - 1) {
                    System.out.print("|");
                } else {
                    System.out.println("]");
                }
            }
        }
    }

    /**
     * Gibt einen zufälligen 2D-Ganzzahl-Array zurück
     * @param a Array-Länge
     * @param b innere Array-Länge
     * @param p Zahlenuntergrenze
     * @param q Zahlenobergrenze
     * @return 2D-Ganzzahl-Array
     */
    public static int[][] createRandom2DIntArray(int a, int b, int p, int q) {
        int[][] arr = new int[a][b];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = zufallGanz(p, q);
            }
        }
        return arr;
    }

    /**
     * Gibt einen zufälligen 2D-Gleitkommazahl-Array mit Werten zwischen 0 und 1 zurück
     * @param a Array-Länge
     * @param b innere Array-Länge
     * @return 2D-Gleitkommazahl-Array
     */
    public static double[][] createRandom2DDoubleArray(int a, int b) {
        double[][] arr = new double[a][b];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = zufall(1);
            }
        }
        return arr;
    }

    /**
     * Gibt einen 2D-Ganzzahl-Array zurück, welcher bei jeder Stelle Zählt
     * @param a Array-Länge
     * @param b innere Array-Länge
     * @return 2D-Ganzzahl-Array
     */
    public static int[][] createCountingArray(int a, int b) {
        int[][] arr = new int[a][b];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = k;
                k++;
            }
        }
        return arr;
    }

    /**
     * Gibt einen 2D-Zeichen-Array zurück, welcher nur ' ' enthält
     * @param a Array-Länge
     * @param b innere Array-Länge
     * @return 2D-Zeichen-Array
     */
    public static char[][] createEmpty2DCharArray(int a, int b) {
        char[][] arr = new char[a][b];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ' ';
            }
        }
        return arr;
    }

    /**
     * Überprüft, ob zwei 2D-Zeiche-Arrays identisch sind.
     * @param a Array a
     * @param b Array b
     * @return bool
     */
    public static boolean istIdentisch(char[][] a, char[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Verschiebt eine Reihe eines gegebenen 2D-Ganzzahl-Arrays úm einen Wert
     * @param arr Array
     * @param index Reihe
     * @param wert Wert
     */
    public static void shiftRows(int[][] arr, int index, int wert) {
        for (int i = 0; i < Math.abs(wert); i++) {
            shiftLeft(arr[index]);
        }
    }

    public static void main(String[] args) {
        int[][] arr = createCountingArray(4, 5);
        print2DArray(arr);
        shiftRows(arr, 2, 3);
        System.out.println("");
        print2DArray(arr);
    }
}
