package blatt20.aufgabe3;

public class Kochfeld {

    int hitzestufe;
    String groesse;

    void hitzestufeErhoehen() {
        if (this.hitzestufe < 6) {
            this.hitzestufe++;
        }
    }

    void hitzestufeReduzieren() {
        if (this.hitzestufe > 0) {
            this.hitzestufe--;
        }
    }


}
