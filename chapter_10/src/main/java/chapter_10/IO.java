package chapter_10;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IO{
    private ArrayList<String> wordsUnsorted;
    private ArrayList<String> wordsSorted;
    private final boolean caseSensitive;

    private static final String searchHeadline = "class=\"meldungskopf__headline--text\"";
    private static final String searchSubtitleSmall = "class=\"meldung_";
    private static final String searchTextSmall = "textabsatz columns twelve\"";

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";

    public IO(boolean caseSensitive){
        this.caseSensitive = caseSensitive;
    }

    /**
     * Listet die einzelnen wörter aus dem ausgewählten Artikel auf und gibt
     * zusätzlich der Anzahl an
     * @param sorted Noch keinen nutzen
     */
    public void printContent(boolean sorted) {
        //Zuerst wird geprüft ob eine Datei eingelesen wurde
        if (wordsSorted != null) {
            ArrayList<String> tmpWords = new ArrayList<>(wordsSorted);
            //Der erste eintrag wird in einen String geschrieben
            String currentWord = tmpWords.get(0);
            int countWords = 0;

            for (int i = 0; i < tmpWords.size(); ++i) {
                /*
                 * Falls das Wort übereinstimmt mit dem zwischengespeichertem word, wird der
                 * Counter um eins erhöht und der aktuelle eintrag gelöscht
                 */
                if (caseSensitive ? currentWord.equals(tmpWords.get(i)) : currentWord.equalsIgnoreCase(tmpWords.get(i))) {
                    ++countWords;
                    tmpWords.remove(i--);
                /*
                 * Falls die Wörter unterschiedlich sind, wird das aktuelle Word ausgegeben plus
                 * deren Anzahl, anschließend wird aktuelle word mit dem neuen ersetzt und der
                 * counter zurückgesetzt
                 */
                } else {
                    System.out.println(currentWord + " " + countWords + "x");
                    currentWord = tmpWords.get(i);
                    countWords = 1;
                }
            }
        } else
            //Ausgabe, falls keine Datei eingelesen wurde
            System.out.println(ANSI_RED + "Es wurde noch keine Datei Geladen!" + ANSI_RESET);
    }

    /**
     * Lädt einen Artikel von der Tagesschau herunter
     * @param link Link von dem Artikel
     */
    public void loadContentFromWebsite(String link) {
        ArrayList<String> webContent = null;
        Scanner sc = null;

        try {
            System.out.println("Loading Content");
            /*
             * Baut eine verbindung zu Seite auf und lädt den Inhalt herunter
             */
            sc = new Scanner(new URL(link).openStream());
            webContent = new ArrayList<>();
            String line;

            //Wenn inhalt gefunden wurde, wird die Schleife ausgeführt
            while (sc.hasNextLine()) {
                /*
                 * Jetzt gehen Zeile für Zeile durch den Inhalt.
                 * Da wir uns nur für den Artikel interessieren suchen wir nach drei verschiedenen HTML
                 * Tags, einmal für dei beiden Überschriften und da wo sich der Text befinden.
                 * Wenn wir diese Zeile gefunden haben entfernen wir anschließend alle HTML
                 * Tags aus dieser Zeile, sodass wir nur noch den Text über haben
                 */
                line = sc.nextLine();
                if (line.contains(searchTextSmall)) {
                    line = sc.nextLine();
                    System.out.println(line.stripLeading().replaceAll("&amp;", "&").replaceAll("\\<.*?\\>\\h*", ""));
                    webContent.add(line.stripLeading().replaceAll("&amp;", "&").replaceAll("\\<.*?\\>\\h*", ""));
                }
                if (line.contains(searchHeadline) || line.contains(searchSubtitleSmall)) {
                    System.out.println(line.stripLeading().replaceAll("\\<.*?\\>\\h*", ""));
                    webContent.add(line.stripLeading().replaceAll("\\<.*?\\>\\h*", ""));
                }
            }
            System.out.println("Loading done");
        } catch (IOException e) {
            System.out.println(ANSI_RED + "Es konnte keine Verbindung hergestellt werden. Bitte überprüfen Sie die angegebene address, oder ihre Internetverbindung!" + ANSI_RESET);
        } finally {
            if (sc != null)
                sc.close();
        }

        writeToFile(webContent);
    }

    /**
     * Hier wird der Artikel in eine txt gespeichert
     * @param content Text, der von der Webseite runtergeladen wurde
     */
    public void writeToFile(ArrayList<String> content) {
        FileWriter out = null;

        if (content != null && content.size() != 0)
            try {
                //Setzt den Dateinamen fest
                out = new FileWriter(content.get(0).replaceAll("[^a-zA-ZäöüÄÖÜß&%\\h-]", "") + ".txt");

                //Fügt jede Zeile vom content hinzu und fügt ein Zeilenumbruch am ende hinzu
                for (String s : content)
                    out.append(s + "\n");
                System.out.println("Data written do file called: " + content.get(0).replaceAll("[^a-zA-ZäöüÄÖÜß%&\\h-]", "") + ".txt\n");
            } catch (IOException e) {
                System.out.println("Datei konnte nicht erstellt werden");
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        else
            System.out.println(ANSI_RED + "Error, kein Inhalt gefunden!" + ANSI_RESET);
    }

    public void readFromFile(String filename) {
        //Lädt die Datei
        try (Scanner sc = new Scanner(new FileReader(filename + ".txt"))) {
            wordsUnsorted = new ArrayList<>();
            wordsSorted = new ArrayList<>();

            while (sc.hasNextLine()) {
                /*
                 * Läuft durch jede Zeile und entfernt alle unerwünschten Zeichen
                 * Anschließen wird bei Jeden Leerzeichen ein split gemacht
                 */
                String[] line = sc.nextLine().replaceAll("[\\h]-", " ").replaceAll(" ", "").replaceAll("[^a-zA-ZäöüÄÖÜß&\\h-]", "").split(" ");
                for (String words : line)
                    /*
                     * Hier wird noch kurz geprüft der String befüllt ist
                     * Anschließend wird er in einer Collection gespeichert
                     */
                    if (!words.equals("")) {
                        wordsUnsorted.add(words);
                        wordsSorted.add(words);
                    }
            }
            //Zum schluss wird die Collection noch Alphabetisch sortiert
            Collections.sort(wordsSorted);
            Collections.sort(wordsSorted, String.CASE_INSENSITIVE_ORDER);
            System.out.println("Datei wurde Erfolgreich geladen\n");
        } catch (IOException e) {
            System.out.println(ANSI_RED + "Error, es wurde noch keine Datei geladen!" + ANSI_RESET);
        }
    }
}
