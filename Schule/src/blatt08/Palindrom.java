package blatt08;

public class Palindrom {
    /**
     * Dreht einen String um.
     * @param s String
     * @return Umgedrehter String
     */
    public static String umdrehen(String s){
        char[] chars = s.toCharArray();
        char[] umArr = new char[chars.length];
        for (int i=0; i < chars.length; i++){
            umArr[i] = chars[chars.length-i-1];
        }
        String umStr = new String(umArr);
        return umStr;
    }

    /**
     * Überprüft, ob ein String ein Palindrom ist.
     * @param s String
     * @return boolean
     */
    public static boolean istPalindrom(String s){
        return s.toUpperCase().equals(umdrehen(s).toUpperCase());
    }


    public static void main(String[] args) {
        String a = "Anna";
        System.out.println(istPalindrom(a));
    }
}
