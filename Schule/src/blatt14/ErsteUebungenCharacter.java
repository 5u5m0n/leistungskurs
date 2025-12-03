package blatt14;

import schisch_visualizer.*;

import static blatt14.MultiArrays.createEmpty2DCharArray;

public class ErsteUebungenCharacter {
    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        char[][] map = createEmpty2DCharArray(11, 14);
        sv.step(map);
        for (int j = 0; j < map.length; j++) {
            map[j][0] = '1';
            map[j][map[j].length - 1] = '1';
        }
        sv.step(map);
        for (int j = 0; j < map[0].length; j++) {
            map[0][j] = '1';
            map[map.length - 1][j] = '1';
        }
        sv.step(map);
        for (int j = 0; j < map[0].length-2; j++) {
            map[2][j] = '1';
            map[map.length-3][j] = '1';
        }
        sv.step(map);
        for (int j = 4; j < 7; j++) {
            map[j][3] = '1';
            map[j][5] = '1';
        }
        sv.step(map);
        for (int j = 3; j < 8; j++) {
            if (j != 5) {
                map[j][map[j].length-3] = '1';
            }
        }
        sv.step(map);
        map[5][map[0].length-2] = 'P';
        sv.step(map);
        sv.start();
    }
}
