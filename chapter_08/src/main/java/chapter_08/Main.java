package chapter_08;

/**
 * Klasse mit der Main-Methode
 * @author sebastian
 */
public class Main {

    public static void main(String[] args) throws OddException {
        GeradeZahl zahl1 = new GeradeZahl(10);
        GeradeZahl zahl2 = new GeradeZahl(21);
        GeradeZahl zahl3 = new GeradeZahl(30);
        GeradeZahl zahl4 = new GeradeZahl(13);

        System.out.println("Zahl 1 = " + zahl1.mult(zahl2));
        System.out.println("Zahl 2 = " + zahl2);
        System.out.println("Zahl 3 = " + zahl3.mult(zahl2));
        System.out.println("Zahl 4 = " + zahl4.plus(zahl1));
    }
}
