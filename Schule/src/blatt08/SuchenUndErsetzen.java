package blatt08;

public class SuchenUndErsetzen {

    /**
     * Ersetzt jeden char x in einem String durch char c
     * @param s String
     * @param x Dieser char wird ersetzt
     * @param c char x wird durch diesen char ersetzt
     * @return Neuer String
     */
    public static String ersetzen(String s, char x, char c){
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == x){
                chars[i] = c;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "Hallo";
        System.out.println(ersetzen(s,'a','4'));
    }
}
