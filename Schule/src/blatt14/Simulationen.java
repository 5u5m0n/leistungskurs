package blatt14;

import static blatt13.Zufall.zufall;
import static blatt13.Zufall.zufallGanz;
import static blatt14.MultiArrays.createEmpty2DCharArray;

import schisch_visualizer.*;

public class Simulationen {

    /**
     * Füllt einen gegebeneb 2D-Zeichen-Array zufällig mit Zeichen.
     * @param chars Array
     * @param charr Einzusetzendes Zeichen
     * @param p Wahrscheinlichkeit (0 - 1)
     */
    public static void fuellen(char[][] chars, char charr, double p) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                if (zufall(1) <= p) {
                    chars[i][j] = charr;
                }
            }
        }
    }

    /**
     * Platziert ein gegebenes Zeichen an eine zufällige Stelle in einem 2D-Zeichen-Array
     * @param chars Array
     * @param charr Zeichen
     * @param dopplung True: Ist auf dem zufällig ausgewählten Feld bereits das gegebene Zeichen, wird stattdessen ein neues gewählt
     */
    public static void platzieren(char[][] chars, char charr, boolean dopplung) {
        int x = zufallGanz(0, chars.length);
        int y = zufallGanz(0, chars[x].length);
        char h = chars[x][y];
        while (h == charr && dopplung) {
            x = zufallGanz(0, chars.length);
            y = zufallGanz(0, chars[x].length);
            h = chars[x][y];
        }
        chars[x][y] = charr;
    }

    /**
     * Gibt das Zeichen, das nördlich der gegebenen Position zurück.
     * @param chars Array
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param rand True: Es wird über den Rand hinaus geguckt.
     * @return Zeichen
     */
    public static char getNorden(char[][] chars, int x, int y, boolean rand) {
        int ys = y - 1;
        if (ys < 0) {
            if (rand) {
                ys = chars[x].length - 1;
            } else {
                return '-';
            }
        }
        char s = chars[x][ys];
        return s;
    }

    /**
     * Gibt das Zeichen, das südlich der gegebenen Position zurück.
     * @param chars Array
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param rand True: Es wird über den Rand hinaus geguckt.
     * @return Zeichen
     */
    public static char getSueden(char[][] chars, int x, int y, boolean rand) {
        int ys = y + 1;
        if (ys > chars[x].length - 1) {
            if (rand) {
                ys = 0;
            } else {
                return '-';
            }
        }
        char s = chars[x][ys];
        return s;
    }

    /**
     * Gibt das Zeichen, das westlich der gegebenen Position zurück.
     * @param chars Array
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param rand True: Es wird über den Rand hinaus geguckt.
     * @return Zeichen
     */
    public static char getWesten(char[][] chars, int x, int y, boolean rand) {
        int xs = x - 1;
        if (xs < 0) {
            if (rand) {
                xs = chars.length - 1;
            } else {
                return '-';
            }
        }
        char s = chars[xs][y];
        return s;
    }

    /**
     * Gibt das Zeichen, das östlich der gegebenen Position zurück.
     * @param chars Array
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param rand True: Es wird über den Rand hinaus geguckt.
     * @return Zeichen
     */
    public static char getOsten(char[][] chars, int x, int y, boolean rand) {
        int xs = x + 1;
        if (xs > chars.length - 1) {
            if (rand) {
                xs = 0;
            } else {
                return '-';
            }
        }
        char s = chars[xs][y];
        return s;
    }

    /**
     * Gibt das Zeichen, das nordwestlich der gegebenen Position zurück.
     * @param chars Array
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param rand True: Es wird über den Rand hinaus geguckt.
     * @return Zeichen
     */
    public static char getNordWest(char[][] chars, int x, int y, boolean rand) {
        int ys = y - 1;
        if (ys < 0) {
            if (rand) {
                ys = chars[x].length - 1;
            } else {
                return '-';
            }
        }
        int xs = x - 1;
        if (xs < 0) {
            if (rand) {
                xs = chars.length - 1;
            } else {
                return '-';
            }
        }
        char s = chars[xs][ys];
        return s;
    }

    /**
     * Gibt das Zeichen, das nordöstlich der gegebenen Position zurück.
     * @param chars Array
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param rand True: Es wird über den Rand hinaus geguckt.
     * @return Zeichen
     */
    public static char getNordOst(char[][] chars, int x, int y, boolean rand) {
        int ys = y - 1;
        if (ys < 0) {
            if (rand) {
                ys = chars[x].length - 1;
            } else {
                return '-';
            }
        }
        int xs = x + 1;
        if (xs > chars.length - 1) {
            if (rand) {
                xs = 0;
            } else {
                return '-';
            }
        }
        char s = chars[xs][ys];
        return s;
    }

    /**
     * Gibt das Zeichen, das südwestlich der gegebenen Position zurück.
     * @param chars Array
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param rand True: Es wird über den Rand hinaus geguckt.
     * @return Zeichen
     */
    public static char getSuedWest(char[][] chars, int x, int y, boolean rand) {
        int ys = y + 1;
        if (ys > chars[x].length - 1) {
            if (rand) {
                ys = 0;
            } else {
                return '-';
            }
        }
        int xs = x - 1;
        if (xs < 0) {
            if (rand) {
                xs = chars.length - 1;
            } else {
                return '-';
            }
        }
        char s = chars[xs][ys];
        return s;
    }

    /**
     * Gibt das Zeichen, das südöstlich der gegebenen Position zurück.
     * @param chars Array
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param rand True: Es wird über den Rand hinaus geguckt.
     * @return Zeichen
     */
    public static char getSuedOst(char[][] chars, int x, int y, boolean rand) {
        int ys = y + 1;
        if (ys > chars[x].length - 1) {
            if (rand) {
                ys = 0;
            } else {
                return '-';
            }
        }
        int xs = x + 1;
        if (xs > chars.length - 1) {
            if (rand) {
                xs = 0;
            } else {
                return '-';
            }
        }
        char s = chars[xs][ys];

        return s;
    }

    /**
     * Zählt die Anzahl der Felder Nord-/Süd-/West-/Östlich von der gegebenen Position zurück, dieein gegebenes Zeichen enthalten
     * @param chars Array
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param charr Zeichen
     * @param rand True: Es wird über den Rand hinaus geguckt.
     * @return Anzahl
     */
    public static int zaehlenVier(char[][] chars, int x, int y, char charr, boolean rand) {
        int i = 0;
        if (getNorden(chars, x, y, rand) == charr) {
            i++;
        }
        if (getSueden(chars, x, y, rand) == charr) {
            i++;
        }
        if (getWesten(chars, x, y, rand) == charr) {
            i++;
        }
        if (getOsten(chars, x, y, rand) == charr) {
            i++;
        }
        return i;
    }

    /**
     * Zählt die Anzahl der Felder Nord-/Süd-/West-/Östlich und Nordwest-/Südwest-/Nordöst-/Südöstlich von der gegebenen Position zurück, dieein gegebenes Zeichen enthalten
     * @param chars Array
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param charr Zeichen
     * @param rand True: Es wird über den Rand hinaus geguckt.
     * @return Anzahl
     */
    public static int zaehlenAcht(char[][] chars, int x, int y, char charr, boolean rand) {
        int i = 0;
        if (getNordWest(chars, x, y, rand) == charr) {
            i++;
        }
        if (getSuedWest(chars, x, y, rand) == charr) {
            i++;
        }
        if (getNordOst(chars, x, y, rand) == charr) {
            i++;
        }
        if (getSuedOst(chars, x, y, rand) == charr) {
            i++;
        }
        return i + zaehlenVier(chars, x, y, charr, rand);
    }

    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        char[][] chars = createEmpty2DCharArray(20, 20);
        sv.step(chars);
        fuellen(chars, '1', 0.5);
        sv.step(chars);
        fuellen(chars, '3', 0.5);
        sv.step(chars);
        chars[5][5] = 'P';
        sv.step(chars);
        sv.start();
        System.out.println(getNorden(chars, 5, 5, true));
        System.out.println(getSueden(chars, 5, 5, true));
        System.out.println(getWesten(chars, 5, 5, true));
        System.out.println(getOsten (chars, 5, 5, true));
        System.out.println(getNordWest(chars, 5, 5, true));
        System.out.println(getNordOst(chars, 5, 5, true));
        System.out.println(getSuedWest(chars, 5, 5, true));
        System.out.println(getSuedOst(chars, 5, 5, true));
        System.out.println(zaehlenVier(chars, 5, 5, '1', true));
        System.out.println(zaehlenAcht(chars, 5, 5, '1', true));
    }
}
