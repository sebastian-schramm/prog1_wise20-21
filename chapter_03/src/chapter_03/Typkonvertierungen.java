package chapter_03;

/** 
 * Klasse mit der Main-Methode
 * und der einzelnen Typkonvertierungen
 * @author Sebastian
 */
public class Typkonvertierungen {

	public static void main(String[] args) {
		/*
		 * Rund die einzelnen Methoden auf, mit entsprechenden Werten
		 */
		convertByte((byte) -128);
		convertShort((short) 34);
		convertInt(98987);
		convertLong(987987987);
		
		convertChar('a');
		
		convertFloat(15.0f);
		convertDouble(1.7976931348623157E308);
	}
	
	/**
	 * Eine erweiternde Konvertierung von Byte zu Double
	 * @param _byte
	 */
	private static void convertByte(byte _byte) {
		short newShort = _byte;
		int newInt = _byte;
		long newLong = _byte;
		float newFloat = _byte;
		double newDouble = _byte;

		System.out.println("---------------------");
		System.out.println("Byte erweiternd");
		System.out.println("Byte   " + _byte);
		System.out.println("Short  " + newShort);
		System.out.println("Int    " + newInt);
		System.out.println("Long   " + newLong);
		System.out.println("FLoat  " + newFloat);
		System.out.println("Bouble " + newDouble);
		System.out.println("\nChar   " + (char) newInt); //Char wird hier separat ausgegeben
		System.out.println("---------------------");
	}
	
	/**
	 * Eine einschraenkende Konvertierung von Short zu Byte
	 * Eine erweiternde Konvertierung von Short zu Double
	 * @param _short
	 */
	private static void convertShort(short _short) {
		byte newByte = (byte) _short;
		int newInt = _short;
		long newLong = _short;
		float newFloat = _short;
		double newDouble = _short;
		
		System.out.println("Short einschraenkend");
		System.out.println("Short  " + _short);
		System.out.println("Byte   " + newByte);

		System.out.println("Short erweiternd");
		System.out.println("Short  " + _short);
		System.out.println("Int    " + newInt);
		System.out.println("Long   " + newLong);
		System.out.println("FLoat  " + newFloat);
		System.out.println("Bouble " + newDouble);
		System.out.println("\nChar   " + (char) newInt); //Char wird hier separat ausgegeben
		System.out.println("---------------------");
	}
	
	/**
	 * Eine einschraenkende Konvertierung von Int zu Byte
	 * Eine erweiternde Konvertierung von Int zu Double
	 * @param _int
	 */
	private static void convertInt(int _int) {
		short newShort = (short) _int;
		byte newByte = (byte) _int ;
		
		long newLong = _int;
		float newFloat = _int;
		double newDouble = _int;
		
		System.out.println("Int einschraenkend");
		System.out.println("Int    " + _int);
		System.out.println("Short  " + newShort);
		System.out.println("Byte   " + newByte);

		System.out.println("Int erweiternd");
		System.out.println("Int    " + _int);
		System.out.println("Long   " + newLong);
		System.out.println("FLoat  " + newFloat);
		System.out.println("Bouble " + newDouble);
		System.out.println("\nChar   " + (char) _int); //Char wird hier separat ausgegeben
		System.out.println("---------------------");
	}
	
	/**
	 * Eine einschraenkende Konvertierung von Long zu Byte
	 * Eine erweiternde Konvertierung von Long zu Double
	 * @param _long
	 */
	private static void convertLong(long _long) {
		int newInt = (int) _long;
		short newShort = (short) _long;
		byte newByte = (byte) _long;
		
		float newFloat = _long;
		double newDouble = _long;
		
		System.out.println("Long einschraenkend");
		System.out.println("Long   " + _long);
		System.out.println("Int    " + newInt);
		System.out.println("Short  " + newShort);
		System.out.println("Byte   " + newByte);

		System.out.println("Long erweiternd");
		System.out.println("Long   " + _long);
		System.out.println("FLoat  " + newFloat);
		System.out.println("Bouble " + newDouble);
		System.out.println("\nChar   " + (char) newInt); //Char wird hier separat ausgegeben
		System.out.println("---------------------");
	}
	
	/**
	 * Eine einschraenkende Konvertierung von Char zu Byte
	 * Eine erweiternde Konvertierung von Char zu Double
	 * @param _char
	 */
	private static void convertChar(char _char) {
		int newInt = _char;
		short newShort = (short) _char;
		byte newByte = (byte) _char;
		
		long newLong = _char;
		float newFloat = _char;
		double newDouble = _char;
		
		System.out.println("Char einschraenkend");
		System.out.println("Char   " + _char);
		System.out.println("Long   " + newLong);
		System.out.println("Int    " + newInt);
		System.out.println("Short  " + newShort);
		System.out.println("Byte   " + newByte);

		System.out.println("Char erweiternd");
		System.out.println("Char   " + _char);
		System.out.println("Long   " + newLong);
		System.out.println("FLoat  " + newFloat);
		System.out.println("Bouble " + newDouble);
		System.out.println("---------------------");
	}
	
	/**
	 * Eine einschraenkende Konvertierung von FLoat zu Byte
	 * Eine erweiternde Konvertierung von FLoat zu Double
	 * @param _float
	 */
	private static void convertFloat(float _float) {
		long newLong = (long) _float;
		int newInt = (int) _float;
		short newShort = (short) _float;
		byte newByte = (byte) _float;
		
		double newDouble = _float;
		
		System.out.println("Float einschraenkend");
		System.out.println("FLoat  " + _float);
		System.out.println("Long   " + newLong);
		System.out.println("Int    " + newInt);
		System.out.println("Short  " + newShort);
		System.out.println("Byte   " + newByte);

		System.out.println("Float erweiternd");
		System.out.println("FLoat  " + _float);
		System.out.println("Bouble " + newDouble);
		System.out.println("\nChar   " + (char) newInt); //Char wird hier separat ausgegeben
		System.out.println("---------------------");
	}
	
	/**
	 * Eine einschraenkende Konvertierung von Double zu Byte
	 * @param _double
	 */
	private static void convertDouble(double _double) {
		float newFloat = (float) _double;
		long newLong = (long) _double;
		int newInt = (int) _double;
		short newShort = (short) _double;
		byte newByte = (byte) _double;

		System.out.println("Double einschraenkend");
		System.out.println("Bouble " + _double);
		System.out.println("FLoat  " + newFloat);
		System.out.println("Long   " + newLong);
		System.out.println("Int    " + newInt);
		System.out.println("Short  " + newShort);
		System.out.println("Byte   " + newByte);
		System.out.println("\nChar   " + (char) newInt); //Char wird hier separat ausgegeben
		System.out.println("---------------------");
	}

}
