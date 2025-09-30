package blatt07;

public class Stein {
    public static int steinGGT(int a, int b) {
        int k = 0;
        while (a != 0 && b != 0) {
            if ((a%2 == 0) && (b%2 == 0)) {
                a /= 2;
                b /= 2;
                k++;
            } else if (a%2 == 0) {
                a /= 2;
            } else if (b%2 == 0) {
                b /= 2;
            } else {
                if (a > b) {
                    a = (a-b)/2;
                } else {
                    b = (b-a)/2;
                }
            }
        }
        int d;
        if (a == 0) {
            d = b;
        } else {
            d = a;
        }

        return (int) (d * (Math.pow(2, k)));
    }

    public static void main(String[] args) {
    }
}
