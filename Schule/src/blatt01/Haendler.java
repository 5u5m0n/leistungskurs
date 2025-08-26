package blatt01;

public class Haendler {
    public static void main(String[] args) {
        double sd_preis = 5;
        double minisd_preis = 8;
        double microsd_preis = 12;
        int anz_sd = 9;
        int anz_minisd = 5;
        int anz_microsd = 0;
        double gesamtpreis = (sd_preis * anz_sd) + (minisd_preis * anz_minisd) + (microsd_preis * anz_microsd);
        System.out.println("Der Preis für...");
        System.out.println(anz_sd + " normale SD-Karten");
        System.out.println(anz_minisd + " MiniSD-Karten");
        System.out.println(anz_microsd + " MicroSD-Karten");
        System.out.println("...lautet " + gesamtpreis + " €");
        //1.: 2
        //2.: int; double
        //3.: Negative Preise und Anzahlen

    }
}
