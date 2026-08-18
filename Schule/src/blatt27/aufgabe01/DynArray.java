package blatt27.aufgabe01;

import static blatt07.ArbeitMitArrays.printArray;

public class DynArray<T> {
    private T[] dynArray;

    @SuppressWarnings({"unchecked"})
    private T[] newT(int i) {
        T[] newArray = (T[]) new Object[i];
        return newArray;
    }

    public DynArray() {
        this.dynArray = newT(0);
    }

    /**
     * Gibt den dynamischen Array aus.
     */
    public void printArr() {
        return;
    }

    /**
     * @return Ist der dynamische Array leer?
     */
    public boolean isEmpty() {
        return this.dynArray.length == 0;
    }

    /**
     * @return Anzahl der Array-Elemente
     */
    public int size() {
        return this.dynArray.length;
    }

    /**
     * @param i Index
     * @return Element des dynamischen Arrays an der Stelle i
     */
    public T get(int i) {
        if (i < 0 || i >= this.dynArray.length) {
            throw new IndexOutOfBoundsException();
        }
        return this.dynArray[i];
    }

    /**
     * @param i Element
     * @return Enthält der Dynamische Array das Element i?
     */
    public boolean contains(T i) {
        for (int j = 0; j < this.dynArray.length; j++) {
            if ( i == this.dynArray[j] ) { return true; }
        }
        return false;
    }

    /**
     * @param i Element
     * @return Stelle des Elements i
     */
    public T indexOf(T i) {
        for (int j = 0; j < this.dynArray.length; j++) {
            if ( i == this.dynArray[j] ) { return this.dynArray[j]; }
        }
        return null;
    }

    /**
     * Fügt das Element i am Ender des dynamischen Arrays an.
     * @param i Element
     */
    public void add(T i) {
        T[] temp = newT(this.dynArray.length + 1);
        for (int j = 0; j < this.dynArray.length; j++) { temp[j] = this.dynArray[j]; }
        temp[temp.length - 1] = i;
        this.dynArray = temp;
    }

    /**
     * Fügt das Element i ein.
     * @param i Element
     * @param pos Position des Elements
     */
    public void add(T i, int pos) {
        T[] temp = newT(this.dynArray.length + 1);
        for (int j = 0; j < temp.length; j++) {
            if (j == pos) { temp[j] = i; }
            else if (j < this.dynArray.length) { temp[j] = this.dynArray[j]; }
            else if (j == this.dynArray.length) { temp[j] = i; }
        }
        this.dynArray = temp;
    }

    /**
     * Ersetzt das Element an der Position pos mit dem Element i.
     * @param i Element
     * @param pos Position/Index
     */
    public void set(T i, int pos) {
        if (pos < 0 || pos >= this.dynArray.length) {
            throw new IndexOutOfBoundsException();
        }
        this.dynArray[pos] = i;
    }

    /**
     * Entfernt das Element an der Position pos.
     * @param pos Position/Index
     * @return Das entfernte Element
     */
    public T remove(int pos) {
        T z = this.dynArray[pos];
        T[] temp = newT(this.dynArray.length - 1);
        for (int i = 0; i < temp.length; i++) {
            if (i == pos) { i++; }
            else { temp[i] = this.dynArray[i]; }
        }
        this.dynArray = temp;
        return z;
    }


}
