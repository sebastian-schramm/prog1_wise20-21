package chapter_05;

@SuppressWarnings("unused")
public class Operatoren {
	//Schreiben Sie ein Programm, welches alle Operatoren in Java verwendet.
	/**
	 * Klasse mit der Main-Methode
	 * Dieses Programm solle alle Operatoren,
	 * die in Java existieren verdeutlichen
	 * @param args
	 */
	public static void main(String[] args) {
		arithmetisch();
		inkrement();
		vergleiche();
		boolische();
		bitshifting();
		zuweisung();
	}
	
	private static void arithmetisch() {
		System.out.println("23 + 34 = " + (23 + 34));	// Addition
		System.out.println("54 - 32 = " + (54 - 32));	// Subtraktion
		System.out.println("12 * 30 = " + 12 * 30);		// Multiplikation
		System.out.println("56 / 12 = " + 56 / 12);		// Division
		System.out.println("74 % 2  = " + 74 % 2);		// Teilerrest, Modulo-Operation, errechnet den Rest einer Division
		int i;
		System.out.println("int i = +3 = " + (i = +3));	// positives Vorzeichen
		int n;
		System.out.println("int n = -i = " + (n = -i));	//negatives Vorzeichen 
	}
	
	private static void inkrement() {
		int x = 10;
		System.out.println("x   = " + x);
		System.out.println("x++ = " + x++);	//Postinkrement: Weist zuerst zu, dann hochzählen
		System.out.println("x   = " + x);
		System.out.println("++x = " + ++x);	//Preinkrement: Zählt erst hoch, dann zuweisen
		System.out.println("x   = " + x);
		System.out.println("x-- = " + x--);	//Postinkrement: Weist zuerst zu, dann hochzählen
		System.out.println("x   = " + x);
		System.out.println("--x = " + --x);	//Preinkrement: Zählt erst hoch, dann zuweisen
		System.out.println("x   = " + x);
	}
	
	private static void vergleiche() {
		System.out.println("37 == 2 = " + (37 == 2));	// gleich
		System.out.println("1 != 2 = " + (1 != 2));		// ungleich
		System.out.println("13 > 3 = " + (13 > 3));		// größer
		System.out.println("23 < 2 = " + (23 < 2));		// kleiner
		System.out.println("23 >= 23 = " + (23 >= 23));	// größer oder gleich
		System.out.println("45 <= 44 = " + (45 <= 44));	// kleiner oder gleich
	}
	
	@SuppressWarnings("unused")
	private static void boolische() {
		System.out.println("!true = "  + !true);					// Negation
		System.out.println("true && true = "  + (true && true));	// Und, ture 2, genau dann wenn alle Argumente true sind
		System.out.println("true || false = "  + (true || false));	// Oder, true, wenn mindestens ein Operand true ist
		System.out.println("true ^ true = "  + (true ^ true));		// Xor, true, wenn genau ein Operand true ist
	}
	
	private static void bitshifting() {
		int bit = 0b01000100;
		System.out.println(Integer.toBinaryString(~bit));
		System.out.println("0b10111011 = ~0b01000100"); //Invertiert die Bits
		System.out.println("0b10101010 & 0b11111111 = " + Integer.toString(0b10101010 & 0b11111111, 2)); // Verundet die Bits
		System.out.println("0b10101010 | 0b01101001 = " + Integer.toString(0b10101010 | 0b00101001, 2)); // Verodert die Bits
		System.out.println("0b10101010 ^ 0b11111111 = " + Integer.toString(0b10101010 ^ 0b11111111, 2)); // Exklusives oder
		System.out.println("0b10101010 >> 2 = " + Integer.toString(0b10101010 >> 2, 2));				 // Rechtsshift
		System.out.println("0b10101010 >>> 1 = " + Integer.toString(0b10101010 >>> 1, 2));				 // Rechtsshift mit Nullen auffüllen
		System.out.println("0b10101010 << 1 = " + Integer.toString(0b10101010 << 1, 2));				 // Linksverschiebung
	}
	
	private static void zuweisung() {
		int a = 20;
		System.out.println("int a = 20"); 					// Einfache zuweisung
		System.out.println("a += 10 => " + (a += 10)); 		// Addiert ein wert zu der Variable
		System.out.println("a -= 20 => " + (a -= 20)); 		// Subtrahiert ein wert zu der Variable
		System.out.println("a *= 7 => " + (a *= 7)); 		// Dividiert die Variable durch den angegebenen Wert und weist ihn zu
		System.out.println("a /= 5 => " + (a /= 5)); 		// Multipliziert die Variable durch den angegebenen Wert und weist ihn zu
		System.out.println("a %= 5 => " + (a %= 5)); 		// Ermittelt den Rest und weist ihn zu
		System.out.println("a &= 12 => " + (a &= 12)); 		// Eine bitweise verundung
		System.out.println("a |= 10 => " + (a |= 10)); 		// Bitweise veroderung
		System.out.println("a ^= 30 => " + (a ^= 30)); 		// Exklusives oder auf Bitebene
		System.out.println("a <<= 3 => " + (a <<= 3)); 		// Linksverschiebung
		System.out.println("a >>= 1 => " + (a >>= 1)); 		// Rechtsverschiebung
		System.out.println("a >>>= 2 => " + (a >>>= 2)); 	// Rechtsverschiebung und Auffüllen mit Nullen
	}

}
