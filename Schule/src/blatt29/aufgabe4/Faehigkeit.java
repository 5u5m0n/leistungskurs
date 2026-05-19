package blatt29.aufgabe4;

public abstract class Faehigkeit {
     private Wesen wesen;

     public Wesen getWesen() {
         return this.wesen;
     }

     protected void setWesen(Wesen wesen) {
         this.wesen = wesen;
     }
}
