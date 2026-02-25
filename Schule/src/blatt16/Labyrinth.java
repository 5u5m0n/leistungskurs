package blatt16;

import schisch_visualizer.SchischVisualizer;

import static blatt14.MultiArrays.*;
import static blatt16.Stroeme.*;
import static blatt14.Simulationen.*;

public class Labyrinth {

    static SchischVisualizer sv = new SchischVisualizer();

    public static char[][] leseLabyrinth(int a) {
        String name = "laby0" + a + ".txt";
        return readCharArray(name);
    }

    public static void labyrinthSimulation(char[][] labyrinth) {
        int x = -1;
        int y = -1;
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[i].length; j++) {
                if (labyrinth[i][j] == '9') {
                    x = i;
                    y = j;
                }
            }
        }
        if (x != -1 || istMoeglich(labyrinth)) {
            boolean win = false;
            labyrinth[x][y] = 'P';
            sv.step(labyrinth);
            int n = 0;
            while (!win) {
                System.out.println(zaehlenVier(labyrinth, x, y, '0', false));
                if (zaehlenVier(labyrinth, x, y, '0', false) == 1) {
                    labyrinth[x][y] = '8';
                    if (getNorden(labyrinth, x, y, false) == '0') {
                        labyrinth[x][y - 1] = 'P';
                        y--;
                    } else if (getOsten(labyrinth, x, y, false) == '0') {
                        labyrinth[x + 1][y] = 'P';
                        x++;
                    } else if (getSueden(labyrinth, x, y, false) == '0') {
                        labyrinth[x][y + 1] = 'P';
                        y++;
                    } else if (getWesten(labyrinth, x, y, false) == '0') {
                        labyrinth[x - 1][y] = 'P';
                        x--;
                    }
                } else if (zaehlenVier(labyrinth, x, y, '0', false) == 0) { //TODO: DO DA PROGRAMMING
                    if (zaehlenVier(labyrinth, x, y, '8', false) == 1) {
                        labyrinth[x][y] = 'F';
                        if (getNorden(labyrinth, x, y, false) == '8') {
                            labyrinth[x][y - 1] = 'P';
                            y--;
                        } else if (getOsten(labyrinth, x, y, false) == '8') {
                            labyrinth[x + 1][y] = 'P';
                            x++;
                        } else if (getSueden(labyrinth, x, y, false) == '8') {
                            labyrinth[x][y + 1] = 'P';
                            y++;
                        } else if (getWesten(labyrinth, x, y, false) == '8') {
                            labyrinth[x - 1][y] = 'P';
                            x--;
                        }
                    } else if (zaehlenVier(labyrinth, x, y, '8', false) == 0) {
                        labyrinth[x][y] = 'F';
                        if (getNorden(labyrinth, x, y, false) == 'V') {
                            labyrinth[x][y - 1] = 'P';
                            y--;
                        } else if (getOsten(labyrinth, x, y, false) == '<') {
                            labyrinth[x + 1][y] = 'P';
                            x++;
                        } else if (getSueden(labyrinth, x, y, false) == '^') {
                            labyrinth[x][y + 1] = 'P';
                            y++;
                        } else if (getWesten(labyrinth, x, y, false) == '>') {
                            labyrinth[x - 1][y] = 'P';
                            x--;
                        }
                    } else {
                        if (getNorden(labyrinth, x, y, false) == '8') {
                            labyrinth[x][y] = '^';
                            labyrinth[x][y - 1] = 'P';
                            y--;
                        } else if (getOsten(labyrinth, x, y, false) == '8') {
                            labyrinth[x][y] = '>';
                            labyrinth[x + 1][y] = 'P';
                            x++;
                        } else if (getSueden(labyrinth, x, y, false) == '8') {
                            labyrinth[x][y] = 'V';
                            labyrinth[x][y + 1] = 'P';
                            y++;
                        } else if (getWesten(labyrinth, x, y, false) == '8') {
                            labyrinth[x][y] = '<';
                            labyrinth[x - 1][y] = 'P';
                            x--;
                        }
                    }
                } else {
                    if (getNorden(labyrinth, x, y, false) == '0') {
                        labyrinth[x][y] = '^';
                        labyrinth[x][y - 1] = 'P';
                        y--;
                    } else if (getOsten(labyrinth, x, y, false) == '0') {
                        labyrinth[x][y] = '>';
                        labyrinth[x + 1][y] = 'P';
                        x++;
                    } else if (getSueden(labyrinth, x, y, false) == '0') {
                        labyrinth[x][y] = 'V';
                        labyrinth[x][y + 1] = 'P';
                        y++;
                    } else if (getWesten(labyrinth, x, y, false) == '0') {
                        labyrinth[x][y] = '<';
                        labyrinth[x - 1][y] = 'P';
                        x--;
                    }
                }
                sv.step(labyrinth);
                n++;
                if (zaehlenVier(labyrinth, x, y, '7', false) > 0) {
                    win = true;
                } else if (n > 900) {
                    break;
                }
            }
        }
        sv.start();
    }

    public static boolean istMoeglich(char[][] labyrinth) {
        int x1 = -1;
        int y1 = -1;
        int x2 = -1;
        int y2 = -1;
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[i].length; j++) {
                if (labyrinth[i][j] == '9') {
                    x1 = i;
                    y1 = j;
                } else if (labyrinth[i][j] == '7') {
                    x2 = i;
                    y2 = j;
                }
            }
        }
        if (x1 != -1 && x2 != -1) {
            boolean identisch = false;
            while (!identisch) {
                char[][] labyrinthB = copy2DCharArray(labyrinth);
                for (int i = 0; i < labyrinth.length; i++) {
                    for (int j = 0; j < labyrinth[i].length; j++) {
                        if (labyrinth[i][j] == '9' && getSueden(labyrinth, i, j, false) == '0') {
                            labyrinthB[i][j + 1] = '9';
                        }
                        if (labyrinth[i][j] == '9' && getOsten(labyrinth, i, j, false) == '0') {
                            labyrinthB[i + 1][j] = '9';
                        }
                        if (labyrinth[i][j] == '9' && getWesten(labyrinth, i, j, false) == '0') {
                            labyrinthB[i - 1][j] = '9';
                        }
                        if (labyrinth[i][j] == '9' && getNorden(labyrinth, i, j, false) == '0') {
                            labyrinthB[i][j - 1] = '9';
                        }
                    }

                }
                if (istIdentisch(labyrinth, labyrinthB)) {
                    identisch = true;
                } else {
                    labyrinth = copy2DCharArray(labyrinthB);
                }
            }
            if (zaehlenVier(labyrinth, x2, y2, '9', false) > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] labyrinth = leseLabyrinth(5);
        labyrinthSimulation(labyrinth);
    }
}
