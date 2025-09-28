package blatt06;

public class DasErsteArray {
    public static void main(String[] args) {
        int[] arr = new int[990];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 10;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}
