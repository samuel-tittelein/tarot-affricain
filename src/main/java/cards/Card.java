package main.java.cards;

import java.util.Objects;

public class Card {
    private ITrump trump;

    public Card(ITrump trump) {
        this.trump = trump;
    }

    public int compareTo(Card otherCard) throws TwoExcusesException {
        return trump.compareTo(otherCard.trump);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Card card = (Card) o;
        return Objects.equals(trump, card.trump);
    }

    @Override
    public int hashCode() {

        return Objects.hashCode(trump);
    }

    @Override
    public String toString() {

        return "Card{" +
               "trump=" + trump +
               '}';
    }

}
