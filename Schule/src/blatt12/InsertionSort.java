package blatt12;

import static blatt07.ArbeitMitArrays.printArray;

public class InsertionSort {

    /**
     * Sortiert eine gegebene int-Liste von klein nach groß
     * @param arr Liste
     */
    public static void insertionSort(int[] arr) {
        int eingabe;
        int j;
        for (int i = 1; i < arr.length; i++) {
            eingabe = arr[i];
            j = i;
            while (j > 0 && arr[j - 1] > eingabe) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = eingabe;
        }
    }

    public static void main(String[] args) {
        int[] arrSort = new int[] {7, 8, 2, 4, 7, 10};
        printArray(arrSort);
        insertionSort(arrSort);
        printArray(arrSort);
    }
}
