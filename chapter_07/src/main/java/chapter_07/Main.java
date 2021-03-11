package chapter_07;

import chapter_07.figures.*;

public class Main {

    public static void main(String[] args) {
        KonvexesViereck konvexesViereck = new KonvexesViereck(60, 80, 50, 60, 70);
        System.out.println(konvexesViereck.umfang() + " " + konvexesViereck.flächeninhalt());

        Trapez trapez = new Trapez(15, 10, 5, 30);
        System.out.println(trapez.umfang() + " " + trapez.flächeninhalt());

        Parallelogramm parallelogramm = new Parallelogramm(15, 10, 8);
        System.out.println(parallelogramm.umfang() + " " + parallelogramm.flächeninhalt());

        Rhombus rhombus = new Rhombus(8, 5.657);
        System.out.println(rhombus.umfang() + " " + rhombus.flächeninhalt());

        Rechteck rechteck = new Rechteck(5, 10);
        System.out.println(rechteck.umfang() + " " + rechteck.flächeninhalt());

        Quadrat quadrat = new Quadrat(5);
        System.out.println(quadrat.umfang() + " " + quadrat.flächeninhalt());
    }
}
