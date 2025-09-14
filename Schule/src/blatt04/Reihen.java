package blatt04;

import java.util.Scanner;

public class Reihen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Wie viele Zahlen möchten Sie je Reihe ausgegeben bekommen?");
        int anzahl = input.nextInt();
        int reihe1 = 1;     //reihe1-variable wird definiert
        int reihe2 = 1;     //reihe2-variable wird definiert
        int reihe3 = 1;     //reihe3-variable wird definiert
        int reihe4 = 1;     //reihe4-variable wird definiert
        System.out.println("Reihe 1:");
        while(reihe1 <= anzahl){                        //Folgenvorschriften:
            System.out.print(reihe1 + " ");             //n
            reihe1++;
        }
        System.out.println("\nReihe 2:");
        while(reihe2 <= anzahl){
            System.out.print((reihe2*2) + " ");         //2*n
            reihe2++;
        }
        System.out.println("\nReihe 3:");
        while(reihe3 <= anzahl){
            System.out.print((reihe3*reihe3) + " ");    //n^2
            reihe3++;
        }
        System.out.println("\nReihe 4:");
        while(reihe4 <= anzahl){
            System.out.printf("%.0f ",((reihe4+1)/2) * Math.pow(-1, reihe4-1)); //(n+1)/2 * (-1)^n-1
            reihe4++;
        }
    }
}
