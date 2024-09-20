package java.cards;

public enum NumberedTrump implements ITrump {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    ELEVEN,
    TWELVE,
    THIRTEEN,
    FOURTEEN,
    FIFTEEN,
    SIXTEEN,
    SEVENTEEN,
    EIGHTEEN,
    NINETEEN,
    TWENTY,
    TWENTY_ONE;

    public int compareTo(ITrump otherTrump) {
        return -otherTrump.compareTo(this);
    }

    public int compareTo(Excuse otherExcuse) {
        return otherExcuse.isHighValue() ? 1 : -1;
    }
}
