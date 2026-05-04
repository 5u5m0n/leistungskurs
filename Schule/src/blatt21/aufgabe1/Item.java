package blatt21.aufgabe1;

public abstract class Item {
    private int stufe;
    private boolean ausgeruestet;

    public int getStufe() {
        return stufe;
    }

    public boolean istAusgeruestet() {
        return ausgeruestet;
    }

    public void setAusgeruestet(boolean ausgeruestet) {
        this.ausgeruestet = ausgeruestet;
    }

    public void initStufe() {
        this.stufe = 1;
    }

    private void setStufe(int stufe) {
        this.stufe = stufe;
    }

    public void upgrade() {
        if (this.stufe < 4) {
            this.stufe++;
        }
    }
}
