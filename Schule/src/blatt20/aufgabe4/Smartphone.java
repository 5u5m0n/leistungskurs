package blatt20.aufgabe4;

public class Smartphone {

    private String marke;
    private String modell;
    private int akkustand;
    private int speicher;
    private double preis;

    public Smartphone(String modell, String marke, int speicher, double preis) {
        this.modell = modell;
        this.marke = marke;
        this.speicher = speicher;
        this.preis = preis;
        this.akkustand = 100;
    }

    public void setAkkustand(int akkustand) {
        this.akkustand = Math.max(0, akkustand);
        this.akkustand = Math.min(this.akkustand, 100);
    }

    public void setSpeicher(int speicher) {
        this.speicher = Math.max(0, speicher);
    }

    public void setPreis(double preis) {
        this.preis = Math.max(0, preis);
    }

    void nutzen(int zeit) {
        setAkkustand(this.akkustand - zeit);
    }

    void laden(int zeit) {
        setAkkustand(this.akkustand + zeit);
    }
}
