package blatt05;

import java.util.Scanner;

public class SicheresPasswort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Passwort eingeben.");
        String a = input.nextLine();
        boolean length = false;
        boolean uppercase = false;
        boolean lowercase = false;
        boolean digit = false;
        boolean special = false;
        while (!length && !uppercase && !lowercase && !digit && !special) {
            for (int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    uppercase = true;
                } else if (c >= 'a' && c <= 'z') {
                    lowercase = true;
                } else if (c >= '0' && c <= '9') {
                    digit = true;
                } else {
                    special = true;
                }
            }
            if (a.length() >= 0) {
                length = true;
            }
        }
    }
}
