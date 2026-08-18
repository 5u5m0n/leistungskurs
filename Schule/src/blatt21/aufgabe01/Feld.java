package blatt21.aufgabe01;

import blatt13.Zufall;

public class Feld {
    private int maximaleWachszeit;
    private int aktuelleWachszeit;
    private double verkaufswert;
    private boolean bewaessert;

    public Feld(int maximaleWachszeit) {
        this.maximaleWachszeit = maximaleWachszeit;
        this.aktuelleWachszeit = 0;
        this.verkaufswert = (1000 * Math.pow(1.12, maximaleWachszeit) + (Zufall.zufallGanz(-2,4) * 125));
        this.bewaessert = false;
    }

    public int getMaximaleWachszeit() {
        return maximaleWachszeit;
    }

    public int getAktuelleWachszeit() {
        return aktuelleWachszeit;
    }

    public double getVerkaufswert() {
        return verkaufswert;
    }

    public boolean wurdeBewaessert() {
        return bewaessert;
    }

    public boolean fertigGewachsen() {
        return aktuelleWachszeit >= maximaleWachszeit;
    }

    public void bewaessern() {
        if (!this.bewaessert) {
            this.bewaessert = true;
        }
    }

    public void weiter() {
        if (this.bewaessert) {
            this.bewaessert = false;
            this.aktuelleWachszeit++;
        }
    }


}
