package blatt08;

public class Zahlensysteme {

    /**
     * Überprüft, ob ein String eine Dezimalzahl ist.
     * @param s Zahl
     * @return bool
     */
     public static boolean istDezimal(String s){
         char[] chars = s.toCharArray();
         if (chars[0] == '0') {
             return false;
         }
         for (int i = 0; i < chars.length; i++){
             if (chars[i] < '0' || chars[i] > '9') {
                 return false;
             }
         }
         return true;
     }

    /**
     * Überprüft, ob ein String eine Hexadezimalzahl ist.
     * @param s Zahl
     * @return bool
     */
     public static boolean istHexadezimal(String s){
         char[] chars = s.toUpperCase().toCharArray();
         if (chars[0] != '(' || chars[chars.length - 3] != ')' || chars[chars.length - 2] != '1' || chars[chars.length - 1] != '6') {
             return false;
         }
         for (int i = 1; i < chars.length-3; i++){
             if ((chars[i] < '0' || chars[i] > '9') && (chars[i] > 'F' || chars[i] < 'A')){
                 return false;
             }
         }
         return true;
     }

    /**
     * Überprüft, ob ein String eine Binärzahl ist.
     * @param s Zahl
     * @return bool
     */
     public static boolean istBinaer(String s){
         char[] chars = s.toCharArray();
         if (chars[0] != '(' || chars[chars.length-2] != ')' || chars[chars.length-1] != '2') {
             return false;
         }
         for (int i = 1; i < chars.length - 2; i++){
             if (chars[i] != '0' && chars[i] != '1') {
                 return false;
             }
         }
         return true;
     }

     public static int zuDezimal(String s){
         char[] chars = s.toCharArray();
         int wert = 0;
         if (istDezimal(s)){
             return Integer.parseInt(s);
         } else if (istBinaer(s)){
             for (int i = 1; i < chars.length - 2; i++){
                 if (chars[i] == '1') {
                     wert += Math.pow(2, chars.length-i-3);
                 }
             }
         }
         return wert;
     }

     public static void main(String[] args) {
         String s = "(1001001)2";
         System.out.println(zuDezimal(s));
     }
}