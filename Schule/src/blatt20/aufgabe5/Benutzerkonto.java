package blatt20.aufgabe5;

import java.util.Date;

public class Benutzerkonto {

    private java.util.Date erstellungsdatum;

    private String benutzername;
    private String emailAdresse;
    private java.util.Date geburtsdatum;

    private String passwort;
    private double gutscheinguthaben;

    private boolean angemeldet;

    public Benutzerkonto(String benutzername, String emailAdresse, Date geburtsdatum, String passwort) {
        this.benutzername = benutzername;
        this.emailAdresse = emailAdresse;
        this.geburtsdatum = geburtsdatum;
        this.passwort = passwort;
        this.erstellungsdatum = new java.util.Date(2026, 3, 17);
        this.gutscheinguthaben = 0;
        this.angemeldet = false;
    }

    public double getGutscheinguthaben() {
        if (this.angemeldet) {
            return gutscheinguthaben;
        }
        return -Math.pow(2, 32);
    }

    public void setPasswort(String altesPasswort, String neuesPasswort) {
        if (this.passwort.equals(altesPasswort) && this.angemeldet) {
            this.passwort = neuesPasswort;
        }
    }

    public void guthabenHinzufuegen(double menge) {
        boolean gueltig = true;
        if (gueltig && this.angemeldet) {
            this.gutscheinguthaben += menge;
        }
    }

    public void anmelden(String passwort) {
        if (passwort.equals(this.passwort) && this.angemeldet) {
            this.angemeldet = true;
        }
    }

    public void abmelden() {
        this.angemeldet = false;
    }


}
