package chapter_07.figures;

public class Trapez extends KonvexesViereck {

    protected double hA;

    /**
     * Konstruktor, hier werden die Attribute initialisiert
     * @param a
     * @param b
     * @param c
     * @param winkelBeta
     */
    public Trapez(double a, double b, double c, double winkelBeta) {
        super(a, b, c, winkelBeta, 0);
        calcH();
        calcD();
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
            return flaeche = ((a + c) * hA) / 2;
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
            return umfang = a + b + c + d;
    }

    /**
     * Berechnet die Höhe
     */
    private void calcH() {
        hA = b * Math.sin(Math.toRadians(wBeta));
    }

    /**
     * Berechnet die Seite D
     */
    private void calcD() {
        d = Math.sqrt(Math.pow(a - c - Math.sqrt(b*b - hA*hA), 2) + hA*hA);
    }

}
