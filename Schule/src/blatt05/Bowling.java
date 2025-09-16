package blatt05;

import java.util.Scanner;

public class Bowling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int punkte = 0;
        int frames = 1;
        int wuerfe = 1;
        int pins = 10;
        int multiplikator = 1;
        int multiCounter = 0;
        while (frames <= 10) {
            System.out.println("Frame " + frames);
            while (wuerfe <= 2) {
                switch (multiCounter) {
                    case 0:
                        multiplikator = 1;
                        break;
                    case 1, 2:
                        multiCounter--;
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
                    multiCounter += 2;
                    System.out.println("STRIKE!");
                    break;
                } else if (wuerfe == 2 && pins == 0) {
                    multiCounter += 1;
                    System.out.println("SPARE!");
                }
                wuerfe++;
            }
            pins = 10;
            wuerfe = 1;
            frames++;
        }
    }
}
