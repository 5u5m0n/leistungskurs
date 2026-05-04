package blatt21.aufgabe1;

import static blatt13.Zufall.zufall;

public class Axt extends Item {

    public Axt() {
        this.initStufe();
        this.setAusgeruestet(false);
    }

    public int getSchaden() {
        int schaden;
        switch (this.getStufe()) {
            case 1 -> schaden = 1;
            case 2 -> schaden = 2;
            case 3 -> schaden = 4;
            case 4 -> schaden = 6;
            default -> schaden = 0;
        };
        double zufall = zufall(1);
        if (zufall <= this.getCritChance()) {
            schaden *= 2;
        }
        return schaden;
    }

    public double getCritChance() {
        return switch (this.getStufe()) {
            case 1 -> 0.04;
            case 2 -> 0.08;
            case 3 -> 0.12;
            case 4 -> 0.16;
            default -> 0;
        };
    }


}
