package blatt29.aufgabe4;

public abstract class Wesen {
    private int level;
    private int staerke;
    private int konstitution;
    private int mStaerke;
    private int mVerteidigung;
    private int maxHP;
    private int maxSP;
    private int currentHP;
    private int currentSP;
    private int geschwindigkeit;
    private double glueck;

    public double getGlueck() {
        return this.glueck;
    }

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

    public int getMVerteidigung() {
        return this.mVerteidigung;
    }

    protected void setMVerteidigung(int mVerteidigung) {
        this.mVerteidigung = mVerteidigung;
    }

    public int getMStaerke() {
        return this.mStaerke;
    }

    protected void setMStaerke(int mStaerke) {
        this.mStaerke = mStaerke;
    }

    public int getKonstitution() {
        return this.konstitution;
    }

    protected void setKonstitution(int konstitution) {
        this.konstitution = konstitution;
    }

    public int getStaerke() {
        return this.staerke;
    }

    protected void setStaerke(int staerke) {
        this.staerke = staerke;
    }

    public int getLevel() {
        return this.level;
    }

    protected void setLevel(int level) {
        this.level = level;
    }

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
