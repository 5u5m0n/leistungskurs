package blatt20.aufgabe0;

import java.util.Arrays;
import java.util.Objects;

public class Fahrrad {

    String      marke;
    boolean     reflektorAnPedalen;
    boolean     katzenaugen;
    boolean     ruecklicht;
    boolean     frontlicht;
    String[]    farben;
    int         reifendurchmesser;
    boolean     zulassung;
    String      typ;
    int         gaengeVorneAnzahl;
    int         gaengeHintenAnzahl;
    int         gangVorne;
    int         gangHinten;

   public  double beschleunigung() {
        return 0;
   }

   public void schaltenVorne(int menge) {
        this.gangVorne += menge;
   }

   public void schaltenHinten(int menge) {
       this.gangHinten += menge;
   }

   public void klingeln() {
       System.out.println("Klingeling!");
   }

   public void beschreiben() {
       System.out.println("Fahrrad: " + this.farben[0] + ", " +
               this.gaengeHintenAnzahl + " Gaenge hinten, " +
               this.gaengeVorneAnzahl + " Gaenge vorne, " +
               this.reifendurchmesser + " Reifendurchmesser.");
   }

    @Override
    public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;
       Fahrrad fahrrad = (Fahrrad) o;
       return reflektorAnPedalen == fahrrad.reflektorAnPedalen && katzenaugen == fahrrad.katzenaugen && ruecklicht == fahrrad.ruecklicht && frontlicht == fahrrad.frontlicht && reifendurchmesser == fahrrad.reifendurchmesser && zulassung == fahrrad.zulassung && gaengeVorneAnzahl == fahrrad.gaengeVorneAnzahl && gaengeHintenAnzahl == fahrrad.gaengeHintenAnzahl && Objects.equals(marke, fahrrad.marke) && Objects.deepEquals(farben, fahrrad.farben) && Objects.equals(typ, fahrrad.typ);
    }

}