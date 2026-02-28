package blatt18;

import java.io.*;
import java.util.Objects;

import static blatt13.Zufall.zufallGanz;

public class Verzeichnisse {
    public static void sprengenDir(int n) {
        File root = new File("/home/simon/IdeaProjects/leistungskurs/Schule/io/test");
        if (!root.exists()) {
            root.mkdir();
        }
        for (int i = 0; i < n; i++) {
            try {
                char[] charr = new char[8];
                for (int j = 0; j < charr.length; j++) {
                    int z = zufallGanz(65, 90);
                    charr[j] = (char) z;
                }
                String s = new String(charr);
                File dir = new File("/home/simon/IdeaProjects/leistungskurs/Schule/io/test/" + s);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < charr.length; l++) {
                        int z = zufallGanz(65, 90);
                        charr[l] = (char) z;
                    }
                    s = new String(charr);
                    File file = new File(dir.getAbsolutePath() + File.separatorChar + s + ".txt");
                    FileWriter fw = new FileWriter(file);
                    System.out.println(file.canWrite());
                    char[] charrs = new char[128];
                    for (int k = 0; k < charrs.length; k++) {
                        int z = zufallGanz(32, 127);
                        charrs[k] = (char) z;
                    }
                    fw.write(charrs);
                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean deleteDirectory(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (Objects.requireNonNull(dir.listFiles()).length == 0) {
                return dir.delete();
            }
            if (file.isDirectory()) {
                deleteDirectory(file);
            } else {
                file.delete();
            }
        }
        return dir.delete();
    }

    public static void main(String[] args) {
        System.out.println(deleteDirectory(new File("/home/simon/IdeaProjects/leistungskurs/Schule/io/test")));
    }
}
