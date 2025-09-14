package blatt04;

import java.util.Scanner;

public class Potenzierung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Bitte geben Sie eine Basis ein:");
        double basis = input.nextDouble();
        System.out.println("Bitte geben Sie einen Exponenten ein:");
        int exponent = input.nextInt();
        double wert = 1;                //Wert-Variable wird definiert (ist der exponent 0, bleibt der wert immer gleich
        int durchfuehrungen = exponent;
        while (durchfuehrungen > 0) {   //ist der exponent positiv?
            wert *= basis;
            durchfuehrungen--;
        }
        while (durchfuehrungen < 0) {   //ist der exponent negativ?
            wert *= 1/basis;
            durchfuehrungen++;
        }
        System.out.printf("%.2f^%d=%.2f", basis, exponent, wert);
    }
}
