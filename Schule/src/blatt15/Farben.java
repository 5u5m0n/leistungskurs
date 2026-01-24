package blatt15;

import schisch_visualizer.SchischVisualizer;

import static blatt14.MultiArrays.*;
import static blatt13.Zufall.*;
import static blatt14.Simulationen.*;

public class Farben {

    static int[] reihenfolge;
    static int[] spielerPosX;
    static int[] spielerPosY;
    static char[][] spielfeld;

    static SchischVisualizer sv = new SchischVisualizer();

    public static void initialisiereSpielfeld(int a, int b) {
        spielfeld = createEmpty2DCharArray(a, b);
        reihenfolge = new int[8];
        spielerPosX = new int[8];
        spielerPosY = new int[8];
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                if (i == 0 || j == 0 || i == a - 1 || j == b - 1) {
                    spielfeld[i][j] = '8';
                }
            }
        }
        sv.step(spielfeld);
    }

    public static void startPositionen() {
        for (int i = 0; i < spielerPosY.length; i++) {
            spielerPosY[i] = zufallGanz(1, spielfeld.length - 2);
            if (i < 4) {
                spielerPosX[i] = zufallGanz(1, spielfeld.length/2);
            } else {
                spielerPosX[i] = zufallGanz(spielfeld.length/2 + 1, spielfeld.length - 2);
            }
            spielfeld[spielerPosX[i]][spielerPosY[i]] = 'P';
        }
        sv.step(spielfeld);
    }

    public static int zaehlen(int team) {
        if (team >= 0 && team <= 2) {
            int n = 0;
            char[] f = new char[]{' ','7', '9'};
            for (int i = 0; i < spielfeld.length; i++) {
                for (int j = 0; j < spielfeld[i].length; j++) {
                    if (spielfeld[i][j] == f[team]) {
                        n++;
                    }
                }
            }
            for (int i = 1; i < 4; i++) {
                if (team == 1 && spielerPosX[i] > -1) {
                    n++;
                } else if (team == 2 && spielerPosX[i + 4] > -1) {
                    n++;
                }
            }
            return n;
        } else {
            return -1;
        }

    }

    public static void respawn(int spielernummer) {
        if (spielernummer >= 0 && spielernummer <= 7) {
            char[] f = new char[]{'7', '7', '7', '7', '9', '9', '9', '9'};
            int[] team = new int[]{1, 1, 1, 1, 2, 2, 2, 2};
            int sp = 0;
            for (int i = 1; i < 4; i++) {
                if (team[spielernummer] == 1 && spielerPosX[i] > -1) {
                    sp++;
                } else if (team[spielernummer] == 2 && spielerPosX[i + 4] > -1) {
                    sp++;
                }
            }
            int n = zaehlen(team[spielernummer]) - sp;
            if (n > 0) {
                int[][] p = new int[n][2];
                int k = 0;
                for (int i = 0; i < spielfeld.length; i++) {
                    for (int j = 0; j < spielfeld[i].length; j++) {
                        if (spielfeld[i][j] == f[spielernummer]) {
                            if (k < p.length) {
                                p[k][0] = i;
                                p[k][1] = j;
                                k++;
                            }
                        }
                    }
                }
                int z;
                if (p.length > 1) {
                    z = zufallGanz(p.length - 1);
                } else {
                    z = 0;
                }
                spielerPosX[spielernummer] = p[z][0];
                spielerPosY[spielernummer] = p[z][1];
            } else {
                while (true) {
                    spielerPosX[spielernummer] = zufallGanz(1, spielfeld.length - 1);
                    spielerPosY[spielernummer] = zufallGanz(1, spielfeld[0].length - 1);
                    if (spielfeld[spielerPosX[spielernummer]][spielerPosY[spielernummer]] != 'P' && spielfeld[spielerPosX[spielernummer]][spielerPosY[spielernummer]] != '8') {
                        break;
                    }
                }
            }
            spielfeld[spielerPosX[spielernummer]][spielerPosY[spielernummer]] = 'P';
            sv.step(spielfeld);
        }
    }

    public static void reihenfolge() {
        for (int i = 0; i < reihenfolge.length; i++) {
            reihenfolge[i] = -1;
        }
        for (int i = 0; i < reihenfolge.length; i++) {
            boolean c = true;
            while (c) {
                c = false;
                int z = zufallGanz(1, 8) - 1;
                reihenfolge[i] = z;
                for (int k = 0; k < i; k++) {
                    if (reihenfolge[k] == reihenfolge[i]) {
                        c = true;
                    }
                }
            }
        }
    }

    public static void move(int sp, int r) {
        if (spielerPosX[sp] > -1 && spielerPosY[sp] > -1) {
            char[] f = new char[]{'7', '7', '7', '7', '9', '9', '9', '9'};
            spielfeld[spielerPosX[sp]][spielerPosY[sp]] = f[sp];
            if (r == 1 && getNorden(spielfeld, spielerPosX[sp], spielerPosY[sp], false) != '8') {
                if (getNorden(spielfeld, spielerPosX[sp], spielerPosY[sp], false) == 'P') {
                    int[] team = new int[]{1, 1, 1, 1, 2, 2, 2, 2};
                    for (int i = 0; i < spielerPosX.length; i++) {
                        if (spielerPosX[i] == spielerPosX[sp] && spielerPosY[i] == spielerPosY[sp] - 1) {
                            if (team[i] != team[sp]) {
                                spielerPosX[i] = -1;
                                spielerPosY[i] = -1;
                                spielerPosY[sp]--;
                            }
                        }
                    }
                } else {
                    spielerPosY[sp]--;
                }
            } else if (r == 2 && getOsten(spielfeld, spielerPosX[sp], spielerPosY[sp], false) != '8') {
                if (getOsten(spielfeld, spielerPosX[sp], spielerPosY[sp], false) == 'P') {
                    int[] team = new int[]{1, 1, 1, 1, 2, 2, 2, 2};
                    for (int i = 0; i < spielerPosX.length; i++) {
                        if (spielerPosX[i] == spielerPosX[sp] + 1 && spielerPosY[i] == spielerPosY[sp]) {
                            if (team[i] != team[sp]) {
                                spielerPosX[i] = -1;
                                spielerPosY[i] = -1;
                                spielerPosX[sp]++;
                            }
                        }
                    }
                } else {
                    spielerPosX[sp]++;
                }
            } else if (r == 3 && getSueden(spielfeld, spielerPosX[sp], spielerPosY[sp], false) != '8') {
                if (getSueden(spielfeld, spielerPosX[sp], spielerPosY[sp], false) == 'P') {
                    int[] team = new int[]{1, 1, 1, 1, 2, 2, 2, 2};
                    for (int i = 0; i < spielerPosX.length; i++) {
                        if (spielerPosX[i] == spielerPosX[sp] && spielerPosY[i] == spielerPosY[sp] + 1) {
                            if (team[i] != team[sp]) {
                                spielerPosX[i] = -1;
                                spielerPosY[i] = -1;
                                spielerPosY[sp]++;
                            }
                        }
                    }
                } else {
                    spielerPosY[sp]++;
                }
            } else if (r == 4 && getWesten(spielfeld, spielerPosX[sp], spielerPosY[sp], false) != '8') {
                if (getWesten(spielfeld, spielerPosX[sp], spielerPosY[sp], false) == 'P') {
                    int[] team = new int[]{1, 1, 1, 1, 2, 2, 2, 2};
                    for (int i = 0; i < spielerPosX.length; i++) {
                        if (spielerPosX[i] == spielerPosX[sp] - 1 && spielerPosY[i] == spielerPosY[sp]) {
                            if (team[i] != team[sp]) {
                                spielerPosX[i] = -1;
                                spielerPosY[i] = -1;
                                spielerPosX[sp]--;
                            }
                        }
                    }
                } else {
                    spielerPosX[sp]--;
                }
            }
            spielfeld[spielerPosX[sp]][spielerPosY[sp]] = 'P';
        }

    }

    public static char[] sichtfeld(int sp) {
        char[] charr = new char[12];
        charr[0] = getNorden(spielfeld, spielerPosX[sp], spielerPosY[sp], false);
        charr[1] = getOsten(spielfeld, spielerPosX[sp], spielerPosY[sp], false);
        charr[2] = getSueden(spielfeld, spielerPosX[sp], spielerPosY[sp], false);
        charr[3] = getWesten(spielfeld, spielerPosX[sp], spielerPosY[sp], false);
        charr[4] = getNordOst(spielfeld, spielerPosX[sp], spielerPosY[sp], false);
        charr[5] = getSuedOst(spielfeld, spielerPosX[sp], spielerPosY[sp], false);
        charr[6] = getSuedWest(spielfeld, spielerPosX[sp], spielerPosY[sp], false);
        charr[7] = getNordWest(spielfeld, spielerPosX[sp], spielerPosY[sp], false);
        charr[8] = getNorden(spielfeld, spielerPosX[sp], spielerPosY[sp] - 1, false);
        charr[9] = getOsten(spielfeld, spielerPosX[sp] + 1, spielerPosY[sp], false);
        charr[10] = getSueden(spielfeld, spielerPosX[sp], spielerPosY[sp] + 1, false);
        charr[11] = getWesten(spielfeld, spielerPosX[sp] - 1, spielerPosY[sp], false);
        return charr;
    }

    public static boolean istTeammate(int sp, int x, int y) {
        int[] team = new int[]{1, 1, 1, 1, 2, 2, 2, 2};
        for (int i = 0; i < spielerPosX.length; i++) {
            if (spielerPosX[i] == x && spielerPosY[i] == y) {
                if (team[i] != team[sp]) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void zugEins(int sp) {
        if (spielerPosX[sp] > -1) {
            char[] sicht = sichtfeld(sp);
            int counter = 0;
            for (int i = 0; i < 4; i++) {
                if (spielerPosX[i] < spielerPosX[sp] && spielerPosX[i] > -1) {
                    counter++;
                }
            }
            boolean c = true;
            if (counter > 1) { //Defensive
                if (spielerPosX[sp] > 1) {
                    char[] charr = new char[]{'P', '9', ' '};
                    int k = 0;
                    do {
                        if (sicht[3] == charr[k]) {
                            if (!istTeammate(sp, spielerPosX[sp] - 1, spielerPosY[sp])) {
                                move(sp, 4);
                                c = false;
                            }
                        } else if (sicht[2] == charr[k]) {
                            if (!istTeammate(sp, spielerPosX[sp], spielerPosY[sp] + 1)) {
                                move(sp, 3);
                                c = false;
                            }
                        } else if (sicht[0] == charr[k]) {
                            if (!istTeammate(sp, spielerPosX[sp], spielerPosY[sp] - 1)) {
                                move(sp, 1);
                                c = false;
                            }
                        } else if (sicht[1] == charr[k]) {
                            if (!istTeammate(sp, spielerPosX[sp] + 1, spielerPosY[sp])) {
                                move(sp, 2);
                                c = false;
                            }
                        } else {
                            k++;
                            if (k > 2) {
                                move(sp, 3);
                                c = false;
                            }
                        }
                    } while (c);
                } else {
                    char[] charr = new char[]{'P', '9'};
                    int k = 0;
                    do {
                        if (sicht[3] == charr[k]) {
                            if (!istTeammate(sp, spielerPosX[sp] - 1, spielerPosY[sp])) {
                                move(sp, 4);
                                c = false;
                            }
                        } else if (sicht[2] == charr[k]) {
                            if (!istTeammate(sp, spielerPosX[sp], spielerPosY[sp] + 1)) {
                                move(sp, 3);
                                c = false;
                            }
                        } else if (sicht[0] == charr[k]) {
                            if (!istTeammate(sp, spielerPosX[sp], spielerPosY[sp] - 1)) {
                                move(sp, 1);
                                c = false;
                            }
                        } else if (sicht[1] == charr[k]) {
                            if (!istTeammate(sp, spielerPosX[sp] + 1, spielerPosY[sp])) {
                                move(sp, 2);
                                c = false;
                            }
                        } else {
                            k++;
                        }
                    } while (c && k <= 1);
                    if (c) {
                        int min;
                        if (sp == 0) {
                            min = 1;
                        } else {
                            min = 0;
                        }
                        int dir;
                        for (int i = 0; i < 4; i++) {
                            if (spielerPosX[i] < spielerPosX[min] && i != sp) {
                                min = i;
                            }
                        }
                        if (spielerPosY[sp] < spielerPosY[min]) {
                            dir = 1;
                        } else {
                            dir = 3;
                        }
                        if (sicht[(-1 + dir)] == '8') {
                            move(sp, 1);
                        } else {
                            move(sp, dir);
                        }
                    }
                }
            } else { //Offensive
                char[] charr = new char[]{'P', '9', ' '};
                int k = 0;
                do {
                    if (sicht[1] == charr[k]) {
                        if (!istTeammate(sp, spielerPosX[sp] - 1, spielerPosY[sp])) {
                            move(sp, 4);
                            c = false;
                        }
                    } else if (sicht[0] == charr[k]) {
                        if (!istTeammate(sp, spielerPosX[sp], spielerPosY[sp] + 1)) {
                            move(sp, 3);
                            c = false;
                        }
                    } else if (sicht[2] == charr[k]) {
                        if (!istTeammate(sp, spielerPosX[sp], spielerPosY[sp] - 1)) {
                            move(sp, 1);
                            c = false;
                        }
                    } else if (sicht[3] == charr[k]) {
                        if (!istTeammate(sp, spielerPosX[sp] + 1, spielerPosY[sp])) {
                            move(sp, 2);
                            c = false;
                        }
                    } else {
                        k++;
                        if (k > 2) {
                            move(sp, 1);
                            c = false;
                        }
                    }
                } while (c);
            }
        }
        sv.step(spielfeld);
    }

    public static void zugZwei(int sp) {
        if (spielerPosX[sp] > -1) {
            char[] sicht = sichtfeld(sp);
            int counter = 0;
            for (int i = 4; i < 8; i++) {
                if (spielerPosX[i] > spielerPosX[sp] && spielerPosX[i] > -1) {
                    counter++;
                }
            }
            boolean c = true;
            if (counter > 1) { //Defensive
                if (spielerPosX[sp] > 1) {
                    char[] charr = new char[]{'P', '7', ' '};
                    int k = 0;
                    do {
                        if (sicht[1] == charr[k]) {
                            if (!istTeammate(sp, spielerPosX[sp] - 1, spielerPosY[sp])) {
                                move(sp, 4);
                                c = false;
                            }
                        } else if (sicht[2] == charr[k]) {
                            if (!istTeammate(sp, spielerPosX[sp], spielerPosY[sp] + 1)) {
                                move(sp, 3);
                                c = false;
                            }
                        } else if (sicht[0] == charr[k]) {
                            if (!istTeammate(sp, spielerPosX[sp], spielerPosY[sp] - 1)) {
                                move(sp, 1);
                                c = false;
                            }
                        } else if (sicht[3] == charr[k]) {
                            if (!istTeammate(sp, spielerPosX[sp] + 1, spielerPosY[sp])) {
                                move(sp, 2);
                                c = false;
                            }
                        } else {
                            k++;
                            if (k > 2) {
                                move(sp, 1);
                                c = false;
                            }
                        }
                    } while (c);
                } else {
                    char[] charr = new char[]{'P', '7'};
                    int k = 0;
                    do {
                        if (sicht[1] == charr[k]) {
                            if (!istTeammate(sp, spielerPosX[sp] - 1, spielerPosY[sp])) {
                                move(sp, 4);
                                c = false;
                            }
                        } else if (sicht[2] == charr[k]) {
                            if (!istTeammate(sp, spielerPosX[sp], spielerPosY[sp] + 1)) {
                                move(sp, 3);
                                c = false;
                            }
                        } else if (sicht[0] == charr[k]) {
                            if (!istTeammate(sp, spielerPosX[sp], spielerPosY[sp] - 1)) {
                                move(sp, 1);
                                c = false;
                            }
                        } else if (sicht[3] == charr[k]) {
                            if (!istTeammate(sp, spielerPosX[sp] + 1, spielerPosY[sp])) {
                                move(sp, 2);
                                c = false;
                            }
                        } else {
                            k++;
                        }
                    } while (c && k <= 1);
                    if (c) {
                        int max;
                        if (sp == 4) {
                            max = 5;
                        } else {
                            max = 4;
                        }
                        int dir;
                        for (int i = 4; i < 8; i++) {
                            if (spielerPosX[i] > spielerPosX[max] && i != sp) {
                                max = i;
                            }
                        }
                        if (spielerPosY[sp] < spielerPosY[max]) {
                            dir = 1;
                        } else {
                            dir = 3;
                        }
                        if (sicht[(-1 + dir)] == '8') {
                            move(sp, 1);
                        } else {
                            move(sp, dir);
                        }
                    }
                }
            } else { //Offensive
                char[] charr = new char[]{'P', '7', ' '};
                int k = 0;
                do {
                    if (sicht[3] == charr[k]) {
                        if (!istTeammate(sp, spielerPosX[sp] - 1, spielerPosY[sp])) {
                            move(sp, 4);
                            c = false;
                        }
                    } else if (sicht[0] == charr[k]) {
                        if (!istTeammate(sp, spielerPosX[sp], spielerPosY[sp] + 1)) {
                            move(sp, 3);
                            c = false;
                        }
                    } else if (sicht[2] == charr[k]) {
                        if (!istTeammate(sp, spielerPosX[sp], spielerPosY[sp] - 1)) {
                            move(sp, 1);
                            c = false;
                        }
                    } else if (sicht[1] == charr[k]) {
                        if (!istTeammate(sp, spielerPosX[sp] + 1, spielerPosY[sp])) {
                            move(sp, 2);
                            c = false;
                        }
                    } else {
                        k++;
                        if (k > 2) {
                            move(sp, 3);
                            c = false;
                        }
                    }
                } while (c);
            }
        }
        sv.step(spielfeld);
    }

    public static void simulation(int a, int b, int z) {
        initialisiereSpielfeld(a, b);
        startPositionen();
        for (int i = 0; i < z; i++) {
            reihenfolge();
            for (int j = 0; j < reihenfolge.length; j++) {
                if (reihenfolge[j] < 4) {
                    zugEins(reihenfolge[j]);
                } else {
                    zugZwei(reihenfolge[j]);
                }
            }
            for (int j = 0; j < spielerPosX.length; j++) {
                if (spielerPosX[j] > 0) {
                    respawn(j);
                }
            }
        }
        int ergebnisEins = zaehlen(1);
        int ergebnisZwei = zaehlen(2);
        System.out.println("Ergebnis Team 1: " + ergebnisEins);
        System.out.println("Ergebnis Team 2: " + ergebnisZwei);
        if (ergebnisEins > ergebnisZwei) {
            System.out.println("Sieger: Team 1!");
        } else if (ergebnisZwei > ergebnisEins) {
            System.out.println("Sieger: Team 2!");
        } else {
            System.out.println("Unentschieden!");
        }
        sv.start();
    }

    public static void main(String[] args) {
        simulation(40, 40, 100);
    }
}
