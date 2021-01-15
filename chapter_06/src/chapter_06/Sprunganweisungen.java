package chapter_06;

import java.util.Scanner;

/**
 * Klasse mit der Main-Methode
 * @author Sebastian
 *
 */
public class Sprunganweisungen {

	public static void main(String[] args) {
		login();
	}
	
	/**
	 * Kleine einfache Implementierung von Nutzern, mithilfe
	 * einer switch-Anweisung
	 * @param userID ID die beim login eingegeben wurde
	 * @param userPw Password was bei login eingegeben wurde
	 * @return Wenn die ID und das Passwort übereinstimmen,
	 * wird true zurück gegeben
	 */
	private static boolean userData(int userID, String userPw) {
		return switch (userID) {
			case 1 -> userPw.equals("hallo");
			case 112 -> userPw.equals("das");
			case 124 -> userPw.equals("ist");
			case 345 -> userPw.equals("nicht");
			case 653 -> userPw.equals("geheim");
			default -> false;
		};
	}
	
	/**
	 * Hier befindet sich das Login feld
	 */
	private static void login() {
		int id;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Willkommen...!");
			System.out.print("ID      : ");
			
			/*
			 * Eine kleine Abfrage die Prüft, ob die eingegebene
			 * ID nur aus Zahlen besteht
			 */
			do {
				if (!sc.hasNextInt()) {
					System.out.println("Error, es dürfen nur Zahlen enthalten sein.");
					System.out.print("ID      : ");
				} else
					break;
				sc.nextLine();
			} while (true);
			id = sc.nextInt();
			
			System.out.print("Passwort: ");
			/*
			 * Wenn ein Nutzer mit dem angegebenen Passwort
			 * nicht existiert, wird die ID zurückgesetzt 
			 * und eine Fehlermeldung wird ausgegeben
			 */
			if(!userData(id, sc.next())) {
				System.out.println("Ihre Angaben sind leider falsch, versuchen Sie es erneut.");
			} else
				break;
			
		/*
		 * Die Schleife wird solange durchlaufen, bis sich ein nutzer
		 * erfolgreich angemeldet hat.
		 */
		} while (true);
		
		System.out.println("Juhu, Sie haben sich eingeloggt");
		sc.close();
	}
}
