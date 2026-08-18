package blatt29.aufgabe04;

public class Attributswert {
    private Attribut attribut;
    private int wert;

    public Attributswert(Attribut attribut, int wert) {
        this.attribut = attribut;
        this.wert = wert;
    }

    public Attribut getAttribut() {
        return attribut;
    }

    public void setAttribut(Attribut attribut) {
        this.attribut = attribut;
    }

    public int getWert() {
        return wert;
    }

    public void setWert(int wert) {
        this.wert = wert;
    }
}
