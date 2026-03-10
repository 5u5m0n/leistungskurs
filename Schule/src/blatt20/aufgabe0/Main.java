package blatt20.aufgabe0;

public class Main {
    public static void main(String[] args) {
        Fahrrad benedigda = new Fahrrad();
        benedigda.farben = new String[]{"gelb", "gelb", "gelb", "gelb", "gelb"};
        benedigda.zulassung = false; //Weil: zu Hell
        benedigda.frontlicht =  true;
        benedigda.ruecklicht = true;
        benedigda.katzenaugen = true;
    }

}
