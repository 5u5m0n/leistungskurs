package blatt13;

import static blatt13.Zufall.zufallGanz;

public class PenAndPaper {

    public static int wuerfel(int N, int X) {
        int e = 0;
        for (int i = 0; i < N; i++) {
            e += zufallGanz(1, X);
        }
        return e;
    }

    public static int wuerfel(int N, int X, int bonus) {
        return wuerfel(N, X) + bonus;
    }

    public static boolean check(int dc, int adv) {
        int e = wuerfel(1, 20);
        if (adv <= -1) {
            e = Math.min(e, wuerfel(1, 20));
        } else if (adv >= 1) {
            e = Math.max(e, wuerfel(1, 20));
        }
        if (e >= dc || e == 20) {
            return true;
        } else if (e < dc || e == 1){
            return false;
        }
        return false;
    }

    public static boolean check(int dc, int adv, int bonus) {
        int e = wuerfel(1, 20);
        if (adv <= -1) {
            e = Math.min(e, wuerfel(1, 20));
        } else if (adv >= 1) {
            e = Math.max(e, wuerfel(1, 20));
        }
        if (e + bonus >= dc || e == 20) {
            return true;
        } else if (e + bonus < dc || e == 1) {
            return false;
        }
        return false;
    }

    public static int angriff(int bonus, int ac, int adv, int N, int X) {
        boolean treffer = check(ac, adv, bonus);
        if (treffer) {
            return wuerfel(N, X);
        } else {
            return -1;
        }
    }

    public static int angriff(int bonus, int ac, int adv, int N, int X, int b) {
        boolean treffer = check(ac, adv, bonus);
        if (treffer) {
            return wuerfel(N, X, b);
        } else {
            return -1;
        }
    }

    public static int kampf(){
        int[] tp = new int[]{70, 42};
        int[] ac = new int[]{14, 10};
        int[] bonus = new int[]{2, 1};
        int[] dmg = new int[]{1, 6, 2, 9};
        int[] adv = new int[]{3, -3};
        while (true) {
            for(int i = 0; i < 2; i++){
                int angr = angriff(bonus[i], ac[i], adv[i], dmg[2*i], dmg[2*i+1]);
            }
        }
    }
}
