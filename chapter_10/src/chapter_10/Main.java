package chapter_10;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        IO io1 = new IO("https://www.tagesschau.de/eilmeldung/nawalny-moskau-101.html", false);
        IO io2 = new IO("https://www.tagesschau.de/investigativ/rbb/menschenhandel-kinder-101.html", true);

        //io1.loadContentFromWebsite();
        io1.readFromFile("Kreml-Kritiker Nawalny in Moskau gelandet");
        io1.printContent(true);
    }
}
