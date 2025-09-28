package blatt06;

import java.util.Scanner;

public class GrenzenSetzen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geben Sie eine Ober- un Untergrenze ein:");
        int u = input.nextInt();
        int o = input.nextInt();
        if (u > o) {
            int h = u;
            u = o;
            o = h;
        }
        int diff = o - u + 1;
        int[] werte = new int[diff];
        for (int i = 0; i < diff; i++) {
            werte[i] = u + i;
        }
        for (int i = 0; i < werte.length; i++) {
            System.out.println(werte[i]);
        }
    }
}
