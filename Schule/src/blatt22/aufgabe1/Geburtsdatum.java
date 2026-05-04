package blatt22.aufgabe1;

public class Geburtsdatum {
    private int tag;
    private int monat;
    private int jahr;

    public Geburtsdatum(int tag, int monat, int jahr) {
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }

    public int getTag() {
        return tag;
    }

    public int getMonat() {
        return monat;
    }

    public int getJahr() {
        return jahr;
    }
}
