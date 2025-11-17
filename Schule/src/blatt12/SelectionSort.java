package blatt12;

import static blatt07.ArbeitMitArrays.printArray;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            blatt11.BubbleSort.swap(arr, min, i);
            printArray(arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 4, 5, 2, 56, 52, 11, 55};
        selectionSort(arr);
        printArray(arr);
    }
}
