package chapter_10;

import java.util.Scanner;

/**
 * Klasse mit der Main-Methode
 * @author sebastian
 */
public class Main {

    public static void main(String[] args) throws MyException {
        boolean caseSensitive;
        /*
         * Prüft ob bei dem aufruf des Programmes ein Parameter übergeben wurde.
         * Wenn dies der fall ist und der Parameter true oder false ist, wird dieser
         * in einer Variable gespeichert. Andernfalls wird eine exception geworfen.
         */
        if (args.length != 0 && (args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("false"))) {
            caseSensitive = Boolean.parseBoolean(args[0]);
        } else
            throw new MyException();

        IO io = new IO(caseSensitive);
        int option;

        Scanner sc = new Scanner(System.in);
        do {
            //Hier werden die auswahlmöglichkeiten ausgegeben
            System.out.println("Bitte wähle einer der Folgenden Optionen aus:");
            System.out.println("1) Einen Artikel von der Tagesschau herunterladen.");
            System.out.println("2) Eine Datei laden.");
            System.out.println("3) Wörter ausgeben.");
            System.out.println("0) Programm Beenden.");
            do {
                /*
                 * Wenn der Nutzer einen Buchstaben oder eine Zahl außerhalb des wertebereiches
                 * angibt wird eine entsprechende Fehlermeldung angegeben.
                 */
                if (!sc.hasNextInt()) {
                    System.out.println("Es sind nur Zahlen erlaubt");
                    sc.next();
                } else if ((option = sc.nextInt()) > 4 || option < 0)
                    System.out.println("Zahl außerhalb des Bereiches!");
                else
                    break;
            } while (true);

            //Bei einer erfolgreichen eingabe, wird eine dieser Optionen ausgeführt
            switch (option) {
                case 1:
                    System.out.println("Bitte gebe den Link an:");
                    io.loadContentFromWebsite(input());
                    break;
                case 2:
                    System.out.println("Bitte geben Sie den Datei namen an:");
                    io.readFromFile(input());
                    break;
                case 3:
                    io.printContent(true);
                    break;
            }
        } while (option > 0);

        sc.close();
    }

    //Der Input wird hier zu einem String zusammengeführt
    public static String input() {
        Scanner sc = new Scanner(System.in);
        String tmp;
        tmp = sc.next();
        tmp += sc.nextLine();
        return tmp;
    }
}
