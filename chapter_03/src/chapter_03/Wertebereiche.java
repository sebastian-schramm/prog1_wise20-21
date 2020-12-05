package chapter_03;

/** 
 * Klasse mit der Main-Methode
 * und gibt die Wertebereiche der primitieven Datentypen aus
 * @author Sebastian
 */
public class Wertebereiche {

	public static void main(String[] args) {
		//Min und Max Value von Byte
		System.out.println("Byte min " + Byte.MIN_VALUE + " | Byte max " + Byte.MAX_VALUE);
		//Min und Max Value von Short
		System.out.println("Short min " + Short.MIN_VALUE + " | Short max " + Short.MAX_VALUE);
		//Min und Max Value von Integer
		System.out.println("Integer min " + Integer.MIN_VALUE + " | Integer max " + Integer.MAX_VALUE);
		//Min und Max Value von Long
		System.out.println("Long min " + Long.MIN_VALUE + " | Byte Long " + Long.MAX_VALUE);

		//Min und Max Value von Char
		System.out.println("Char min " + Character.MIN_VALUE + " | Char max " + Character.MAX_VALUE);
		//System.out.println("\u0000 | \uffff");

		//Min und Max Value von Float
		System.out.println("Float min " + Float.MIN_VALUE + " | Float max " + Float.MAX_VALUE);
		//Min und Max Value von Double
		System.out.println("Double min " + Double.MIN_VALUE + " | Double max " + Double.MAX_VALUE);
	}

}
