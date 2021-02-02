package chapter_07.figures;

public class Rechteck extends Parallelogramm {

    public Rechteck(double a, double b) {
        super(a, b);
        this.b = b;
    }

    @Override
    public double umfang() {
        return (a + b) * 2;
    }

    @Override
    public double flächeninhalt() {
        return a * b;
    }
}
