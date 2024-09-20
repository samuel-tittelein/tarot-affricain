package java.cards;

import java.util.Objects;

public class Excuse implements ITrump {
    boolean highValue;

    public Excuse() {

    }

    void setHighValue(boolean highValue) {
        this.highValue = highValue;
    }

    boolean isHighValue() {
        return highValue;
    }

    public int compareTo(ITrump otherTrump) throws TwoExcusesException {
        return -otherTrump.compareTo(this);
    }

    public int compareTo(NumberedTrump otherTrump) {
        return isHighValue() ? 1 : -1;
    }

    public int compareTo(Excuse otherExcuse) throws TwoExcusesException {
        throw new TwoExcusesException();
        //return Integer.compare(this.highValue ? 1 : 0, otherExcuse.highValue ? 1 : 0);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(highValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Excuse excuse = (Excuse) o;
        return highValue == excuse.highValue;
    }

    @Override
    public String toString() {
        return isHighValue() ? "TWENTY_TWO" : "ZERO";
    }

}
