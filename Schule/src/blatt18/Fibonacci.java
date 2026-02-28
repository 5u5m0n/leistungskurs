package blatt18;

public class Fibonacci {
    /**
     * Gibt die nte Fibonacci-Zahl zurück
     * @param n n
     * @return Fibonacci-Zahl
     */
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }
}
