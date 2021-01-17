package chapter_08;

public class OddException extends Exception {

    //@Override
    public String getMessage(int zahl) {
        return "Error, " + zahl + " ist keine Gerade Zahl! Die Zahl wurde um Eins erhöht.";
    }


}
