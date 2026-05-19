package blatt29.aufgabe4;

public class Gegner extends Wesen{
    private int xpDrop;

    public Gegner(int level, Attributswert staerke, int konstitution, Attributswert mStaerke, int maxHP, int maxSP, int geschwindigkeit, int glueck, int xpDrop) {
        this.setLevel(level);
        this.setStaerke(staerke);
        this.setKonstitution(konstitution);
        this.setMStaerke(mStaerke);
        this.setMaxHP(maxHP);
        this.setMaxSP(maxSP);
        this.setGeschwindigkeit(geschwindigkeit);
        this.setGlueck(glueck);
        this.setCurrentHP(maxHP);
        this.setCurrentSP(maxSP);
        this.xpDrop = xpDrop;
    }
}
