package blatt05;

import java.util.Scanner;

public class SicheresPasswort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a;
        boolean length = false;
        boolean uppercase = false;
        boolean lowercase = false;
        boolean digit = false;
        boolean special = false;
        while (true) {
            length = false;
            uppercase = false;
            lowercase = false;
            digit = false;
            special = false;
            System.out.println("Passwort eingeben.");
            a = input.nextLine();
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
            if (a.length() >= 8) {
                length = true;
            }
            if (length && uppercase && lowercase && digit && special) {
                break;
            } else {
                System.out.println("Passwort nict sicher genug.");
            }
        }
        System.out.println("Passwort gesichert.");
    }
}
