package blatt21.aufgabe1;

import static blatt13.Zufall.zufall;
import static blatt13.Zufall.zufallGanz;

public class Farm {
    private Feld[] felder;
    private Farmer farmer;
    private Baum[] baeume;
    private int tag;
    private int aktuellesFeld;

    public Farmer getFarmer() {
        return farmer;
    }

    public Feld[] getFelder() {
        return felder;
    }

    public Baum[] getBaeume() {
        return baeume;
    }

    public int getTag() {
        return tag;
    }

    public Farm(Farmer farmer) {
        felder = new Feld[200];
        for (int i = 0; i < felder.length; i++) { felder[i] = new Feld(zufallGanz(2, 10)); }
        this.farmer = farmer;
        this.baeume = new Baum[] { null, null, null };
        this.tag = 0;
        this.aktuellesFeld = 0;
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
        for (int i = 0; i < this.felder.length; i++) { this.felder[i].weiter(); }
    }

    public void tagAblauf() {
        if (baeume[0] != null) { baumFaellen(0); }
        if (baeume[1] != null) { baumFaellen(1); }
        if (baeume[2] != null) { baumFaellen(2); }
        this.alleBewaessern();
        for (int i = 0; i < this.felder.length; i++) {
            double wert = feldVerkaufen(this.felder[i]);
            if (wert > -1) {
                felder[i] = new Feld(zufallGanz(2, 10));
                this.farmer.addVermoegen(wert);
            }
        }
        this.upgrades();
    }

    public static double feldVerkaufen(Feld feld) {
        if (feld.fertigGewachsen()) {
            return feld.getVerkaufswert();
        } else {
            return -1;
        }
    }

    private void alleBewaessern() {
        if (this.farmer.istGiesskanneAusgeruestet()) {
            while (this.farmer.getEnergie() > 0) {
                this.feldBewaessern();
                this.farmer.energieVerbrauchen();
            }
        }
    }

    private void baumFaellen(int i) {
        while (this.baeume[i] != null && this.farmer.getEnergie() > 0){
            this.baeume[i].schaden(this.farmer.getAxt().getSchaden());
            this.farmer.energieVerbrauchen();
            if (this.baeume[i].getHaltbarkeit() <= 0) {
                this.baeume[i] = null;
            }
        }
    }

    private void feldBewaessern() {
        int i = this.farmer.getGiesskanne().getVerbrauch();
        while (this.aktuellesFeld < this.felder.length && i > 0) {
            this.felder[this.aktuellesFeld].bewaessern();
            this.aktuellesFeld++;
            i--;
        }
    }

    private void upgrades() {
        Item[] items = new Item[] { this.farmer.getAxt(), this.farmer.getGiesskanne() };
        for (int i = 0; i < items.length; i++) {
            if (this.farmer.getVermoegen() >= 2500 && items[i].getStufe() == 1) {
                items[i].upgrade();
                this.farmer.addVermoegen(-2500);
            }
            if (this.farmer.getVermoegen() >= 10000 && items[i].getStufe() == 2) {
                items[i].upgrade();
                this.farmer.addVermoegen(-10000);
            }
            if (this.farmer.getVermoegen() >= 20000 && items[i].getStufe() == 3) {
                items[i].upgrade();
                this.farmer.addVermoegen(-20000);
            }
        }

    }



}
