package chapter_04;

/**
 * Klasse mit der Main-Methode
 * und prüft ob Zwei Referenzen gleich sind
 * @author Sebastian
 *
 */
public class Referenzen {

	public static void main(String[] args) {
		/*
		 * Es werden zwei identische Objekte erzeugt
		 * mit den selben Werten.
		 * Zuletzt wird noch ein drittes erzeugt mit einer
		 * Referenz auf das erste 
		 */
		Punkt p1 = new Punkt(10, 20);
		Punkt p2 = new Punkt(10, 20);
		Punkt p3 = p1;
		
		//Hier wird geprüft ob p1 und p2 die selbe Adresse hat.
		if (p1 == p2)
			System.out.println("Ist gleich");
		else
			System.out.println("Ist ungleich");
		
		//Hier wird geprüft ob der Inhalt der selbe ist
		if (p1.equals(p2))
			System.out.println("Ist gleich");
		else
			System.out.println("Ist ungleich");
		
		//Hier wird geprüft ob p3 und p1 gleich sind
		if (p3 == p1)
			System.out.println("Ist gleich");
		else
			System.out.println("Ist ungleich");
	}

}
