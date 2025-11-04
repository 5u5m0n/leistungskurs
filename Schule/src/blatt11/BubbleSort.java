package blatt11;

import static blatt07.ArbeitMitArrays.istSortiert;
import static blatt07.ArbeitMitArrays.printArray;

public class BubbleSort {

    /**
     * Tauscht zwei Elemente in einem integer-Array aus
     * @param arr integer-Array
     * @param i Element a
     * @param j Element b
     */
    public static void swap(int[] arr, int i, int j) {
        int h = arr[i];
        arr[i] = arr[j];
        arr[j] = h;
    }

    /**
     * Sortiert einen integer-Array von klein nach groß
     * @param arr integer-Array
     * @return sortierter Array
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 3, -6, 0, -32, 3, 6, 67};
        bubbleSort(arr);
        printArray(arr);
        System.out.println(istSortiert(arr));
    }

    /* d)
        O(n * (n - 1)) = O(n^2)
     */

    /* e)
        Durchschnittlich ist die Durchlaufzeit n * 2n und daher langsamer. Auch wenn es im Best-Case den Aufwand reduziert lohnt es sich insgesamt nicht.
     */
}
