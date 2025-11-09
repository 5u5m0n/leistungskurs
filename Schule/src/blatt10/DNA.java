package blatt10;

import static blatt07.ArbeitMitArrays.printArray;

public class DNA {

    /*
    (int) A: 65
    (int) T: 84
    (int) G: 71
    (int) C: 67
    */
    /**
     * Überprüft, ob ein gegebener String einer korrekten Nukleotidsequenz entspricht.
     * @param s String
     * @return bool
     */
    public static boolean istDNA(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) + s.charAt(i + 1) != 149) {
                if (s.charAt(i) + s.charAt(i + 1) == 138) {
                    if (s.charAt(i) != 71 && s.charAt(i + 1) != 71) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (s.charAt(i) < 65 || s.charAt(i + 1) < 65) {
                return false;
            }
        }
        return true;
    }

    /**
     * Überprüft, ob ein gegebener byte-Array einer korrekten Nukleotidsequenz entspricht.
     * @param b byte-Array
     * @return bool
     */
    public static boolean istDNA(byte[] b) {
        if (b.length % 2 != 0) {
            return false;
        }
        for (int i = 0; i < b.length; i += 2) {
            if (b[i] + b[i + 1] != 1) {
                if (b[i] + b[i + 1] == 5) {
                    if (b[i] != 2 && b[i + 1] != 2) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (b[i] < 0 || b[i + 1] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Wandelt eine gegebene Nukleotidsequenz in einen byte-Array um.
     * @param s Nukleotidsequenz
     * @return byte-Array
     */
    public static byte[] zuDNA(String s) {
        if (istDNA(s)) {
            byte[] b = new byte[s.length()];
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case 'A':
                        b[i] = 0;
                        break;
                    case 'T':
                        b[i] = 1;
                        break;
                    case 'G':
                        b[i] = 2;
                        break;
                    case 'C':
                        b[i] = 3;
                        break;
                }
            }
            return b;
        } else {
            return new byte[0];
        }
    }


    /**
     * Wandelt eine gegebene Nukleotidsequenz in einen byte-Array um.
     * @param b Nukleotidsequenz
     * @return byte-Array
     */
    public static String zuDNA(byte[] b) {
        if (istDNA(b)) {
            char[] s = new char[b.length];
            for (int i = 0; i < s.length; i++) {
                switch (b[i]) {
                    case 0:
                        s[i] = 'A';
                        break;
                    case 1:
                        s[i] = 'T';
                        break;
                    case 2:
                        s[i] = 'G';
                        break;
                    case 3:
                        s[i] = 'C';
                        break;
                }
            }
            return new String(s);
        } else {
            return "";
        }

    }

    /**
     * Wandelt eine gegebene Nukleotidsequenz in einen boolean-Array um
     * @param s Nukleotidsequenz
     * @return boolean-Array
     */
    public static boolean[] zuDNA_Bool(String s) {
        if (istDNA(s)) {
            boolean[] b = new boolean[s.length()*2];
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case 'A':
                        b[(2*i)] = false;
                        b[(2*i)+1] = false;
                        break;
                    case 'T':
                        b[(2*i)] = false;
                        b[(2*i)+1] = true;
                        break;
                    case 'G':
                        b[(2*i)] = true;
                        b[(2*i)+1] = false;
                        break;
                    case 'C':
                        b[(2*i)] = true;
                        b[(2*i)+1] = true;
                        break;
                }
            }
            return b;
        } else {
            return new boolean[0];
        }
    }

    /**
     * Wandelt eine gegebene Nukleotidsequenz in einen boolean-Array um
     * @param b Nukleotidsequenz
     * @return boolean-Array
     */
    public static boolean[] zuDNA_Bool(byte[] b) {
        if (istDNA(b)) {
            boolean[] bool = new boolean[b.length*2];
            for (int i = 0; i < b.length; i++) {
                switch (b[i]) {
                    case 0:
                        bool[(2*i)] = false;
                        bool[(2*i)+1] = false;
                        break;
                    case 1:
                        bool[(2*i)] = false;
                        bool[(2*i)+1] = true;
                        break;
                    case 2:
                        bool[(2*i)] = true;
                        bool[(2*i)+1] = false;
                        break;
                    case 3:
                        bool[(2*i)] = true;
                        bool[(2*i)+1] = true;
                        break;
                }
            }
            return bool;
        } else {
            return new boolean[0];
        }
    }

    /**
     * Wandelt einen gegebenen boolean-Array in eine Nukleotidsequenz um
     * @param b boolean-Array
     * @return Nukleotidsequenz
     */
    public static String zuDNA_Bool(boolean[] b) {
            char[] dna = new char[b.length / 2];
            for (int i = 0; i < b.length; i += 2) {
                if (b[i]) {
                    if (b[i + 1]) {
                        dna[(int) i / 2] = 'C';
                    } else {
                        dna[(int) i / 2] = 'G';
                    }
                } else {
                    if (b[i + 1]) {
                        dna[(int) i / 2] = 'T';
                    } else {
                        dna[(int) i / 2] = 'A';
                    }
                }
            }
            return new String(dna);
    }

    /**
     * Wandelt eine gegebene Nukleotidsequenz in einen effizienten byte-Array um
     * @param s Nukleotidsequenz
     * @return byte-Array
     */
    public static byte[] zuDNA_effizient(String s) {
        if (istDNA(s)) {
            byte[] dna = new byte[s.length() / 4];
            byte[] b = zuDNA(s);
            for (int i = 0; i < dna.length; i++) {
                for (int k = 0; k < 4; k++) {
                    int a = b[4 * i + k];
                    //System.out.print(a + "; ");
                    a = (int) ((int) a * Math.pow(4, k));
                    dna[i] += (byte) a;
                }
                dna[i] -= 128;
                //System.out.println(dna[i] % 4);
            }
            return dna;
        } else {
            return new byte[0];
        }
    }

    /**
     * Wandelt einen gegebenen byte-Array in eine effiziente Nukleotidsequenz um
     * @param dna byte-Array
     * @return Nukleotidsequenz
     */
    public static String zuDNA_effizient(byte[] dna) {
        char[] chars = new char[dna.length*4];
        for (int i = 0; i < dna.length; i++) {
            chars[i] = '_';
        }
        for (int i = 0; i < dna.length; i++) {
            if (dna[i] <= -98) {
                dna[i] -= 0;
                dna[i] -= 16;
                chars[(4*i)+3] = 'A';
                chars[(4*i)+2] = 'T';
            } else if (dna[i] <= -50) {
                dna[i] -= 64;
                dna[i] -= 0;
                chars[(4*i)+3] = 'T';
                chars[(4*i)+2] = 'A';
            } else if (dna[i] <= 62) {
                dna[i] -= 128;
                dna[i] -= 48;
                chars[(4*i)+3] = 'G';
                chars[(4*i)+2] = 'C';
            } else if (dna[i] <= 110) {
                dna[i] -= 192;
                dna[i] -= 32;
                chars[(4*i)+3] = 'C';
                chars[(4*i)+2] = 'G';
            }
        }
        for (int i = 0; i < dna.length; i++) {
            if (dna[i] == -127) {
                chars[(4*i)+1] = 'A';
                chars[(4*i)] = 'T';
            } else if (dna[i] == -124) {
                chars[(4*i)+1] = 'T';
                chars[(4*i)] = 'A';
            } else if (dna[i] == -117) {
                chars[(4*i)+1] = 'G';
                chars[(4*i)] = 'C';
            } else if (dna[i] == -114) {
                chars[(4*i)+1] = 'C';
                chars[(4*i)] = 'G';
            }
        }
        return new String(chars);
    }



    public static void main(String[] args) {
    }
        /* a)
            Wir benutzen hier den Datentypen byte, da er weniger Speicherplatz als ein int benötigt und von der größe Ausreichend ist.
        */
        /* e)
            Bei einem String werden pro Zeichen 16 Bit verwendet.
            Bei einem byte-Array werden pro Zeichen 8 Bit verwendet.
         */
        /* h)
            Pro Zeichen werden hier 2 Bit verwendet
        */
        /* k)
            Pro Nukleotid 2 Bit
         */
}
