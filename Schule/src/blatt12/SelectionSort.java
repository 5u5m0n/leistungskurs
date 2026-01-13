package blatt12;

import static blatt07.ArbeitMitArrays.printArray;

public class SelectionSort {

    /**
     * Sortiert einen gegebenen int-Array von groß nach klein (max-Sort) oder klein nach groß (min-Sort)
     * @param arr int-Array
     * @param max true: max-Sort, false: min-Sort
     */
    public static void selectionSort(int[] arr, boolean max) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min] == !max) {
                    min = j;
                }
            }
            blatt11.BubbleSort.swap(arr, min, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 4, 5, 2, 56, 52, 11, 55};
        selectionSort(arr, false);
        printArray(arr);
        selectionSort(arr, true);
        printArray(arr);
    }
}
