package chapter_08;

public class OddException extends Exception {
    int zahl;

    public OddException(int zahl) {
        this.zahl = zahl;
    }

    //@Override
    public String getMessage() {
        return "Error, " + zahl + " ist keine Gerade Zahl! Die Zahl wurde um Eins erhöht.";
    }


}
