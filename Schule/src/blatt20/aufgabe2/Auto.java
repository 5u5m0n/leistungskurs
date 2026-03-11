package blatt20.aufgabe2;

public class Auto {
    String marke;
    String modell;
    int tank;
    int geschwindigkeit;
    int kilometerstand;

    public Auto() {
        String marke = "unbekannt";
        String modell = "unbekannt";
        int tank = 50;
        int geschwindigkeit = 0;
        int kilometerstand = 0;
    }

    public Auto(String marke, String modell, int tank, int geschwindigkeit, int kilometerstand) {
        this.marke = marke;
        this.modell = modell;
        this.tank = tank;
        this.geschwindigkeit = geschwindigkeit;
        this.kilometerstand = kilometerstand;
    }

    public Auto(Auto auto) {
        this.marke = auto.marke;
        this.modell = auto.modell;
        this.tank = auto.tank;
        this.geschwindigkeit = auto.geschwindigkeit;
        this.kilometerstand = auto.kilometerstand;
    }

    void beschleunigen(int v) {
        this.geschwindigkeit += v;
    }

    void bremsen(int v) {
        this.geschwindigkeit -= v;
    }

    void fahren(int km) {
        this.kilometerstand += km;
        this.tank -= km * geschwindigkeit;
    }

}
