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
        double[] y= new double[5];
        int[] x = new int[]{-2, -1, 0, 1, 2};
        for (int j = 0; j <= y.length-1; j++) {
            for (int i = 0; i <= koeff.length-1; i++) {
                y[j] += koeff[i] * Math.pow(x[j], i);
            }
            System.out.println("x = " + x[j] + "|y = " + y[j]);
        }

    }
}
