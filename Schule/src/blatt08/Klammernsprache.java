package blatt08;

public class Klammernsprache {

    /**
     * Überprüft, ob eine Sequenz aus Klammern ein wort in der Klammersprache handelt.
     * @param s String
     * @return bool
     */
    public static boolean istKlammerwort(String s){
        int offen = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == '('){
                offen++;
            } else if (chars[i] == ')') {
                offen--;
            }
            if (offen < 0){
                return false;
            }
        }
        return offen == 0;
    }

    public static void main(String[] args) {
        String k = "()(()())";
        System.out.println(istKlammerwort(k));
    }
}
