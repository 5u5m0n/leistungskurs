package blatt29.aufgabe4;

public enum WaffenKlasse {
    SCHWERT(Attribut.STAERKE),
    SPEER(Attribut.STAERKE),
    AXT(Attribut.STAERKE),
    HAMMER(Attribut.STAERKE),
    RAPIER(Attribut.GESCHICKLICHKEIT),
    DOLCH(Attribut.GESCHICKLICHKEIT),
    BOGEN(Attribut.GESCHICKLICHKEIT),
    ARMBRUST(Attribut.GESCHICKLICHKEIT),
    MAGIERSTAB(Attribut.MSTAERKE);

    final Attribut att;

    WaffenKlasse(Attribut att) {
        this.att = att;
    }
}
