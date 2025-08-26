package blatt01;

public class Zinssatz {
    public static void main(String[] args) {
        double kapital = 1220.00;
        double zinsatz = 2.25;
        double zinsen = (kapital * zinsatz)/100;
        double neu = kapital + zinsen;
        System.out.println("Altes Kapital: " + kapital + " €");
        System.out.println("Zinssatz: " + zinsatz + " %");
        System.out.println("\nZinsen: " + zinsen + " €");
        System.out.println("Neues Kapital: " + neu + " €");
    }
}
