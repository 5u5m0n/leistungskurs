package blatt18;

public class TuermeVonHanoi {
    static String stabA = "";
    static String stabB = "";
    static String stabC = "";

    public static void initStaebe(int n) {
        for (int i = 1; i <= n; i++) {
            stabA = i+stabA;
        }
        stabB = "";
        stabC = "";
    }

    public static void printStaebe() {
        System.out.println("Stab A: " + stabA);
        System.out.println("Stab B: " + stabB);
        System.out.println("Stab C: " + stabC);
        System.out.println();
    }

    public static String entferneScheibe(int n) {
        String s = null;
        switch(n) {
            case 1:
                if (!stabA.isEmpty()) {
                    s = stabA.substring(stabA.length()-1);
                    stabA = stabA.substring(0, stabA.length()-1);
                }
                break;
            case 2:
                if (!stabB.isEmpty()) {
                    s = stabB.substring(stabB.length()-1);
                    stabB = stabB.substring(0, stabB.length()-1);
                }
                break;
            case 3:
                if (!stabC.isEmpty()) {
                    s = stabC.substring(stabC.length()-1);
                    stabC = stabC.substring(0, stabC.length()-1);
                }
                break;
        }
        return s;
    }

    public static void addScheibe(int n, String s) {
        switch(n) {
            case 1:
                    stabA = stabA + s;
                break;
            case 2:
                stabB = stabB + s;
                break;
            case 3:
                stabC = stabC + s;
                break;
        }
    }

    public static void platziereScheibe(int von, int zu) {
        addScheibe(zu, entferneScheibe(von));
        printStaebe();
    }

    public static int findeReststab(int von, int zu) {
        if (von == 1 && zu == 2 || von == 2 && zu == 1) {
            return 3;
        } else if (von == 1 && zu == 3 || von == 3 && zu == 1) {
            return 2;
        }  else if (von == 2 && zu == 3 || von == 3 && zu == 2) {
            return 1;
        }
        return 0;
    }

    public static String findeStab(int n) {
        switch(n) {
            case 1:
                return stabA;
            case 2:
                return stabB;
            case 3:
                return stabC;
        }
        return null;
    }

    public static boolean platziereTurm(int n, int von, int zu) {
        if (n < 1) {
            return true;
        } else {
            int rest = findeReststab(von, zu);
            platziereTurm(n-1, von, rest);
            platziereScheibe(von, zu);
            platziereTurm(n-1, rest, zu);
        }
        return false;
    }

    public static void main(String[] args) {
        initStaebe(8);
        printStaebe();
        platziereTurm(8, 1, 3);

    }
}
