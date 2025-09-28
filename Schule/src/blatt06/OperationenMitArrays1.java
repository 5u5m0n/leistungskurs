package blatt06;

import java.util.Random;

public class OperationenMitArrays1 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] auftraege = new int[]{9000, 23000, 41000, 6000, 13000, 22000, 38000, 16000, 7000, 14000, 12000, 5000, 17000};

        int zw = auftraege[1];
        auftraege[1] = auftraege[6];
        auftraege[6] = zw;
        zw = auftraege[0];
        for (int i = 0; i<auftraege.length-1; i++) {
            auftraege[i] = auftraege[i+1];
        }
        auftraege[auftraege.length-1] = zw;
        int max = 0;
        int maxi;
        int min = 0;
        int mini;
        for (int i = 0; i<auftraege.length; i++) {
            if (auftraege[i] > max) {
                max = auftraege[i];
            } else if (auftraege[i] < min) {
                min = auftraege[i];
            }
        }


        int summe = 0;
        for (int i = 0; i < auftraege.length; i++) {
            summe += auftraege[i];
        }
        System.out.println("Summe: " + summe);
        int anzahlGross = 0;
        for (int i = 0; i < auftraege.length; i++) {
            if (auftraege[i] >= 15000) {
                anzahlGross++;
            }
        }
        System.out.println("Anzahl Aufträge mit Wert von 15000 € oder mehr: " + anzahlGross);
        int[] kosten = new int[auftraege.length];
        for (int i = 0; i < kosten.length; i++) {
            kosten[i] = rand.nextInt(4000, 25000);
            if (kosten[i] > auftraege[i]) {
                System.out.println("Auftrag " + i + " hat Gewinn gebracht.");
            }
        }
    }
}
