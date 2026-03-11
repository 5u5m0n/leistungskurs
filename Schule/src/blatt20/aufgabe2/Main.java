package blatt20.aufgabe2;

public class Main {

    public static void main(String[] args) {
        Auto mercedes = new Auto();
        Auto kn = new Auto("kn", "500", 70000, 3, 0);
        Auto kia = new Auto(kn);
    }

}
