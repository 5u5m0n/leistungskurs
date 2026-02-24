package blatt16;

import java.io.*;
import java.util.Scanner;

import static blatt07.ArbeitMitArrays.printArray;

public class Suchkommando {
    static Scanner sc = new Scanner(System.in);
    static String[] arr = null;
    static boolean g = true;

    public static String[] suchen(String s) {
        suchenOrdner("/home", s);
        return arr;
    }

    public static void suchenOrdner(String f, String s) {
        File files = new File(f);
        File[] filesList = files.listFiles();
        try {
            for (File file : filesList) {
                System.out.println(file.getAbsolutePath());
                if (file.getName().equals(s) && g) {
                    if (gefunden(file.getAbsolutePath())) {
                        break;
                    }
                } else if (file.isDirectory() && g && !file.getName().equals("z:") && !file.getName().equals("s:")) {
                    char[] path = file.getAbsolutePath().toCharArray();
                    int n = 0;
                    for (int i = 0; i < path.length; i++) {
                        if (path[i] == '/') {
                            n++;
                        }
                    }
                    System.out.println(n);
                    if (n <= 15) {
                        suchenOrdner(file.getAbsolutePath(), s);
                    }
                } else if (!g) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean gefunden(String f) {
        String[] temp;
        if (arr != null) {
            temp  = new String[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
        } else {
            temp  = new String[1];
        }

        temp[temp.length - 1] = f;
        arr = temp;
        System.out.println(f + "; Weitersuchen? [j/n]");
        char c = sc.next().charAt(0);
        if (c == 'n') {
            g = false;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        printArray(suchen("Advanced Dungeons & Dragons_ Unearthed Arcana (1e).pdf"));
    }
}
