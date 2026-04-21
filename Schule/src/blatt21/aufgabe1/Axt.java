package blatt21.aufgabe1;

public class Axt {
    private int stufe;
    private boolean ausgeruestet;

    public Axt() {
        this.stufe = 1;
        this.ausgeruestet = false;
    }

    public boolean istAusgeruestet() {
        return ausgeruestet;
    }

    public void setAusgeruestet(boolean ausgeruestet) {
        this.ausgeruestet = ausgeruestet;
    }

    public int getStufe() {
        return stufe;
    }

    public void upgrade() {
        if (this.stufe < 4) {
            this.stufe++;
        }
    }


}
