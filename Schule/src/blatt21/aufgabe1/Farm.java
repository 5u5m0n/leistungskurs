package blatt21.aufgabe1;

import static blatt13.Zufall.zufall;
import static blatt13.Zufall.zufallGanz;

public class Farm {
    private Feld[] felder;
    private Farmer farmer;
    private Baum[] baeume;
    private int tag;
    private int aktuellesFeld;

    public Farm(Farmer farmer) {
        felder = new Feld[200];
        for (int i = 0; i < felder.length; i++) {
            felder[i] = new Feld(zufallGanz(2, 10));

        }
        this.farmer = farmer;
        this.baeume = new Baum[] { null, null, null };
        this.tag = 0;
        this.aktuellesFeld = 0;
    }

    public void alleBewaessern() {
        if (this.farmer.istGiesskanneAusgeruestet()) {
            while (this.farmer.getEnergie() > 0) {
                feldBewaessern();
                this.farmer.energieVerbrauchen();
            }
        }
    }

    private void baumFaellen(int i) {
        while (this.baeume[i] != null) {
            this.baeume[i].schaden(this.farmer.getAxt().getSchaden());
            if (this.baeume[i].getHaltbarkeit() <= 0) {
                this.baeume[i] = null;
            }
        }
    }

    private void feldBewaessern() {
        int i = this.farmer.getGiesskanne().getVerbrauch();
        while (aktuellesFeld < this.felder.length && i > 0) {
            this.felder[aktuellesFeld].bewaessern();
            aktuellesFeld++;
            i--;
        }
    }

    public void neuerTag() {
        this.farmer.schlafen();
        this.tag++;
        for (int i = 0; i < this.baeume.length; i++) {
            if (zufall(1) < 0.08) {
                this.baeume[i] = new Baum(zufallGanz(2, 10));
            }
        }
        this.aktuellesFeld = 0;
    }


}
