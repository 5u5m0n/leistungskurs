package blatt03;

import java.util.Scanner;

public class Haendler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double sdPreis = 5;
        double minisdPreis = 8;
        double microsdPreis = 12;
        System.out.println("MENGENRABATT: 15% ab über 15 Artikel!!!");
        System.out.println("Wie viele normale SD-Karten möchtest du Kaufen? (max. 50)");
        int anzSd = input.nextInt();
        if (anzSd < 0) {
            System.out.println("Du kannst keine negative Anzahl von SD-Karten kaufen.");
            System.exit(0);
        } else if (anzSd > 50) {
            anzSd = 50;
            System.out.println("Anzahl der SD-Karten hat das Maximum von 50 überschritten und wurde auf das Maximum gesetzt.");
        }
        System.out.println("Wie viele MiniSD-Karten möchtest du Kaufen? (max. 50)");
        int anzMinisd = input.nextInt();
        if (anzMinisd < 0) {
            System.out.println("Du kannst keine negative Anzahl von MiniSD-Karten kaufen.");
            System.exit(0);
        } else if (anzMinisd > 50) {
            anzMinisd = 50;
            System.out.println("Anzahl der MiniSD-Karten hat das Maximum von 50 überschritten und wurde auf das Maximum gesetzt.");
        }
        System.out.println("Wie viele MicroSD-Karten möchtest du Kaufen? (max. 50)");
        int anzMicrosd = input.nextInt();
        if (anzMicrosd < 0) {
            System.out.println("Du kannst keine negative Anzahl von MicroSD-Karten kaufen.");
            System.exit(0);
        } else if (anzMicrosd > 50) {
            anzMicrosd = 50;
            System.out.println("Anzahl der MicroSD-Karten hat das Maximum von 50 überschritten und wurde auf das Maximum gesetzt.");
        }
        double gesamtpreis = (sdPreis * anzSd) + (minisdPreis * anzMinisd) + (microsdPreis * anzMicrosd);

        System.out.println("Der Preis für...");
        System.out.println(anzSd + " normale SD-Karten");
        System.out.println(anzMinisd + " MiniSD-Karten");
        System.out.println(anzMicrosd + " MicroSD-Karten");
        if (anzSd + anzMinisd + anzMicrosd > 15) {
            System.out.println("...lautet " + gesamtpreis + " € ohne Mengenrabatt");
            System.out.println("...lautet " + (gesamtpreis * 0.85) + " € mit Mengenrabatt");
        }else {
            System.out.println("...lautet " + gesamtpreis + " €");
        }


    }
}
