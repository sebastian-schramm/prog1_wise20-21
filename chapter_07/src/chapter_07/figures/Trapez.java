package chapter_07.figures;

public class Trapez extends KonvexesViereck {
    protected double hA;

    public Trapez(double a, double c, double hA) {
        this.a = a;
        this.c = c;
        this.hA = hA;
    }

    @Override
    public double flächeninhalt() {
        return ((a + c) * hA) / 2;
    }

}
