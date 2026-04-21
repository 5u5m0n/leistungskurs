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
            System.out.println("Neues Passwort gesetzt.");
        }
    }

    public void guthabenHinzufuegen(double menge, String gutscheincode) {
        if (this.angemeldet && !gutscheincode.isEmpty()) {
            this.gutscheinguthaben += menge;
            System.out.println("Neuses Guthaben: " + this.gutscheinguthaben);
        } else {
            System.out.println("Fehler");
        }
    }

    public void anmelden(String passwort) {
        if (passwort.equals(this.passwort)) {
            this.angemeldet = true;
            System.out.println("Angemeldet!");
        } else {
            System.out.println("Fehler");
        }
    }

    public void abmelden() {
        this.angemeldet = false;
        System.out.println("Abgemeldet!");
    }


}
