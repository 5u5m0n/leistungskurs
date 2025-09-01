package blatt01;

public class Haendler {
    public static void main(String[] args) {
        double sdPreis = 5;
        double minisdPreis = 8;
        double microsdPreis = 12;
        int anzSd = 9;
        int anzMinisd = 5;
        int anzMicrosd = 0;
        double gesamtpreis = (sdPreis * anzSd) + (minisdPreis * anzMinisd) + (microsdPreis * anzMicrosd);
        System.out.println("Der Preis für...");
        System.out.println(anzSd + " normale SD-Karten");
        System.out.println(anzMinisd + " MiniSD-Karten");
        System.out.println(anzMicrosd + " MicroSD-Karten");
        System.out.println("...lautet " + gesamtpreis + " €");
        //1.: 2
        //2.: int; double
        //3.: Negative Preise und Anzahlen

    }
}
