package chapter_10;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IO{
    private final String website;
    private ArrayList<String> wordsUnsorted;
    private ArrayList<String> wordsSorted;
    private boolean caseSensitive;

    private static final String searchHeadline = "span class=\"headline\"";
    private static final String searchSubtitleSmall = "class=\"subtitle small \"";
    private static final String searchTextSmall = "class=\"text small\"";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";

    public IO(String link, boolean caseSensitive) throws IOException {
        this.website = link;
        this.caseSensitive = caseSensitive;
    }

    public void printContent(boolean sorted) {
        ArrayList<String> tmpWords = new ArrayList<>(wordsSorted);
        String currentWord = tmpWords.get(0);
        int countWords = 0;

        for (int i = 0; i < tmpWords.size(); ++i) {
            if (caseSensitive? currentWord.equals(tmpWords.get(i)): currentWord.equalsIgnoreCase(tmpWords.get(i))) {
                ++countWords;
                tmpWords.remove(i--);
            } else {
                System.out.println(currentWord + " " + countWords + "x");
                currentWord = tmpWords.get(i);
                countWords = 1;
            }
        }
    }

    private void printContent(ArrayList<String> words) {
        ArrayList<String> tmpWords = new ArrayList<>(words);
        String currentWord = tmpWords.get(0);
        int countWords = 0;

        for (int i = 0; i < tmpWords.size(); ++i) {
            if (caseSensitive? currentWord.equals(tmpWords.get(i)): currentWord.equalsIgnoreCase(tmpWords.get(i))) {
                ++countWords;
                tmpWords.remove(i--);
            } else {
                System.out.println(currentWord + " " + countWords + "x");
                currentWord = tmpWords.get(i);
                countWords = 1;
            }
        }
    }

    public void loadContentFromWebsite() {
        ArrayList<String> webContent = null;
        Scanner sc = null;

        try {
            sc = new Scanner(new URL(website).openStream());
            webContent = new ArrayList<String>();
            String line;

            while (sc.hasNextLine()) {
                line = sc.nextLine();

                String tmp = line;
                if (line.contains(searchHeadline) || line.contains(searchSubtitleSmall) || line.contains(searchTextSmall)) {
                    webContent.add(line.replaceAll("\\<.*?\\>\\h*", ""));
                }
            }
        } catch (IOException e) {
            System.out.println(ANSI_RED + "Es konnte keine Verbindung hergestellt werden. Bitte überprüfen Sie die angegebene address, oder ihre Internetverbindung!" + ANSI_RESET);
        } finally {
            if (sc != null)
                sc.close();
        }

        writeToFile(webContent);
    }

    public void writeToFile(ArrayList<String> content) {
        FileWriter out = null;
        if (content != null)
            try {
                out = new FileWriter(content.get(0) + ".txt");

                for (int i = 0; i < content.size(); ++i)
                    out.append(content.get(i) + "\n");
            } catch (IOException e) {

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
        Scanner sc = null;

        try {
            sc = new Scanner(new FileReader(filename + ".txt"));
            wordsUnsorted = new ArrayList<String>();
            wordsSorted = new ArrayList<String>();

            while (sc.hasNextLine()) {
                //[^a-zA-ZäöüÄÖÜß\h]
                String[] line = sc.nextLine().replaceAll(" - ", " ").replaceAll(" ", "").replaceAll("[^a-zA-ZäöüÄÖÜß\\h-]", "").split(" ");
                for (String words : line)
                    if (!words.equals("")) {
                        wordsUnsorted.add(words);
                        wordsSorted.add(words);
                    }
            }
            Collections.sort(wordsSorted);
            Collections.sort(wordsSorted, String.CASE_INSENSITIVE_ORDER);
        } catch (IOException e) {

        } finally {
            if (sc != null)
                sc.close();
        }
    }
}
