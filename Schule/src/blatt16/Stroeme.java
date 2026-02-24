package blatt16;

import java.io.*;

import static blatt14.MultiArrays.print2DArray;

public class Stroeme {

    public static char[][] readCharArray(String name) {
        try {
            File dir = new File("leistungskurs" + File.separatorChar + "Schule" + File.separatorChar + "io");
            if (!dir.exists()) {
                dir.mkdir();
            }
            File file = new File(dir.getAbsolutePath() + File.separatorChar + name);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            char[][] arr = new char[a][b];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = br.readLine().charAt(0);
                }
            }
            return arr;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean writeCharArray(char[][] arr, String name) {
        try {
            File dir = new File("leistungskurs" + File.separatorChar + "Schule" + File.separatorChar + "io");
            if (!dir.exists()) {
                dir.mkdir();
            }
            File file = new File(dir.getAbsolutePath() + File.separatorChar + name);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter((fw));
            String a = arr.length + "";
            bw.write(a);
            bw.newLine();
            a = arr[0].length + "";
            bw.write(a);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    bw.newLine();
                    bw.write(arr[i][j]);
                }
            }
            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] arr = readCharArray("Test03.txt");
        print2DArray(arr);
    }
}
