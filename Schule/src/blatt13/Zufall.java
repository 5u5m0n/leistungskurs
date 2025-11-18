package blatt13;

import static blatt07.ArbeitMitArrays.printArray;

public class Zufall {

    public static double zufall(int b) {
        return Math.random() * b;
    }

    public static int zufallGanz(int b) {
        return (int) Math.round(Math.random() * b);
    }

    public static double zufall(int a, int b) {
        return Math.random() * Math.abs(b-a) + a;
    }

    public static int zufallGanz(int a, int b) {
        return (int) Math.round(Math.random() * Math.abs(b-a) + a);
    }

    public static int[] zufallArray(int l, int a, int b) {
        int[] arr = new int[l];
        for (int i = 0; i < l; i++) {
            arr[i] = zufallGanz(a, b);
        }
        return arr;
    }

    public static void main(String[] args) {
        printArray(zufallArray((int) Math.pow(10, 9), 1, 3));
    }
}
