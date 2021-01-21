package chapter_10;

public class MyException extends Exception {

    @Override
    public String getMessage() {
        return "Error, nur true oder false erlaubt";
    }
}
