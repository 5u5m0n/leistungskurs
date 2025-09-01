package blatt02;

import java.util.Scanner;

public class Zinssatz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Altes Kapital: ");
        double kapital = input.nextDouble();    //TODO: Deutsche Kommaschreibweise, Negatives Kapital, €-Zeichen
        System.out.print("Zinssatz: ");
        double zinsatz = input.nextDouble();    //TODO: DeUtsche Kommaschreibweise, Negativer Zinssatz, %-Zeichen

        double zinsen = (kapital * zinsatz)/100;
        double neu = kapital + zinsen;

        System.out.printf("\nZinsen: %.2f €\n", zinsen);
        System.out.printf("Neues Kapital: %.2f €", neu);

    }
}
