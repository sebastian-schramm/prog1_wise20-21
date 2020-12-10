package chapter_06;

import java.util.Scanner;
/**
 * Klasse mit der Main-Methode
 * Addiert und Multipliziert Matrizen
 * @author Sebastian
 *
 */
public class Matrizen {

	public static void main(String[] args) {
		int matrixA[][];
		int matrixB[][];
		
		//Hier können sie die Größe definieren, z.B. 2,3 oder 5
		System.out.println("Dieses Programm berechnet eine zufällig erstellte nxn Matrix");
		System.out.print("Geben sie n an: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		/*
		 * Initialisierungsmethode wird mit dem Wert n aufgerufen.
		 * Anschließend wird diese Matrix erzeugt und mit 
		 * zufällig generierten Zahlen befüllt.
		 */
		matrixA = initialize(n);
		matrixB = initialize(n);

		/*
		 * Zuerst werden die Beiden Matrizen A und B jeweils ausgegeben
		 */
		System.out.println("Matrix A:");
		printMatrix(matrixA);
		System.out.println("Matrix B:");
		printMatrix(matrixB);
		/*
		 * Anschließend werden die Matrizen hier Addiert
		 */
		System.out.println("Addition von A und B:");
		printMatrix(addition(matrixA, matrixB));
		/*
		 * Und hier Multipliziert
		 */
		System.out.println("Multiplikation von A und B:");
		System.out.println("For Schleife");
		printMatrix(multiplikationFor(matrixA, matrixB));
		System.out.println("While Schleife");
		printMatrix(multiplikationWhile(matrixA, matrixB));
		System.out.println("Do-While Schleife");
		printMatrix(multiplikationDoWhile(matrixA, matrixB));
		
		sc.close();
	}
	
	/**
	 * Initialisierung des Arrays
	 * @param n Die größe der nxn Matrix
	 * @return matrix
	 */
	private static int[][] initialize(int n) {
		int matrix[][] = new int[n][n];
		/*
		 * Bei der Initialisierung wird einmal durch das gesamt Array durch iteriert.
		 * Dabei werden dann mit Math.random() zufällige Zahlen rein geschrieben.
		 */
		for (int i = 0; i < matrix.length; ++i)
			for (int l = 0; l < matrix[i].length; ++l)
				matrix[i][l] = (int) (Math.random() * 100);
		
		return matrix;
	}
	
	/**
	 * Addition der beiden Matrizen A und B
	 * @param matrixA
	 * @param matrixB
	 * @return Gibt ein neues Array mit den Addierten Werten zurück
	 */
	private static int[][] addition(int matrixA[][], int matrixB[][]) {
		int matrixAd[][] = new int[matrixA.length][matrixA[0].length]; //Es wird ein neues Temporäres Array angelegt
		
		for (int i = 0; i < matrixA.length; ++i) {
			for (int n = 0; n < matrixA[i].length; ++n) {
				matrixAd[i][n] = matrixA[i][n] + matrixB[i][n];
			}
		}
		
		return matrixAd;
	}
	
	/**
	 * Multiplikation der beiden Matrizen A und B
	 * @param matrixA
	 * @param matrixB
	 * @return Gibt ein neues Array mit den Multiplizierten Werten zurück
	 */
	private static int[][] multiplikationFor(int matrixA[][], int matrixB[][]) {
		int matrixMult[][] = new int[matrixB.length][matrixB[0].length];
		
		//Hier die Variante mit For Schleifen
		for (int HmatrixB = 0; HmatrixB < matrixB.length; ++HmatrixB)
			for (int WmatrixB = 0; WmatrixB < matrixB[HmatrixB].length; ++WmatrixB)
				for (int WmatrixA = 0; WmatrixA < matrixB.length; ++WmatrixA)
					matrixMult[HmatrixB][WmatrixB] += matrixA[HmatrixB][WmatrixA] * matrixB[WmatrixA][WmatrixB];
		
		return matrixMult;
	}
	
	/**
	 * Multiplikation der beiden Matrizen A und B
	 * @param matrixA
	 * @param matrixB
	 * @return Gibt ein neues Array mit den Multiplizierten Werten zurück
	 */
	private static int[][] multiplikationWhile(int matrixA[][], int matrixB[][]) {
		int matrixMult[][] = new int[matrixB.length][matrixB[0].length];
		
		int HmatrixB = 0;
		int WmatrixB = 0;
		int WmatrixA = 0;
		
		//Hier die Variante mit While Schleifen
		while (HmatrixB < matrixB.length) {
			WmatrixB = 0;
			while (WmatrixB < matrixB[HmatrixB].length) {
				WmatrixA = 0;
				while (WmatrixA < matrixB.length) {
					matrixMult[HmatrixB][WmatrixB] += matrixA[HmatrixB][WmatrixA] * matrixB[WmatrixA][WmatrixB];
					++WmatrixA;
				}
				++WmatrixB;
			}
			++HmatrixB;
		}
		return matrixMult;
	}
	
	/**
	 * Multiplikation der beiden Matrizen A und B
	 * @param matrixA
	 * @param matrixB
	 * @return Gibt ein neues Array mit den Multiplizierten Werten zurück
	 */
	private static int[][] multiplikationDoWhile(int matrixA[][], int matrixB[][]) {
		int matrixMult[][] = new int[matrixB.length][matrixB[0].length];
		
		int HmatrixB = 0;
		int WmatrixB = 0;
		int WmatrixA = 0;
		
		//Hier die Variante mit Do-While Schleifen
		do {
			WmatrixB = 0;
			do {
				WmatrixA = 0;
				do {
					matrixMult[HmatrixB][WmatrixB] += matrixA[HmatrixB][WmatrixA] * matrixB[WmatrixA][WmatrixB];
					++WmatrixA;
				} while (WmatrixA < matrixB.length);
				++WmatrixB;
			} while (WmatrixB < matrixB[HmatrixB].length);
			++HmatrixB;
		} while (HmatrixB < matrixB.length);
		
		return matrixMult;
	}
	
	/**
	 * Hier wird die Matrix ausgegeben
	 * @param matrix
	 */
	private static void printMatrix(int matrix[][]) {
		for (int y[]: matrix) {
			for (int x: y)
				System.out.print(x + "\t");
			System.out.println();
		}
		System.out.println();
	}

}
