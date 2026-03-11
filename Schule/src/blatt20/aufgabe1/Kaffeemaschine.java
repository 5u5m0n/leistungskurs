package blatt20.aufgabe1;

import static blatt13.Zufall.zufall;

public class Kaffeemaschine {

    //Bohnenbehaelter Groesse = 350g
    double bohnen; //in g

    //Wasserbehaeleter Groesse = 800ml
    int wasser; // in ml

    //Dreck des Wasserbehaelters max 100%; Reinigung nur wenn leer
    int dreck; //in %

    //Kaffeesatzbehaelter : max 600g; nach jeder nutzung += Masse verwendeten Kaffees
    //                         V-> Kein Kaffee kann mehr gezogen werden
    double kaffeesatz; //in g

    public void bohnenAuffuellen(double menge) {
        if (this.bohnen + menge <= 350) {
            this.bohnen += menge;
            System.out.println("Bohnen: " + this.bohnen + " g");
        } else {
            System.out.println("Exception in thread \"bohnenAuffuellen\" java.lang.BeansOverflowError");
        }
    }

    public void bohnenLeeren() {
        this.bohnen = 0;
        System.out.println("Bohnen entfernt!");
    }

    public void wasserAuffuellen(int menge) {
        if (this.wasser + menge <= 800) {
            this.wasser += menge;
            System.out.println("Wasser: " + this.wasser + " ml");
        } else {
            System.out.println("Exception in thread \"wasserAuffuellen\" java.lang.WaterOverflowError");
        }
    }

    public void wasserLeeren() {
        this.wasser = 0;
        System.out.println("Wasser entfernt!");
    }

    public void wasserReinigen() {
        if (this.wasser == 0) {
            this.dreck = 0;
            System.out.println("Reinigung Erfolgreich!");
        } else {
            System.out.println("Vor Reinigung des Wasserbehälters das Wasser leeren.");
        }
    }

    public void kaffeesatzLeeren() {
        this.kaffeesatz = 0;
        System.out.println("Kaffeesatz entleert!");
    }

    //Kaffeeintensitaet : 1 - 10
    //Kaffeemenge : 10ml - 200ml
    //Benoetigte Bohnen : 0.5g * Kaffeeintensitaet
    //Nach jedem Prozess : Dreck += 1%
    //Wenn Dreck >= 50% : 25%  Fehler
    //Wenn Dreck >= 75% : 50%  Fehler
    //Wenn Dreck >= 90% : 100% Fehler
    public void kaffeeZiehen(int intensitaet, int menge) {
        boolean fehler = false;
        if (this.kaffeesatz >= 600 || this.dreck >= 90) {
            fehler = true;
        } else if (zufall(1) <= 0.5 && this.dreck >= 75) {
            fehler = true;
        } else if (zufall(1) <= 0.25 && this.dreck >= 50) {
            fehler = true;
        }

        if (fehler) {
            System.out.println("Fehler! Dreck und/oder Kaffeesatz reinigen!");
        } else {
            fehler = false;
            if (intensitaet > 10 || intensitaet < 1 || menge > 200 || menge < 10) {
                fehler = true;
            }

            if (fehler) {
                System.out.println("Fehler! Eingaben überprüfen!");
            } else {
                bohnen -= 0.5 * intensitaet * ((double) menge / 10);
                dreck += 1;
                kaffeesatz += ((double) menge / 10) * 0.5 * intensitaet;
                wasser -= menge;
                System.out.println(menge + "ml Kaffee mit einer Intensitaet von " + intensitaet + " erfolgreich gezogen.");
            }
        }
    }


}
