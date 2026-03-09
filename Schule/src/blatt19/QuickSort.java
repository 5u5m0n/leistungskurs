package blatt19;

import static blatt07.ArbeitMitArrays.printArray;

public class QuickSort {

    public static int[] trennenLinks(int[] arr, int p) {
        int n = 0;
        for (int c : arr) {
            if (c < p) {
                n++;
            }
        }
        int[] links  = new int[n];
        int i = 0;
        for (int c : arr) {
            if (c <= p) {
                links[i] = c;
                i++;
            }
        }
        return links;
    }

    public static int[] trennenRechts(int[] arr, int p) {
        int n = 0;
        boolean v = false;
        for (int c : arr) {
            if (c > p) {
                n++;
            }
            if (c == p) {
                if (v == false) {
                    v = true;
                } else {
                    n++;
                }
            }
        }
        int[] rechts = new int[n];
        int i = 0;
        for (int c : arr) {
            if (c > p) {
                rechts[i] = c;
                i++;
            }
            if (c == p && v == true) {
                rechts[i] = c;
                i++;
                v = false;
            }
        }
        return rechts;
    }

    public static int[] zusammenfuegen(int[] links, int[] rechts, int p) {
        int[] arr = new int[links.length + rechts.length + 1];
        for (int i = 0; i < links.length; i++) {
            arr[i] = links[i];
        }
        arr[links.length] = p;
        for (int i = 0; i < rechts.length; i++) {
            arr[i + links.length + 1] = rechts[i];
        }
        return arr;
    }

    public static int[] quickSort(int[] arr) {
        if (arr.length > 1) {
            int p = arr[0];
            int[] lUnsortiert = trennenLinks(arr, p);
            int[] rUnsortiert = trennenLinks(arr, p);
            int[] lSortiert = quickSort(lUnsortiert);
            int[] rSortiert = quickSort(rUnsortiert);
            int[] arrNew = zusammenfuegen(lSortiert, rSortiert, p);
            return arrNew;
        } else {
            return arr;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] arr2 = new int[] {-12, 6543, -34, 654, 3414, -6542, 0, 12, 7, -5, 143};
        printArray(trennenLinks(arr2, 0));
        printArray(trennenRechts(arr2, 0));
        //printArray(quickSort(arr2));
    }
}
