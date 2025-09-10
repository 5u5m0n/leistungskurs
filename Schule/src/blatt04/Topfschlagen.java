package blatt04;

import java.util.Scanner;
import java.util.Random;
public class Topfschlagen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int topfx = rand.nextInt(5) + 1;
        int topfy = rand.nextInt(5) + 1;
        int playerx = 3;
        int playery = 3;
        boolean moved = false;
        System.out.println(topfx + ", " + topfy);
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
                    playerx -= 1;
                } else {
                    moved = false;
                    System.out.println("Erneut eingeben.");
                }
            }
            moved = false;
            System.out.println("(" +  playerx + "|" + playery + ")");
            if (playerx == topfx && playery == topfy) {
                System.out.println("Gewonnen");
                break;
            }

        }
    }
}
