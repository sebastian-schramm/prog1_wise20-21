package chapter_05;

/**
 * Klasse mit der Main-Methode
 * @author Sebastian
 *
 */
public class Nebeneffekte {

	public static void main(String[] args) {
		int i = 2;
		int k = --i+i;
		int j = (i = 3) * (i+++--k);
		System.out.println("Der Wert von j ist: " + j);
	}

}
