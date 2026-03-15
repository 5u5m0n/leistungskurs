package blatt20.aufgabe3;

public class Kochfeld {

    int hitzestufe;
    String groesse;

    public Kochfeld(String groesse) {
        this.groesse = groesse;
        this.hitzestufe = 0;
    }

    void hitzestufeErhoehen() {
        if (this.hitzestufe < 6) {
            this.hitzestufe++;
        }
        System.out.println("Hitzestufe: " + this.hitzestufe);
    }

    void hitzestufeReduzieren() {
        if (this.hitzestufe > 0) {
            this.hitzestufe--;
        }
        System.out.println("Hitzestufe: " + this.hitzestufe);
    }


}
