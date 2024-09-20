package java.cards;

public class TwoExcusesException extends Exception  {
    public TwoExcusesException() {
        super("Can't have two excuses!");
    }
}
