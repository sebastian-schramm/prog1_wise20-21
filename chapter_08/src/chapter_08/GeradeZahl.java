package chapter_08;

public class GeradeZahl {
    private int zahl1;

    /**
     * Konstruktor, hier wird geprüft ob es sich bei der Zahl um eine gerade Zahl handelt
     * @param zahl1
     */
    public GeradeZahl(int zahl1) {
        OddException oddexception = new OddException();
        this.zahl1 = zahl1;

        //Wenn die Zahl ungerade ist, wird eine Exception geworfen
        try {
            if (zahl1%2 == 1) throw oddexception;
        } catch ( OddException a ) {
            //Bei einer Exception wird eine ausgabe getätigt, zusätzlich wird die Zahl um eins erhöht
            System.out.println(a.getMessage(this.zahl1++));
        }
    }

    /**
     * Addiert Zwei GeradeZahl objekte miteinander
     * @param zahl2
     * @return Git eine int Zahl zurück
     */
    public int plus(GeradeZahl zahl2) {
        return zahl1 + zahl2.getZahl();
    }

    /**
     * Multipliziert Zwei GeradeZahl objekte miteinander
     * @param zahl2
     * @return Gibt eine int Zahl zurück
     */
    public int mult(GeradeZahl zahl2) {
        return zahl1 * zahl2.getZahl();
    }

    /**
     * Multipliziert ein GeradeZahl objekte mit einer int Zahl
     * @param zahl2
     * @return Gibt eine int Zahl zurück
     */
    public int mult(int zahl2) {
        return zahl1 * zahl2;
    }

    /**
     * @return Liefert die Zahl zurück
     */
    public int getZahl() {
        return zahl1;
    }

    /**
     * Bei einem Print wird diese Methode ausgeführt
     * @return Liefert einen String mit der Zahl zurück
     */
    @Override
    public String toString() {
        return "" + getZahl();
    }
}
