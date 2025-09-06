package blatt03;

import  java.util.Scanner;

public class PQ {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Gib den Wert von p ein:");  //Wert von p & q erfragen
        double p = input.nextDouble();
        System.out.println("Gib den Wert von q ein:");
        double q = input.nextDouble();
        double wurzel = (p/2 * p/2) - q;
        int anzahlLoesungen;
        if (wurzel < 0) {                               //Anzahl der Lösungen errechnen
            anzahlLoesungen = 0;
        } else if (wurzel == 0) {
            anzahlLoesungen = 1;
        } else {
            anzahlLoesungen = 2;
        }
        System.out.println("Anzahl Lösungen: " + anzahlLoesungen);
        if (anzahlLoesungen == 1) {                     //Alle Lösungen errechnen
            double x = -(p/2);
            System.out.printf("x = %.2f", x);
        } else if (anzahlLoesungen == 2) {
            double x1 = -(p/2) + Math.sqrt(wurzel);
            double x2 = -(p/2) - Math.sqrt(wurzel);
            System.out.printf("x1 = %.2f, x2 = %.2f", x1, x2);
        }
    }
}
