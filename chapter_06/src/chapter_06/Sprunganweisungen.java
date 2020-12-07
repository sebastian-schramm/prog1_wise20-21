package chapter_06;

import java.util.Scanner;

/**
 * Klasse mit der Main-Methode
 * @author Sebastian
 *
 */
public class Sprunganweisungen {
	private static int id;
	private static String pw;

	public static void main(String[] args) {
		login();
	}
	
	/**
	 * Kleine einfache Implementierung von Nutzern, mithilfe
	 * einer switch-Anweisung
	 * @param userID
	 * @param userPw
	 * @return
	 */
	private static boolean userData(int userID, String userPw) {
		switch (userID) {
		case 1:
			return userPw.equals("hallo")? true:false;
		case 112:
			return userPw.equals("das")? true:false;
		case 124:
			return userPw.equals("ist")? true:false;
		case 345:
			return userPw.equals("nicht")? true:false;
		case 653:
			return userPw.equals("geheim")? true:false;
		}
		return false;
	}
	
	/**
	 * Hier befinded sich das Login feld
	 */
	private static void login() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Wilkommen...!");
			System.out.print("ID      : ");
			
			/*
			 * Eine kleine Abfrage die Prüft, ob die eingegebene
			 * ID nur aus Zahlen besteht
			 */
			while (!sc.hasNextInt()) {
				System.out.println("Error, es dürfen nur Zahlen enthalten sein.");
				sc.nextLine();
			}
			id = sc.nextInt();
			
			System.out.print("Passwort: ");
			/*
			 * Wenn ein Nutzer mit dem angegebenen Passwort
			 * nicht existiert, wird die ID zurückgesetzt 
			 * und eine Fehlermeldung wird ausgegeben
			 */
			if(!userData(id, sc.next())) { 
				id = 0;
				System.out.println("Ihre Angaben sind leider falsch, versuchen Sie es erneut.");
			}
			
		/*
		 * Die Schleife wird solange durchlaufen, bis sich ein nutzer
		 * erfolgreich angemeldet hat.
		 */
		} while (id == 0);
		
		System.out.println("Juhu, Sie haben sich eingeloggt");
//		sc.close();
	}
	
	

}
