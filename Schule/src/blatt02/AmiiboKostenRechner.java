package blatt02;

import java.util.Scanner;

public class AmiiboKostenRechner {
    public static void main(String[] args) {
        System.out.println("Wie viele Amiibo-Figuren möchtest du kaufen?");
        Scanner input = new Scanner(System.in);
        int anzahl = input.nextInt();   //TODO: Negative Anzahlen verhindern.
        double preis = 15;
        System.out.println("Der Preis dafür beträgt " + (anzahl * preis) + " €.");

    }
}
