package blatt06;

import java.util.Scanner;

public class NotenlisteMitArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Anzahl der Schüler:");
        int anzahl = input.nextInt();
        int[] noten = new int[anzahl];
        for (int i = 0; i <= noten.length - 1; i++) {
            System.out.println((i + 1) + ". Note eingeben:");
            noten[i] = input.nextInt();
        }

        for (int i = 0; i <= noten.length - 1; i++) {
            System.out.println("Note " + (i + 1) + ": " + noten[i]);
        }
        System.out.println();
        for (int i = anzahl - 1; i >= 0; i--) {
            System.out.println("Note " + (i + 1) + ": " + noten[i]);
        }
        double durchschnitt = 0;
        for (int i = 0; i <= noten.length - 1; i++) {
            durchschnitt += noten[i];
        }
        durchschnitt /= noten.length;
        System.out.println("Durchschnitt: " + durchschnitt);
    }
}
