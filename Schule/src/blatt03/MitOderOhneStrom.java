package blatt03;

import  java.util.Scanner;

public class MitOderOhneStrom {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Wähle ein Gatter aus (NOT, OR, AND, XOR");
        String gatter = input.nextLine();           //Gatter-Auswahl
        if (gatter.equalsIgnoreCase("NOT")) {
            System.out.println("Das NOT-Gatter:");
            System.out.println("Das Gatter verfügt über einen Eingang und einen Ausgang.");
            System.out.println("Befindet sich auf dem Eingang Strom? (true/false)");
            boolean eingang = input.nextBoolean();
            boolean not = !eingang;
            System.out.println("NOT " + eingang + " = " + not);
        } else if (gatter.equalsIgnoreCase("OR")) {
            System.out.println("Das OR-Gatter:");
            System.out.println("Das Gatter verfügt über 2 Eingänge und einen Ausgang.");
            System.out.println("Befindet sich auf dem ersten Eingang Strom? (true/false)");
            boolean eingang1 = input.nextBoolean();
            System.out.println("Befindet sich auf dem zweiten Eingang Strom? (true/false)");
            boolean eingang2 = input.nextBoolean();
            boolean or = eingang1 || eingang2;
            System.out.println(eingang1 + " OR " + eingang2 + " = " + or);
        } else if (gatter.equalsIgnoreCase("AND")) {
            System.out.println("Das AND-Gatter:");
            System.out.println("Das Gatter verfügt über einen Eingang und einen Ausgang.");
            System.out.println("Befindet sich auf dem ersten Eingang Strom? (true/false)");
            boolean eingang1 = input.nextBoolean();
            System.out.println("Befindet sich auf dem zweiten Eingang Strom? (true/false)");
            boolean eingang2 = input.nextBoolean();
            boolean and = eingang1 && eingang2;
            System.out.println(eingang1 + " AND " + eingang2 + " = " + and);
        } else if (gatter.equalsIgnoreCase("XOR")) {
            System.out.println("Das XOR-Gatter:");
            System.out.println("Das Gatter verfügt über einen Eingang und einen Ausgang.");
            System.out.println("Befindet sich auf dem ersten Eingang Strom? (true/false)");
            boolean eingang1 = input.nextBoolean();
            System.out.println("Befindet sich auf dem zweiten Eingang Strom? (true/false)");
            boolean eingang2 = input.nextBoolean();
            boolean xor = (eingang1 || eingang2) && !(eingang1 && eingang2);
            System.out.println(eingang1 + " XOR " + eingang2 + " = " + xor);
        } else {
            System.out.println("Fehlerhafte Eingabe.");
            System.exit(0);
        }
    }
}
