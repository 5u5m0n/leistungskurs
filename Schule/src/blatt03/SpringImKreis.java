package blatt03;

import  java.util.Scanner;

public class SpringImKreis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nenne den Radius des Kreises:");
        double radius = input.nextDouble();
        System.out.println("Nenne die x-Koordinate:");
        double x = input.nextDouble();
        System.out.println("Nenne die y-Koordinate:");
        double y = input.nextDouble();
        if ((x * x) + (y * y) == (radius * radius)) {
            System.out.println("Der Punkt (" + x + "|" + y + ") liegt exakt auf dem Kreis.");
        } else if ((x * x) + (y * y) < (radius * radius)) {
            System.out.println("Der Punkt (" + x + "|" + y + ") liegt im Kreis.");
        }else {
            System.out.println("Der Punkt (" + x + "|" + y + ") liegt nicht im Kreis.");
        }
    }
}
