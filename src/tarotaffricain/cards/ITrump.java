package tarotaffricain.cards;

public interface ITrump {
    int compareTo(ITrump otherTrump) throws TwoExcusesException;
    int compareTo(NumberedTrump otherTrump);
    int compareTo(Excuse otherExcuse) throws TwoExcusesException;
}
