package blatt29.aufgabe4;

public abstract class Wesen {
    private int level;

    private Attributswert staerke;
    private Attributswert mStaerke;
    private int konstitution;

    private int maxHP;
    private int maxSP;
    private int currentHP;
    private int currentSP;

    private int geschwindigkeit;
    private double glueck;

    private Waffe waffe;

    public double getGlueck() {
        return this.glueck;
    }

    //Setter && Getter
    protected void setGlueck(double glueck) {
        this.glueck = glueck;
    }

    public int getGeschwindigkeit() {
        return this.geschwindigkeit;
    }

    protected void setGeschwindigkeit(int geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }

    public int getCurrentSP() {
        return this.currentSP;
    }

    protected void setCurrentSP(int currentSP) {
        this.currentSP = currentSP;
    }

    public int getCurrentHP() {
        return this.currentHP;
    }

    protected void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getMaxSP() {
        return this.maxSP;
    }

    protected void setMaxSP(int maxSP) {
        this.maxSP = maxSP;
    }

    public int getMaxHP() {
        return this.maxHP;
    }

    protected void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public Attributswert getMStaerke() {
        return this.mStaerke;
    }

    protected void setMStaerke(int mStaerke) {
        this.mStaerke.setWert(mStaerke);
    }

    protected void setMStaerke(Attributswert mStaerke) { this.mStaerke = mStaerke; }

    public int getKonstitution() {
        return this.konstitution;
    }

    protected void setKonstitution(int konstitution) {
        this.konstitution = konstitution;
    }

    public Attributswert getStaerke() {
        return this.staerke;
    }

    protected void setStaerke(int staerke) {
        this.staerke.setWert(staerke);
    }

    protected void setStaerke(Attributswert staerke) { this.staerke = staerke; }

    public int getLevel() {
        return this.level;
    }

    protected void setLevel(int level) {
        this.level = level;
    }

    //Prozeduren
    public void death() {
        System.out.println("IUSDKHGFIUGHPIAUFZH");
    }

    public void schaden(int schaden) {
        this.currentHP -= schaden;
        if (this.currentHP <= 0) {
            death();
        } else if (this.currentHP > this.maxHP) {
            this.currentHP = this.maxHP;
        }
    }

    public void heilen(int heilung) {
        this.schaden(-heilung);
    }

    public void heilen(int heiling, boolean overheal) {
        if (overheal) {
            int tempHP = 0;
            if (this.currentHP + heiling > this.maxHP) {
                tempHP = this.currentHP + heiling - this.maxHP;
            }
            this.schaden(-heiling);
            this.currentHP += tempHP;
        } else {
            this.schaden(-heiling);
        }
    }


}
