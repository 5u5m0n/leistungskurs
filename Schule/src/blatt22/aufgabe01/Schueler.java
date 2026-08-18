package blatt22.aufgabe01;

public class Schueler {
    private String vorname;
    private String nachname;
    private Geburtsdatum geburtsdatum;
    private int alter;
    private int jahrgangsstufe;

    public Schueler(String vorname, String nachname, Geburtsdatum geburtsdatum, int alter, int jahrgangsstufe) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.alter = alter;
        this.jahrgangsstufe = jahrgangsstufe;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public Geburtsdatum getGeburtsdatum() {
        return geburtsdatum;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Schueler)) return false;
        return  this.vorname.equals(((Schueler) obj).getVorname()) &&
                this.nachname.equals(((Schueler) obj).getNachname()) &&
                this.geburtsdatum.equals(((Schueler) obj).getGeburtsdatum()) &&
                this.alter == ((Schueler) obj).alter &&
                this.jahrgangsstufe == ((Schueler) obj).jahrgangsstufe;
    }

    @Override
    public String toString() {
        return new String(this.vorname + " " + this.nachname + ", " + this.geburtsdatum.toString());
    }

    public void geburtstag() {
        this.alter++;
    }

    public void bestehen() {
        this.jahrgangsstufe = Math.min(jahrgangsstufe + 1, this.alter);
    }
}
