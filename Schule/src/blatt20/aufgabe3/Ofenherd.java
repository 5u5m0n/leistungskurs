package blatt20.aufgabe3;

public class Ofenherd {

    Ofen ofen;
    Kochfeld kochfeld;

    public Ofenherd(String groesse) {
        this.ofen = new Ofen();
        this.kochfeld = new Kochfeld(groesse);
    }

    void hitzestufeErhoehen() {
        this.kochfeld.hitzestufeErhoehen();
    }

    void hitzestufeReduzieren() {
        this.kochfeld.hitzestufeReduzieren();
    }

    void beheizungsmodusErhoehen() {
        this.ofen.beheizungsmodusErhoehen();
    }

    void beheizungsmodusReduzieren() {
        this.ofen.beheizungsmodusReduzieren();
    }

    void temparaturEinstellen(int temparatur) {
        this.ofen.temparaturEinstellen(temparatur);
    }

}
