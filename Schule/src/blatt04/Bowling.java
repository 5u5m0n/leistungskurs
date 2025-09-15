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
        while (frames < 10) {
            frames++;
            System.out.println("Frame " + frames);
            while (wuerfe < 2) {
                wuerfe++;
                switch (strike) {
                    case 0:
                        multiplikator = 1;
                        break;
                    case 1, 2:
                        strike--;
                        multiplikator = 2;
                        break;
                    case 3:
                        multiplikator = 3;
                }
                System.out.println("----------------------------------");
                System.out.println("Wurf " + wuerfe);
                System.out.println("Wie viele Pins hast du umgeworfen?");
                int treffer = input.nextInt();
                pins -= treffer;
                punkte += treffer*multiplikator;
                System.out.println("Punkte: " + punkte);
                System.out.println("----------------------------------");
                if (wuerfe == 1 && pins == 0) {
                    strike += 2;
                    System.out.println("STRIKE!");
                    break;
                } else if (wuerfe == 2 && pins == 0) {
                    strike += 1;
                    System.out.println("SPARE!");
                }

            }
            pins = 10;
            wuerfe = 0;
        }
    }
}
