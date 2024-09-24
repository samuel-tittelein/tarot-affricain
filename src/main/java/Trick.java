package main.java;

import main.java.cards.Card;
import main.java.cards.TwoExcusesException;

import java.util.ArrayList;
import java.util.List;

public class Trick {
    private final List<Card> cards = new ArrayList<>();
    private int bestCardIndex;
    private int bestPlayerIndex;

    public Trick() {
        super();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public void play(int playerIndex, Card card) {
        boolean bigger = true;
        try {
            bigger = card.compareTo(cards.get(bestCardIndex)) > 0 ;
        } catch (TwoExcusesException e) {
            System.out.println("Error: " + e.getMessage());
        }
        if (isEmpty() || bigger) {
            bestCardIndex = cards.size();
            bestPlayerIndex = playerIndex;
        }
        cards.add(card);
    }

    public Card getBestCard() {
        return cards.get(bestCardIndex);
    }

    public int getWinner() {
        return bestPlayerIndex;
    }

}
