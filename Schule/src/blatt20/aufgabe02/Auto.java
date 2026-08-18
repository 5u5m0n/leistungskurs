package blatt20.aufgabe02;

public class Auto {
    private String marke;
    private String modell;
    private int tank;
    private int geschwindigkeit;
    private int kilometerstand;

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

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public void setKilometerstand(int kilometerstand) {
        this.kilometerstand = kilometerstand;
        if (kilometerstand < 0) {
            this.kilometerstand = 0;
        }
    }

    public void setGeschwindigkeit(int geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
        if (geschwindigkeit < 0) {
            this.geschwindigkeit = 0;
        }
    }

    public void setTank(int tank) {
        this.tank = tank;
        if (tank < 0) {
            this.tank = 0;
        } else if (tank > 100) {
            this.tank = 100;
        }
    }

    public void setModell(String modell) {
        this.modell = modell;
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
