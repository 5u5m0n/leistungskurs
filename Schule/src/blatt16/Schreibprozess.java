package blatt16;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Schreibprozess {
    public static void main(String[] args) {
        //Für Linux (Pop!_OS)
        File io = new File("/home/simon/IdeaProjects/leistungskurs/Schule/io");
        if (!io.exists()) {
            io.mkdir();
        }
        try {
            File text = new File("/home/simon/IdeaProjects/leistungskurs/Schule/io/Test01.txt");
            FileWriter fw = new FileWriter(text);
            fw.write("Hello there.\nI've got the good stuff. \nOnly 100€ per gram.");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File html = new File("/home/simon/IdeaProjects/leistungskurs/Schule/io/Test02.html");
            FileWriter fw = new FileWriter(html);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("<!DOCTYPE html>");
            bw.newLine();
            bw.write("<html>");
            bw.newLine();
            bw.write("<head>");
            bw.newLine();
            bw.write("<title>HTML aus java</title>");
            bw.newLine();
            bw.write("</head>");
            bw.newLine();
            bw.write("<body>");
            bw.newLine();
            bw.write("<h1>HTML aus java?</h1>");
            bw.newLine();
            bw.write("<p>Es geht. Wirklich.</p>");
            bw.newLine();
            bw.write("</body>");
            bw.newLine();
            bw.write("</html>");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}