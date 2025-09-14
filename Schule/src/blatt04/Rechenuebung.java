package blatt04;

import  java.util.Scanner;

public class Rechenuebung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Gebe die erste Zahl ein.");
        double x = input.nextDouble();
        System.out.println("Gebe die zweite Zahl ein.");
        double y = input.nextDouble();
        boolean geloest = false;
        while (!geloest) {
            System.out.println("Gebe die Lösung von " + x + " * " + y + " ein.");
            double ergebnis = input.nextDouble();
            if (ergebnis == x*y) {
                geloest = true;
            }
        }
        System.out.println("Gut! die Lösung ist " + x*y + "!");
    }
}
