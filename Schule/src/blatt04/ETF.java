package blatt04;

public class ETF {
    public static void main(String[] args) {
        double sparbetrag = 50;
        double wert = 3578.89;
        double gesamtsparbetrag = 0;
        double anteil;
        int monat = 1;
        while (monat <= 12) {
            gesamtsparbetrag += sparbetrag;
            anteil = gesamtsparbetrag / wert;
            System.out.println("Monat: " + monat);
            System.out.printf("Sparbetrag diesen Monat: %.2f €\n", sparbetrag);
            System.out.printf("Gesamtsparbetrag: %.2f €\n", gesamtsparbetrag);
            System.out.printf("Anteil: %.5f %%\n\n", anteil);
            monat ++;
        }
    }
}
