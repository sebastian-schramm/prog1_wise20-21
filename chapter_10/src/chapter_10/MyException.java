package chapter_10;

public class MyException extends Exception {

    @Override
    public String getMessage() {
        return "Error, kein gültiger start Parameter, nur true oder false ist erlaubt!";
    }


}
