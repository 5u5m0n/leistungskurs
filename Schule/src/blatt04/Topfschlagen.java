package blatt04;

import java.util.Scanner;
import java.util.Random;
public class Topfschlagen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int topfx = rand.nextInt(10) + 1;
        int topfy = rand.nextInt(10) + 1;
        int playerx = rand.nextInt(10) + 1;
        int playery = rand.nextInt(10) + 1;
        double distanzAlt = Math.sqrt((topfx-playerx)*(topfx-playerx)+(topfy-playery)*(topfy-playery));
        double distanzNeu;
        boolean moved = false;
        System.out.println("Willkommen zum Topfschlagen!");
        System.out.println("Bewegen: w|a|s|d");
        while (true) {
            while(!moved) {
                char move = input.next().toLowerCase().charAt(0);
                moved = true;
                if (move == 'w') {
                    playery += 1;
                } else if (move == 'a') {
                    playerx -= 1;
                } else if (move == 's') {
                    playery -= 1;
                } else if (move == 'd') {
                    playerx += 1;
                } else {
                    moved = false;
                    System.out.println("Erneut eingeben.");
                }
            }
            moved = false;

            if (playerx == topfx && playery == topfy) {
                System.out.println("Gewonnen");
                break;
            }
            distanzNeu = Math.sqrt((topfx-playerx)*(topfx-playerx)+(topfy-playery)*(topfy-playery));
            if (distanzAlt >= distanzNeu) {
                System.out.println("Wärmer");
            } else {
                System.out.println("Kälter");
            }
            distanzAlt = distanzNeu;

        }
    }
}
