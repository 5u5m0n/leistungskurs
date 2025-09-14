package blatt04;

import  java.util.Scanner;

public class Zeitumrechner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Gebe eine positive Zahl an Sekunden ein:");
        int sekunden = input.nextInt();
        int minuten = 0;
        int stunden = 0;
        int tage = 0;
        //int zaehler = 0;

        while (sekunden >= 60) {
            minuten += 1;
            sekunden -= 60;
            //zaehler++;
        }
        while (minuten >= 60) {
            stunden += 1;
            minuten -= 60;
            //zaehler++;
        }
        while (stunden >= 24) {
            tage += 1;
            stunden -= 24;
            //zaehler++;
      }
        //b) 151638
        /*c)
        minuten = sekunden/60;
        sekunden = sekunden%60;
        stunden = minuten/60;
        minuten = minuten%60;
        tage = stunden/24;
        stunden = stunden%24;
        6 Rechenoperationen
        */
        System.out.printf("%d Tage, %d Stunden, %d Minuten, %d Sekunden", tage, stunden, minuten, sekunden);

    }
}
