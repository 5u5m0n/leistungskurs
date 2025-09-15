package blatt04;

import java.util.Scanner;

public class Bowling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int punkte = 0;
        int frames = 0;
        int wuerfe = 0;
        int pins = 10;
        int multiplikator = 1;
        int strike = 0;
        //TODO: Multiplikator
        while (frames < 10) {
            while (wuerfe < 2) {
                System.out.println("Wie viele Pins hast du umgeworfen?");
                int treffer = input.nextInt();
                pins -= treffer;
                punkte += treffer*multiplikator;
                if (wuerfe == 0 && pins == 0) {

                    break;
                } else if (wuerfe == 1 && pins == 0) {

                }

            }
            pins = 10;
            wuerfe = 0;
            frames++;
        }
    }
}
