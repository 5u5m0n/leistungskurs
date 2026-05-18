package blatt29.aufgabe4;

public class intbool {
    private boolean bool;
    private int integer;

    public intbool(boolean bool) {
        this.bool = bool;
        if (bool) {
            this.integer = 1;
        } else {
            this.integer = 0;
        }
    }

    public intbool(int integer) {
        if (integer == 1) {
            this.bool = true;
            this.integer = 1;
        } else {
            this.integer = 0;
            this.bool = false;
        }
    }

    public boolean isTrue() {
        return this.bool;
    }

    public void set(boolean bool) {
        this.bool = bool;
        if (bool) {
            this.integer = 1;
        } else {
            this.integer = 0;
        }
    }

    public void set(int integer) {
        this.integer = integer;
        if (integer == 1) {
            this.bool = true;
        } else {
            this.bool = false;
        }
    }

    public int getInt() {
        return this.integer;
    }
}
