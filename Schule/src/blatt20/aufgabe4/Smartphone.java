package blatt20.aufgabe4;

public class Smartphone {

    private String marke;
    private String modell;
    private int akkustand;
    private int speicher;
    private double preis;
    private int displaygroesse; //inch
    private int helligkeit;
    private int lautstaerke;
    private String betriebssystem;
    private boolean an;

    public Smartphone(String marke, String modell, int speicher, double preis, int displaygroesse, String betriebssystem) {
        this.marke = marke;
        this.modell = modell;
        this.speicher = speicher;
        this.preis = preis;
        this.displaygroesse = displaygroesse;
        this.betriebssystem = betriebssystem;
        this.helligkeit = 100;
        this.lautstaerke = 100;
        this.akkustand = 100;
        this.an = false;
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

    public void setBetriebssystem(String betriebssystem) {
        this.betriebssystem = betriebssystem;
    }

    public void setLautstaerke(int lautstaerke) {
        this.lautstaerke = Math.max(0, lautstaerke);
        this.lautstaerke = Math.max(this.lautstaerke, 100);
    }

    public void setHelligkeit(int helligkeit) {
        this.helligkeit = Math.max(0, helligkeit);
        this.helligkeit = Math.max(this.helligkeit, 100);
    }

    public String getMarke() {
        return marke;
    }

    public String getModell() {
        return modell;
    }

    public int getAkkustand() {
        return akkustand;
    }

    public int getSpeicher() {
        return speicher;
    }

    public double getPreis() {
        return preis;
    }

    public int getDisplaygroesse() {
        return displaygroesse;
    }

    public int getHelligkeit() {
        return helligkeit;
    }

    public int getLautstaerke() {
        return lautstaerke;
    }

    public String getBetriebssystem() {
        return betriebssystem;
    }

    public boolean isAn() {
        return an;
    }

    void nutzen(int zeit) {
        setAkkustand(this.akkustand - zeit);
    }

    void laden(int zeit) {
        setAkkustand(this.akkustand + zeit);
    }

    void speicherLeeren(int menge) {
        setSpeicher(this.speicher + menge);
    }

    void akkuLaden() {
        setAkkustand(100);
    }

    void einschalten() {
        this.an = !this.an;
    }

    boolean istAkkuLeer() {
        if (this.akkustand > 0) {
            return true;
        } else {
            return false;
        }
    }

    void appInstallieren(int groesse) {
        if (hatGenugSpeicher(groesse)) {
            setSpeicher(this.speicher - groesse);
        }
    }

    boolean hatGenugSpeicher(int groesse) {
        return this.speicher > groesse;
    }


}
