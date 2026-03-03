package blatt18;

public class TuermeVonHanoi {
    static String stabA;
    static String stabB;
    static String stabC;

    public static void initStaebe(int n) {
        char[] arr = new char[n];
        char[] arr2 = new char[n];
        for (int i = n - 1; i > -1; i--) {
            arr[i] = Integer.toString(i).charAt(0);
            arr2[i] = ' ';
        }
        stabA = new String(arr);
        stabB = new String(arr2);
        stabC = new String(arr2);
    }

    public static void platziereScheibe(String a, String b) {
        char c = ' ';
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        for (int i = a.length() - 1; i > -1; i++) {
            if (a.charAt(i) != ' ') {
                c = a.charAt(i);
                arrA[i] = ' ';
                break;
            }
        }
        for (int i = b.length() - 2; i > -1; i--) {
            if (b.charAt(i) != ' ') {
                arrB[i] = c;
                break;
            }
        }
        a = new String(arrA);
        b = new String(arrB);
    }

    public static void platziereTurm() {

    }
}
