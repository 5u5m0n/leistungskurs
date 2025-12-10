package blatt14;

import schisch_visualizer.SchischVisualizer;

import static blatt14.MultiArrays.*;
import static blatt13.Zufall.*;
import static blatt14.Simulationen.*;

public class OasenSuche {

    static char[][] spielfeld;
    static int playerX;
    static int playerY;
    static SchischVisualizer sv = new SchischVisualizer();
    static int energiewert = 50;

    /**
     * Initialisiert das Spielfeld
     * @param a Breite
     * @param b Höhe
     */
    public static void initialisiereSpielfeld(int a, int b) {
        spielfeld = createEmpty2DCharArray(a, b);
        sv.step(spielfeld);
    }

    /**
     * Platziert den Spieler auf einer Zufälligen Position auf dem Spielfeld
     */
    public static void zufallsPositionSpieler() {
        if (spielfeld != null) {
            playerX = zufallGanz(spielfeld.length - 1);
            playerY = zufallGanz(spielfeld[0].length - 1);
            spielfeld[playerX][playerY] = 'P';
        }
        sv.step(spielfeld);
    }

    /**
     * Platziert Wasser zufällig auf dem Spielfeld
     * @param p Wahrscheinlichkeit (0-1)
     */
    public static void wasserZufall(double p) {
        if (spielfeld != null && p >= 0 && p <= 1) {
            for (int i = 0; i < spielfeld.length; i++) {
                for (int j = 0; j < spielfeld[i].length; j++) {
                    if (spielfeld[i][j] == ' ' && zufall(1) <= p) {
                        spielfeld[i][j] = '2';
                    }
                }
            }
        }
        sv.step(spielfeld);
    }

    /**
     * Platziert Steine zufällig auf dem Spielfeld
     * @param p Wahrscheinlichkeit (0-1)
     */
    public static void steinZufall(double p) {
        if (spielfeld != null && p >= 0 && p <= 1) {
            for (int i = 0; i < spielfeld.length; i++) {
                for (int j = 0; j < spielfeld[i].length; j++) {
                    if (spielfeld[i][j] == ' ' && zufall(1) <= p) {
                        spielfeld[i][j] = '1';
                    }
                }
            }
        }
        sv.step(spielfeld);
    }

    /**
     * Führt den "Suchalgorithmus" durch
     */
    public static void findeWasser() {
        if (spielfeld != null) {
            boolean w = true;
            char c = ' ';
            while (w) {
                if (zaehlenVier(spielfeld, playerX, playerY, '1', true) == 4) {
                    System.out.println("Press F to Pay Respects.");
                    w = false;
                } else if (zaehlenVier(spielfeld, playerX, playerY, '2', true) > 0) {
                    System.out.println("Überlebt!");
                    break;
                } else {
                    if (getNorden(spielfeld, playerX, playerY, true) == c) {
                        spielfeld[playerX][playerY] = '4';
                        if (playerY - 1 >= 0) {
                            playerY--;
                        } else {
                            playerY = spielfeld[playerX].length - 1;
                        }
                        c = ' ';
                        energiewert--;
                        spielfeld[playerX][playerY] = 'P';
                        sv.step(spielfeld);
                    } else if (getOsten(spielfeld, playerX, playerY, true) == c) {
                        spielfeld[playerX][playerY] = '4';
                        if (playerX + 1 < spielfeld.length) {
                            playerX++;
                        } else {
                            playerX = 0;
                        }
                        c = ' ';
                        energiewert--;
                        spielfeld[playerX][playerY] = 'P';
                        sv.step(spielfeld);
                    } else if (getWesten(spielfeld, playerX, playerY, true) == c) {
                        spielfeld[playerX][playerY] = '4';
                        if (playerX - 1 >= 0) {
                            playerX--;
                        } else {
                            playerX = spielfeld.length - 1;
                        }
                        c = ' ';
                        energiewert--;
                        spielfeld[playerX][playerY] = 'P';
                        sv.step(spielfeld);
                    } else if (getSueden(spielfeld, playerX, playerY, true) == c) {
                        spielfeld[playerX][playerY] = '4';
                        if (playerY + 1 < spielfeld[playerX].length) {
                            playerY++;
                        } else {
                            playerY = 0;
                        }
                        c = ' ';
                        energiewert--;
                        spielfeld[playerX][playerY] = 'P';
                        sv.step(spielfeld);
                    } else {
                        c = '4';
                    }
                    if (energiewert == 0) {
                        System.out.println("Press F to Pay Respects.");
                        w = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        initialisiereSpielfeld(60, 60);
        zufallsPositionSpieler();
        wasserZufall(0.03);
        steinZufall(0.15);
        findeWasser();
        sv.start();

    }
}
