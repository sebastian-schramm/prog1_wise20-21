package chapter_06;

import java.util.Scanner;

public class Sprunganweisungen {
	private static int id;
	private static String pw;

	public static void main(String[] args) {
		login();
	}
	
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
	
	private static void login() {
		Scanner sc = new Scanner(System.in);
		String pw;
		do {
			System.out.println("Wilkommen...!");
			System.out.print("ID      : ");
			
			while (!sc.hasNextInt()) {
				System.out.println("Error, es dürfen nur Zahlen enthalten sein.");
				sc.nextLine();
			}
			id = sc.nextInt();
			
			System.out.print("Passwort: ");
			if(!userData(id, sc.next())) {
				id = 0;
				System.out.println("Ihre Angaben sind leider falsch, versuchen Sie es erneut.");
			}
			
		} while (id == 0);
		
		System.out.println("Juhu, Sie haben sich eingeloggt");
//		sc.close();
	}
	
	

}
