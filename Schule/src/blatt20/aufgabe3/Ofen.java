package blatt20.aufgabe3;

public class Ofen {

    final String[] BEHEIZUNGSMODI = new String[]{"Aus", "Beleuchtung", "Unterhitze", "Oberhitze", "Unter- und Oberhitze", "Umluft"};
    String beheizungsmodus;
    int beheizungsmodusIndex = 0;
    int temparatur;

    public Ofen() {
        this.beheizungsmodus = "Aus";
        this.beheizungsmodusIndex = 0;
        this.temparatur = 0;
    }

    void temparaturEinstellen(int temparatur) {
        if (temparatur > 250) {
            temparatur = 250;
        } else if (temparatur < 0) {
            temparatur = 0;
        }
        this.temparatur = temparatur;
        System.out.println("Temparatur: " + temparatur);
    }

    void beheizungsmodusErhoehen() {
        if (this.beheizungsmodusIndex < BEHEIZUNGSMODI.length - 1) {
            this.beheizungsmodusIndex++;
        } else {
            this.beheizungsmodusIndex = 0;
        }
        this.beheizungsmodus = BEHEIZUNGSMODI[this.beheizungsmodusIndex];
        System.out.println("Beheizungsmodus: " + this.beheizungsmodus);
    }

    void beheizungsmodusReduzieren() {
        if (this.beheizungsmodusIndex > 0) {
            this.beheizungsmodusIndex--;
        } else {
            this.beheizungsmodusIndex = BEHEIZUNGSMODI.length - 1;
        }
        this.beheizungsmodus = BEHEIZUNGSMODI[this.beheizungsmodusIndex];
        System.out.println("Beheizungsmodus: " + this.beheizungsmodus);
    }
}
