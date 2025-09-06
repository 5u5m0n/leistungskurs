package blatt03;

import  java.util.Scanner;

public class Notenrechner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Gib die maximale Punktzahl ein:");
        int maximalePunktzahl = input.nextInt();                //Maximale Punktzahl abfragen
        System.out.println("Gib die erreichten Punkte ein:");
        int erreichtePunkte = input.nextInt();                  //Erreichte Punkte abfragen
        if (maximalePunktzahl <= 0 || erreichtePunkte < 0) {    //Wurden fehlerhafte daten eingegebenm?
            System.out.println("Gib keine negativen Punktzahlen oder die maximale Punktzahl 0 ein.");
            System.exit(0);
        }
        double anteil = (double) erreichtePunkte / maximalePunktzahl;
        if (erreichtePunkte >= maximalePunktzahl) {             //Wurde die maximale Punktzahl erreicht? (möglicherweise Zusatzpunkte)
            System.out.println("Maximale Punktzahl erreicht!");
        } else if (anteil >= 0.85) {                            //Note ausrechnen
            System.out.println("Note: 1");                      //Note angeben
        } else if (anteil >= 0.70) {
            System.out.println("Note: 2");
        } else if (anteil >= 0.55) {
            System.out.println("Note: 3");
        } else if (anteil >= 0.39) {
            System.out.println("Note: 4");
        } else if (anteil >= 0.17)  {
            System.out.println("Note: 5");
        } else {
            System.out.println("Note: 6");
        }
        System.out.printf("%.2f %% erreicht.", (anteil*100));   //Erreichte Prozente ausgeben

    }
}
