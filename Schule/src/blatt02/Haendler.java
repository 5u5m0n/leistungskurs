package blatt02;

import java.util.Scanner;

public class Haendler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double sdPreis = 5;
        double minisdPreis = 8;
        double microsdPreis = 12;
        System.out.println("Wie viele normale SD-Karten möchtest du Kaufen?");
        int anzSd = input.nextInt();        //TODO: Negative Anzahl
        System.out.println("Wie viele MiniSD-Karten möchtest du Kaufen?");
        int anzMinisd = input.nextInt();    //TODO: Negative Anzahl
        System.out.println("Wie viele MicroSD-Karten möchtest du Kaufen?");
        int anzMicrosd = input.nextInt();   //TODO: Negative Anzahl
        double gesamtpreis = (sdPreis * anzSd) + (minisdPreis * anzMinisd) + (microsdPreis * anzMicrosd);
        System.out.println("Der Preis für...");
        System.out.println(anzSd + " normale SD-Karten");
        System.out.println(anzMinisd + " MiniSD-Karten");
        System.out.println(anzMicrosd + " MicroSD-Karten");
        System.out.println("...lautet " + gesamtpreis + " €");

    }
}
