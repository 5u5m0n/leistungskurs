package blatt21.aufgabe01;

public class Baum {
    private int haltbarkeit;

    public Baum(int haltbarkeit) {
        this.haltbarkeit = Math.max(haltbarkeit, 5);
        this.haltbarkeit = Math.min(this.haltbarkeit, 20);
    }

    public int getHaltbarkeit() {
        return haltbarkeit;
    }

    public void schaden(int schaden) {
        this.haltbarkeit -= schaden;
    }
}
