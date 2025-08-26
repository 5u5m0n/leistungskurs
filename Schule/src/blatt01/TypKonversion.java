package blatt01;

public class TypKonversion {
    public static void main(String[] args) {
        int a = 14;
        double b = -21.25;

        int c = (int) b;
        double d = (double) a;

        System.out.println(c);
        System.out.println(d);

        char e = 'a';
        int f = 65;

        int g = (int) e;
        char h = (char) f;

        System.out.println(g);
        System.out.println(h);

        /*a) c und d werden als Zahlen ausgegeben.
        g und h konvertieren hierbei ihre Werte in ASCII und anders herum.
        b) Der Befehl konvertiert die Variablen in einen anderen Datentypen.
        c) int enthält weniger informationen als double. Daher gehen beim konvertieren von double in int daten verloren.
        d) Wenn man versucht, char in int zu casten, wird der dazugehörige ASCII code ausgegeben und andersherum.
         */

        //boolean t = true;
        //h = (char) t;

        //e) Das Programm kann nicht ausgeführt werden, denn boolean kann nicht in char konvertiert werden

    }
}
