package blatt02;

import java.util.Scanner;

public class Talking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Guten Tag, wie heißen Sie?");
        String name = input.nextLine();
        System.out.println("Hallo " + name + "!");
    }
}
