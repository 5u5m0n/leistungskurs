package blatt03;

import java.util.Scanner;

public class MinMax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nenne die erste (ganze) Zahl");
        int ersteZahl = input.nextInt();
        System.out.println("Nenne die zweitw (ganze) Zahl");
        int zweiteZahl = input.nextInt();
        System.out.println("Nenne die dritte (ganze) Zahl");
        int dritteZahl = input.nextInt();
        int groessteZahl = 0;
        int kleinsteZahl = 0;
        if ((ersteZahl>=zweiteZahl) && (ersteZahl>=dritteZahl)) {           //erste ist größte
            groessteZahl = ersteZahl;
            if (zweiteZahl<=dritteZahl) {
                kleinsteZahl = zweiteZahl;
            }else {
                kleinsteZahl = dritteZahl;
            }
        } else if ((zweiteZahl>=dritteZahl) && (zweiteZahl>=ersteZahl)) {   //zweite ist größte
            groessteZahl = zweiteZahl;
            if (ersteZahl<=dritteZahl) {
                kleinsteZahl = ersteZahl;
            }else {
                kleinsteZahl = dritteZahl;
            }
        } else if ((dritteZahl>=zweiteZahl) && (dritteZahl>=ersteZahl)) {   //dritte ist größte
            groessteZahl = dritteZahl;
            if (zweiteZahl<=ersteZahl) {
                kleinsteZahl = zweiteZahl;
            }else {
                kleinsteZahl = ersteZahl;
            }
        }
        System.out.println("Größte Zahl: " + groessteZahl);
        System.out.println("Kleinste Zahl: " + kleinsteZahl);

    }
}
