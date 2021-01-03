package figures;

public class Rhombus extends Parallelogramm {

    public Rhombus(double a, double hA) {
        super(a, hA);
    }

    @Override
    public double umfang() {
        return a * 4;
    }

    @Override
    public double flächeninhalt() {
        return a * hA;
    }
}
