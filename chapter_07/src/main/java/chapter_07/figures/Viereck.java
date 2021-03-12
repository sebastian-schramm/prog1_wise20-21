package chapter_07.figures;

abstract class Viereck {

    abstract double flächeninhalt();
    abstract double umfang();

    protected double round(double value) {
        return Math.round(value * 10000.0) / 10000.0;
    }
}
