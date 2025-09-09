package blatt04;

 import java.util.Random;
import java.util.Scanner;

public class ETF {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner input = new Scanner(System.in);
        double sparbetrag = 50;
        double wert = 3578.89;
        double kontostand = 0;
        double anteil;
        double zinssatz;
        int monat = 1;
        int jahr = 1;
        System.out.println("Wie viele Jahre lang möchtest du sparen?");
        int anzahlJahre = input.nextInt();

        while (jahr <= anzahlJahre) {
            System.out.println("--------------------------------------------------");
            System.out.println("Wie viel möchtest du dieses Jahr pro Monat sparen?");
            sparbetrag = input.nextDouble();
            while (monat <= 12) {
                zinssatz = ((rnd.nextDouble() + 1) * 6) / 100;
                kontostand = (kontostand + sparbetrag) * (zinssatz + 1);
                anteil = kontostand / wert;
                System.out.println("--------------------------------------------------");
                System.out.println("Jahr: " + jahr);
                System.out.println("Monat: " + monat);
                System.out.printf("Sparbetrag diesen Monat: %.2f €\n", sparbetrag);
                System.out.printf("Zinssatz: %.2f %%\n", zinssatz * 100);
                System.out.printf("Kontostand: %.2f €\n", kontostand);
                System.out.printf("MSCI-Anteil: %.5f %%\n", anteil);
                monat++;
            }
            monat = 1;
            jahr++;
        }

    }
}
