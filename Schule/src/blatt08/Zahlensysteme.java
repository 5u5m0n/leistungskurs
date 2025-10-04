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

    /**
     * Wandelt eine Hexadezimalzahl in eine Binärzahl um.
     * @param s Hexadezimalzahl
     * @return Binärzahl
     */
     public static String hexadezimalZuBinaer(String s){
         char[] chars = s.toUpperCase().toCharArray();
         char[] bin = new char[(chars.length-4)*4+3];
         bin[0] = '(';
         bin[bin.length-1] = '2';
         bin[bin.length-2] = ')';
         char[] binE = new char[4];
         for (int i = 1; i < chars.length-3; i++){
             switch (chars[i]) {
                 case '0':
                     binE[0] = '0';
                     binE[1] = '0';
                     binE[2] = '0';
                     binE[3] = '0';
                     break;
                 case '1':
                     binE[0] = '0';
                     binE[1] = '0';
                     binE[2] = '0';
                     binE[3] = '1';
                     break;
                 case '2':
                     binE[0] = '0';
                     binE[1] = '0';
                     binE[2] = '1';
                     binE[3] = '0';
                     break;
                 case '3':
                     binE[0] = '0';
                     binE[1] = '0';
                     binE[2] = '1';
                     binE[3] = '1';
                     break;
                 case '4':
                     binE[0] = '0';
                     binE[1] = '1';
                     binE[2] = '0';
                     binE[3] = '0';
                     break;
                 case '5':
                     binE[0] = '0';
                     binE[1] = '1';
                     binE[2] = '0';
                     binE[3] = '1';
                     break;
                 case '6':
                     binE[0] = '0';
                     binE[1] = '1';
                     binE[2] = '1';
                     binE[3] = '0';
                     break;
                 case '7':
                     binE[0] = '0';
                     binE[1] = '1';
                     binE[2] = '1';
                     binE[3] = '1';
                     break;
                 case '8':
                     binE[0] = '1';
                     binE[1] = '0';
                     binE[2] = '0';
                     binE[3] = '0';
                     break;
                 case '9':
                     binE[0] = '1';
                     binE[1] = '0';
                     binE[2] = '0';
                     binE[3] = '1';
                     break;
                 case 'A':
                     binE[0] = '1';
                     binE[1] = '0';
                     binE[2] = '1';
                     binE[3] = '0';
                     break;
                 case 'B':
                     binE[0] = '1';
                     binE[1] = '0';
                     binE[2] = '1';
                     binE[3] = '1';
                     break;
                 case 'C':
                     binE[0] = '1';
                     binE[1] = '1';
                     binE[2] = '0';
                     binE[3] = '0';
                     break;
                 case 'D':
                     binE[0] = '1';
                     binE[1] = '1';
                     binE[2] = '0';
                     binE[3] = '1';
                     break;
                 case 'E':
                     binE[0] = '1';
                     binE[1] = '1';
                     binE[2] = '1';
                     binE[3] = '0';
                     break;
                 case 'F':
                     binE[0] = '1';
                     binE[1] = '1';
                     binE[2] = '1';
                     binE[3] = '1';

             }
             bin[(i*4)-3] = binE[0];
             bin[(i*4)-2] = binE[1];
             bin[(i*4)-1] = binE[2];
             bin[(i*4)] = binE[3];
         }
         return new String(bin);
     }

    /**
     * Wandelt eine Hexadezimalzahl oder eine Binärzahl in eine Ganzzahl um
     * @param s Hexadezimalzahl oder Binärzahl
     * @return Ganzzahl
     */
     public static int zuDezimal(String s){
         char[] chars = s.toCharArray();
         int wert = 0;
         char[] charHex;
         if (istHexadezimal(s)) {
             chars = hexadezimalZuBinaer(s).toCharArray();
         }
         if (istDezimal(s)){
             return Integer.parseInt(s);
         } else {
             for (int i = 1; i < chars.length - 2; i++){
                 if (chars[i] == '1') {
                     wert += Math.pow(2, chars.length-i-3);
                 }
             }
         }
         return wert;
     }

     public static void main(String[] args) {
     }
}