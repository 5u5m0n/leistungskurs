package blatt21.aufgabe1;

public class Giesskanne {
    private int stufe;
    private boolean ausgeruestet;
    private int wasserstand;

    public Giesskanne() {
        this.stufe = 1;
        this.ausgeruestet = false;
        this.wasserstand = 0;
    }

    public int getMaxWasserstand() {
        return 30 + (15 * (this.stufe - 1));
    }

    public int getVerbrauch() {
        return switch (this.stufe) {
            case 1 -> 1;
            case 2 -> 3;
            case 3 -> 9;
            case 4 -> 24;
            default -> -1;
        };
    }

    public int getStufe() {
        return stufe;
    }

    public boolean istAusgeruestet() {
        return ausgeruestet;
    }

    public void setAusgeruestet(boolean ausgeruestet) {
        this.ausgeruestet = ausgeruestet;
    }

    public int getWasserstand() {
        return wasserstand;
    }

    public void upgrade() {
        this.stufe = Math.min(this.stufe, 4);
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
