package blatt08;

public class Kalender {

    /**
     * Gibt den Tag in einem gegebenen Datum im TT.MM.JJJJ Format zurück.
     * @param s Datum
     * @return Tag
     */
    public static int getTag(String s){
        char[] chars = s.toCharArray();
        int n = Integer.parseInt(chars[0]+""+chars[1]);
        return(n);
    }

    /**
     * Gibt den Monat in einem gegebenen Datum im TT.MM.JJJJ Format zurück.
     * @param s Datum
     * @return Monat
     */
    public static int getMonat(String s){
        char[] chars = s.toCharArray();
        int n = Integer.parseInt(chars[3]+""+chars[4]);
        return(n);
    }

    /**
     * Gibt das Jahr in einem gegebenen Datum im TT.MM.JJJJ Format zurück.
     * @param s Datum
     * @return Jahr
     */
    public static int getJahr(String s){
        char[] chars = s.toCharArray();
        int n = Integer.parseInt(chars[6]+""+chars[7]+chars[8]+chars[9]);
        return(n);
    }

    /**
     * Überprüft, ob ein Jahr ein Schaltjahr ist
     * @param n Jahr
     * @return bool
     */
    public static boolean istSchaltjahr(int n){
        if (n%400 == 0) {
            return true;
        } else return n % 4 == 0 && n % 100 != 0;
    }

    /**
     * Setzt ein Datum aus drei Ganzzahlen zusammen
     * @param a Tag
     * @param b Monat
     * @param c Jahr
     * @return Datum
     */
    public static String zuDatum(int a, int b, int c){
        String t;
        if (a <= 9) {
            t = "0" + a;
        } else {
            t = "" + a;
        }
        String m;
        if (b <= 9) {
            m = "0" + b;
        } else {
            m = "" + b;
        }
        String datum = t + "." + m + "." + c;
        return datum;
    }

    /**
     * Gibt den nächsten Tag von einem gegebenen Datum zurück
     * @param s Datum
     * @return Nächster Tag
     */
    public static String naechsterTag(String s){
        int[] monatLenght = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int t = getTag(s);
        int m = getMonat(s);
        int j = getJahr(s);
        if (istSchaltjahr(j)) {
            monatLenght[1] = 29;
        }
        t++;
        if (t > monatLenght[m-1]) {
            m++;
            t = 1;
            if (m > 12) {
                j++;
                m = 1;
            }
        }
        return zuDatum(t,m,j);
    }

    public static void main(String[] args) {
    }

}
