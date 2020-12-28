package chapter_07.figures;

import static java.lang.Math.PI;

public class KonvexesViereck implements Viereck {
    protected double a = 0;
    protected double b = 0;
    protected double c = 0;
    protected double d = 0;

    private double f = 0;
    private double e = 0;

    protected double wAlpha = 0;
    protected double wBeta = 0;
    protected double wGamma = 0;
    protected double wDelta = 0;

    protected double volumen;

    public KonvexesViereck() {}

//    public KonvexesViereck() {
//
//    }

//    public KonvexesViereck() {
//
//    }

//    public KonvexesViereck() {
//
//    }

    public KonvexesViereck(double diagonaleF, double diagonaleE, double winkelTheta) {

    }

    public KonvexesViereck(double a, double b, double c, double d, double winkelAlpha) {

    }

    @Override
    public double flächeninhalt() {
        return 0;
    }

    @Override
    public double umfang() {
        return a + b + c + d;
    }

    private void calcE() {
        if (wAlpha != 0)
            f = Math.sqrt(a*a + b*b - 2 * a * b * Math.cos(wBeta) * PI / 180);
        else
            f = Math.sqrt(c*c + d*d - 2 * c * d * Math.cos(wDelta) * PI / 180);
    }

    private void calcF() {
        if (wAlpha != 0)
            f = Math.sqrt(a*a + d*d - 2 * a * b * Math.cos(wAlpha) * PI / 180);
        else
            f = Math.sqrt(b*b + c*c - 2 * b * c * Math.cos(wGamma) * PI / 180);
    }

    private void calcAlpha() {
        wAlpha = Math.acos(((a*a + d*d - f*f) / (2 * a * d)) * PI / 180);
    }

    private void calcBeta() {
        wAlpha = Math.acos(((a*a + b*b - e*e) / (2 * a * b)) * PI / 180);
    }

    private void calcGamma() {
        wAlpha = Math.acos(((b*b + c*c - f*f) / (2 * b * c)) * PI / 180);
    }

    private void calcDelta() {
        wAlpha = Math.acos(((a*a + d*d - e*e) / (2 * c * d)) * PI / 180);
    }
}
