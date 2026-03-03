package blatt18;

public class TuermeVonHanoi {
    static String stabA;
    static String stabB;
    static String stabC;

    public static void initStaebe(int n) {
        for (int i = 1; i <= n; i++) {
            stabA = i+stabA;
        }
        stabB = "";
        stabC = "";
    }



    public static void platziereScheibe(String a, String b) {

    }

    public static void platziereTurm(int n) {
        if (n % 2 == 0) {

        } else {

        }
    }
}
