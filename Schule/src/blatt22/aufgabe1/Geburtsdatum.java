package blatt22.aufgabe1;

import blatt20.aufgabe4.Smartphone;

public class Geburtsdatum {
    private int tag;
    private int monat;
    private int jahr;

    public Geburtsdatum(int tag, int monat, int jahr) {
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
        if (!this.isValid()) {
            this.tag = 1;
            this.monat = 1;
            this.jahr = 1970;
        }
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

    public boolean isValid() {
        int schaltjahr = 0;
        if (this.jahr % 4 == 0 && (this.jahr % 100 != 0 || this.jahr % 400 == 0)) {
            schaltjahr = 1;
        }
        int maxTag = 0;
        switch (this.monat) {
            case 1 -> maxTag = 31;
            case 2 -> maxTag = 28 + schaltjahr;
            case 3 -> maxTag = 31;
            case 4 -> maxTag = 30;
            case 5 -> maxTag = 31;
            case 6 -> maxTag = 30;
            case 7 -> maxTag = 31;
            case 8 -> maxTag = 31;
            case 9 -> maxTag = 30;
            case 10 -> maxTag = 31;
            case 11 -> maxTag = 30;
            case 12 -> maxTag = 31;
            default -> { return false; }
        }
        return this.tag <= maxTag && this.tag > 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Geburtsdatum)) return false;
        return this.tag == ((Geburtsdatum) obj).getTag() && this.monat == ((Geburtsdatum) obj).getMonat() && this.jahr == ((Geburtsdatum) obj).getJahr();
    }

    @Override
    public String toString() {
        return new String(this.tag + "." + this.monat + "." + this.jahr);
    }

}
