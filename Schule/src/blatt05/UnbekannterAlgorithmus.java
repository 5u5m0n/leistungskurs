package blatt05;

import java.util.Scanner;

public class UnbekannterAlgorithmus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        while (true) {
            if (a==b) {
                break;
            } else if (a>b) {
                a = a - b;
            } else {
                int h = a;
                a = b;
                b = h;
            }
        }
        System.out.println("a: " + a);


    }
}
