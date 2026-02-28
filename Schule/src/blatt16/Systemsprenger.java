package blatt16;

import java.io.*;
import static blatt13.Zufall.*;

public class Systemsprenger {
    public static void sprengen(int n) {
        File dir = new File("/home/simon/IdeaProjects/leistungskurs/Schule/sprengtest");
        if (!dir.exists()) {
            dir.mkdir();
        }
        for (int i = 0; i < n; i++) {
            try {
                char[] charr = new char[20];
                charr[0] = 'S';
                charr[1] = 'P';
                charr[2] = 'R';
                charr[3] = '_';
                for (int j = 4; j < charr.length; j++) {
                    int z = zufallGanz(65, 90);
                    charr[j] = (char) z;
                }
                String s = new String(charr);
                File file = new File("/home/simon/IdeaProjects/leistungskurs/Schule/sprengtest/" + s + ".txt");
                FileWriter fw = new FileWriter(file);
                System.out.println(file.canWrite());
                char[] charrs = new char[1024];
                for (int j = 0; j < charrs.length; j++) {
                    int z = zufallGanz(32, 127);
                    charrs[j] = (char) z;
                    z = 46;
                }
                fw.write(charrs);
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void reinigen() {
        File dir = new File("/home/simon/IdeaProjects/leistungskurs/Schule/sprengtest");
        File[] files = dir.listFiles();
        for (File file : files) {
            char[] name = file.getName().toCharArray();
            if (name[0] == 'S' && name[1] == 'P' && name[2] == 'R' && name[3] == '_') {
                try {
                    file.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        sprengen(10);
    }
}
