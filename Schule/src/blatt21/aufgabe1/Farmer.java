package blatt21.aufgabe1;

public class Farmer {
    private String vorname;
    private String farmname;
    private double vermoegen;
    private Axt axt;
    private Giesskanne giesskanne;
    private int energie;

    public Farmer(String vorname, String farmname) {
        this.vorname = vorname;
        this.farmname = farmname;
        this.vermoegen = 1000;
        this.energie = 50;
        this.axt = new Axt();
        this.giesskanne = new Giesskanne();
    }

    public String getVorname() {
        return vorname;
    }

    public String getFarmname() {
        return farmname;
    }

    public double getVermoegen() {
        return vermoegen;
    }

    public Axt getAxt() {
        return axt;
    }

    public Giesskanne getGiesskanne() {
        return giesskanne;
    }

    public int getEnergie() {
        return energie;
    }

    public boolean istAxtAusgeruestet() {
        return this.axt.istAusgeruestet();
    }

    public boolean istGiesskanneAusgeruestet() {
        return this.giesskanne.istAusgeruestet();
    }

    public void schlafen() {
        this.energie = 50;
    }

    public void energieVerbrauchen() {
        this.energie = Math.min(0, this.energie - 1);
    }

    public void giesskanneAusruesten() {
        this.giesskanne.setAusgeruestet(true);
        this.axtAblegen();
    }

    public void giesskanneAblegen() {
        this.giesskanne.setAusgeruestet(false);
    }

    public void axtAusruesten() {
        this.axt.setAusgeruestet(true);
        this.giesskanneAblegen();
    }

    public void axtAblegen() {
        this.axt.setAusgeruestet(false);
    }

}
