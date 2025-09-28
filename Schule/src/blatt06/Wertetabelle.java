package blatt06;

import java.util.Scanner;

public class Wertetabelle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geben Sie den Grad des Polynoms ein:");
        int grad = input.nextInt();

        double[] koeff = new double[grad+1];
        for (int i = 0; i <= koeff.length-1; i++) {
            System.out.println("Geben Sie den Koeffizienten von x ^ " + i + " ein:");
            koeff[i] = input.nextDouble();
        }

        System.out.println("Geben Sie eine Ober- un Untergrenze ein:");
        int u = input.nextInt();
        int o = input.nextInt();
        if (u > o) {
            int h = u;
            u = o;
            o = h;
        }
        int diff = o - u + 1;

        System.out.println("Geben Sie eine Schrittweite ein: ");
        double schrittweite = input.nextDouble();
        int length = (int) ((int) diff / schrittweite);

        double[] x = new double[length];
        for (int i = 0; i < length; i++) {
            x[i] = u + i * schrittweite;
        }

        double[] y= new double[length];
        for (int j = 0; j <= y.length-1; j++) {
            if (!(x[j] > o)) {
                for (int i = 0; i <= koeff.length-1; i++) {
                    y[j] += koeff[i] * Math.pow(x[j], i);
                }
                System.out.printf("x = %.2f|y = %.2f\n", x[j], y[j]);
            }

        }

    }
}
