package blatt29.aufgabe4;

public class Angriff extends AktiveFaehigkeit {
    private Waffe waffe;
    private Wesen target;

    public Angriff(Wesen target, Wesen self) {
        super(self);
        this.target = target;
        this.waffe = null;
    }
    public Angriff(Wesen target, Waffe waffe, Wesen self) {
        super(self);
        this.target = target;
        this.waffe = waffe;
    }

    public int getSchaden() {

    }



}
