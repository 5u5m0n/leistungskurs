package blatt13;

import static blatt13.PenAndPaper.*;
import static blatt12.SelectionSort.selectionSort;

public class Risiko {

    static int[] angr = new int[3];
    static int[] def = new int[2];
    static double keine = 0;
    static double eine = 0;
    static double zwei = 0;

    public static void wuerfeln() {
        for (int i = 0; i <= angr.length-1; i++) {
            angr[i] = wuerfel(1, 6);
        }
        for (int i = 0; i <= def.length-1; i++) {
            def[i] = wuerfel(1, 6);
        }
        selectionSort(angr, true);
        selectionSort(def, true);
    }

    public static void figurenVerlieren(int n) {
        for (int i = 0; i < n; i++) {
            wuerfeln();
            int z = 0;
            for (int j = 0; j <= def.length-1; j++) {
                if (angr[j] <= def[j]) {
                    z++;
                }
            }
            switch (z) {
                case 0:
                    keine++;
                    break;
                case 1:
                    eine++;
                    break;
                case 2:
                    zwei++;
                    break;
            }
        }
        keine = keine / n;
        eine = eine / n;
        zwei = zwei / n;
        System.out.println("Der Angreifer verliert...");
        System.out.println("in " + keine*100 + " % der Fälle keine Figur,");
        System.out.println("in " + eine*100 + " % der Fälle eine Figur");
        System.out.println("und in " + zwei*100 + " % der Fälle zwei Figuren.");
    }

    public static void main(String[] args) {
        figurenVerlieren((int) Math.pow(10, 8));
    }
}
