package blatt21.aufgabe01;

public class Giesskanne extends Item {
    private int wasserstand;

    public Giesskanne() {
        this.initStufe();
        this.setAusgeruestet(false);
        this.wasserstand = 0;
    }

    public int getMaxWasserstand() {
        return 30 + (15 * (this.getStufe() - 1));
    }

    public int getVerbrauch() {
        return switch (this.getStufe()) {
            case 1 -> 1;
            case 2 -> 3;
            case 3 -> 9;
            case 4 -> 24;
            default -> -1;
        };
    }

    public int getWasserstand() {
        return wasserstand;
    }

    public void giessen() {
        this.wasserstand -= this.getVerbrauch();
        if (this.wasserstand < 0) {
            this.wasserstand = 0;
        }
    }

    public void auffuellen() {
        this.wasserstand = this.getMaxWasserstand();
    }

}
