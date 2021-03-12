package chapter_07.figures;

public class Parallelogramm extends Trapez {

    /**
     * Konstruktor, hier werden die Attribute initialisiert
     * @param a
     * @param b
     * @param winkelAlpha
     */
    public Parallelogramm(double a, double b, double winkelAlpha) {
        super(a, b, a);
        wAlpha = winkelAlpha;
        wBeta = 180 - winkelAlpha;
    }

    @Override
    /**
     * Gibt de flächeninhalt zurück
     */
    public double flächeninhalt() {
        if (flaeche != 0)
            return flaeche;
        else
            //Wenn der Flächeninhalt 0 ist, wird die fläche berechnet
            return flaeche = a * b * Math.sin(Math.toRadians(wAlpha));
    }

    @Override
    /**
     * Gibt den umfang zurück
     */
    public double umfang() {
        if (umfang != 0)
            return umfang;
        else
            //Wenn der Umfang 0 ist, wird der umfang berechnet
            return umfang = 2*a + 2*b;
    }
}
