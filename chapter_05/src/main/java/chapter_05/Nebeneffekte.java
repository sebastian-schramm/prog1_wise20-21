package chapter_05;

/**
 * Klasse mit der Main-Methode
 * @author Sebastian
 *
 */
public class Nebeneffekte {

	public static void main(String[] args) {
		int x = 10;
		int y = ++x+x;
		int z = y+++--x;
		System.out.println("Der Wert von x lautet: " + x);
		System.out.println("Der Wert von y lautet: " + y);
		System.out.println("Der Wert von z lautet: " + z);
	}

}
