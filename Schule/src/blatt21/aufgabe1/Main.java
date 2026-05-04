package blatt21.aufgabe1;

public class Main {


    static Farmer farmer = new Farmer("Detlef", "Detlefs Heiße Hütte");
    static Farm farm = new Farm(farmer);

    public static void simulation(int anzahlTage) {
        for (int i = 0; i < anzahlTage; i++) {
            farm.neuerTag();
            farm.tagAblauf();
        }
    }

    public static void main(String[] args) {
        simulation(100);
        System.out.println(farm.getFarmer().getVermoegen());
    }
}
