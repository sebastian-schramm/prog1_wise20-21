package chapter_08;

public class GeradeZahl {
    private int zahl1;

    /**
     * Konstruktor, hier wird geprüft ob es sich bei der Zahl um eine gerade Zahl handelt
     * @param zahl1
     */
    public GeradeZahl(int zahl1) throws OddException {
        this.zahl1 = zahl1;

        //Wenn die Zahl ungerade ist, wird eine Exception geworfen
        if (zahl1%2 == 1) throw new OddException(zahl1);
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
