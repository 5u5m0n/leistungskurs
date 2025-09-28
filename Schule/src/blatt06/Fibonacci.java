package blatt06;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geben Sie die erwünschte Länge ein:");
        int n = input.nextInt();
        int[] fibonacci = new int[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        System.out.println(fibonacci[0] + "\n" + fibonacci[1]);
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            System.out.println(fibonacci[i]);
        }
        double quotient = (double) fibonacci[n - 1] / fibonacci[n - 2];
        System.out.println(quotient);
    }
    /*
    c) Der Quotient nähert sich ~1.618 an. Das ist der Goldene Schnitt, ein Größenverhältnis das häufig in der Natur vorkommt.
    */

}
