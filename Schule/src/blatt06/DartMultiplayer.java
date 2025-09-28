package blatt06;

import java.util.Scanner;


public class DartMultiplayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Erzeuge Scanner
        System.out.println("Anzahl der Spieler: ");
        int anzahl = scanner.nextInt();
        int[] punkte = new int[anzahl];
        for (int i = 0; i < anzahl; i++) {
            punkte[i] = 501;
        }
        int wurf = 0;
        int wuerfe = 0;
        boolean gewonnen = false;

        while (true) {
            for (int i = 0; i < punkte.length; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.println("Spieler " + (i+1) + "(Punkte: " + punkte[i] + ") gib die Punktzahl deines " + (j + 1) + ". Wurfes ein. (0-60)");
                    wurf = scanner.nextInt();
                    if (wurf <= 60 && wurf >= 0) {
                        wuerfe += wurf;
                    } else {
                        j--;
                    }
                }


                if (wuerfe == punkte[i]) {
                    System.out.println("Spieler " + (i+1) + " hat Gewonnen");
                    punkte[i] = 0;
                    gewonnen = true;
                    break;
                } else if (wuerfe > punkte[i]) {
                    System.out.println("Spieler " + (i+1) + " hat Punktzahl von " + punkte[i] + " Punkten wurde überschritten.");
                } else {
                    punkte[i] -= wurf;
                    System.out.println("Spieler " + (i+1) + ": " + punkte[i]);
                }
                wuerfe = 0;
            }
            if (gewonnen) {
                break;
            }
        }
        for (int i = 0; i < punkte.length; i++) {
            System.out.println("Spieler " + (i+1) + ": " + punkte[i]);
        }


    }

}