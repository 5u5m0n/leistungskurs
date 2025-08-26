package blatt01;

public class Zuweisungen {
    public static void main(String[] args) {
        int a =3;
        int b = a;
        a += 3;
        a *= 4;
        a -= 8;
        a /= 2;
        a -= 2 * b;
        System.out.println(a);
        //1.: 6
        //2.: (4a / 2) - 2a und (12 - 8) / 2
    }
}
