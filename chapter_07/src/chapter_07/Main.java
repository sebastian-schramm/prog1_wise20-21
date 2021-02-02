package chapter_07;

import chapter_07.figures.*;

public class Main {

    public static void main(String[] args) {
        Trapez trapez = new Trapez(15, 5, 5);
        System.out.println(trapez.umfang() + " " + trapez.flächeninhalt());

        Parallelogramm parallelogramm = new Parallelogramm(20, 5);
        System.out.println(parallelogramm.umfang() + " " + parallelogramm.flächeninhalt());

        Rhombus rhombus = new Rhombus(5, 3);
        System.out.println(rhombus.umfang() + " " + rhombus.flächeninhalt());

        Rechteck rechteck = new Rechteck(5, 10);
        System.out.println(rechteck.umfang() + " " + rechteck.flächeninhalt());

        Quadrat quadrat = new Quadrat(5);
        System.out.println(quadrat.umfang() + " " + quadrat.flächeninhalt());
    }
}
