package chapter_07.figures;

public class KonvexesViereck extends Viereck {
    protected double a = 0;
    protected double b = 0;
    protected double c = 0;
    protected double d = 0;

    protected double f = 0;
    protected double e = 0;

    protected double wAlpha = 0;
    protected double wBeta = 0;
    protected double wGamma = 0;
    protected double wDelta = 0;

    protected double flaeche;
    protected double umfang;

    /**
     * Konstruktor, hier werden die Attribute initialisiert
     * @param a
     * @param b
     * @param c
     * @param winkelBeta
     * @param winkelGamma
     */
    public KonvexesViereck(double a, double b, double c, double winkelBeta, double winkelGamma) {
        this.a = a;
        this.b = b;
        this.c = c;

        this.wBeta = winkelBeta;
        this.wGamma = winkelGamma;

        calcE();
        calcF();
        calcD();
        calcAlpha();
        calcDelta();

        try {
            if (wAlpha + wBeta + wGamma + wDelta < 359.99)
                throw new Exception("Error, die Summe der Winkel ist under 360 Grad " + (wAlpha + wBeta + wGamma + wDelta));
        } catch (Exception exception) {
            exception.printStackTrace();
            //System.exit(0);
        }

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
            return flaeche = (Math.sqrt(((a+f+d)/2) * ((a+f+d)/2-a) * ((a+f+d)/2-f) * ((a+f+d)/2-d)) + Math.sqrt(((b+c+f)/2) * ((b+c+f)/2-b) * ((b+c+f)/2-c) * ((b+c+f)/2-f)));
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
     * Berechnet die Diagonale E
     */
    private void calcE() {
        if (wBeta != 0)
            e = Math.sqrt(a*a + b*b - 2 * a * b * Math.cos(Math.toRadians(wBeta)));
        else
            e = Math.sqrt(c*c + d*d - 2 * c * d * Math.cos(Math.toRadians(wDelta)));
    }

    /**
     * Berechnet die Diagonale F
     */
    private void calcF() {
        if (wAlpha != 0)
            f = Math.sqrt(a*a + d*d - 2 * a * b * Math.cos(Math.toRadians(wAlpha)));
        else
            f = Math.sqrt(b*b + c*c - 2 * b * c * Math.cos(Math.toRadians(wGamma)));
    }

    /**
     * Berechnet die Seite D
     */
    private void calcD() {
        double tmp = wBeta - Math.toDegrees(Math.acos((f*f + b*b - c*c) / (2 * f * b)));
        d = Math.sqrt(a*a + f*f - 2 * a * f * Math.cos(Math.toRadians(tmp)));
    }

    /**
     * Berechnet den Winkel Alpha
     */
    private void calcAlpha() {

        wAlpha = round(Math.toDegrees(Math.acos((a*a + d*d - f*f) / (2 * a * d))));
    }

    /**
     * Berechnet den Winkel Beta
     */
    private void calcBeta() {
        wBeta = round(Math.toDegrees(Math.acos((a*a + b*b - e*e) / (2 * a * b))));
    }

    /**
     * Berechnet den Winkel Gamma
     */
    private void calcGamma() {
        wGamma = round(Math.toDegrees(Math.acos((b*b + c*c - f*f) / (2 * b * c))));
    }

    /**
     * Berechnet den Winkel Delta
     */
    private void calcDelta() {
        wDelta = round(Math.toDegrees(Math.acos((c*c + d*d - e*e) / (2 * c * d))));
    }
}
