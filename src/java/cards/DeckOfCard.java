package java.cards;


import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class DeckOfCard {
    private final List<Card> cards = new ArrayList<>();

    private DeckOfCard() {
        super();
    }

    public static DeckOfCard newDeck() {
        DeckOfCard newDeck = new DeckOfCard();
        newDeck.cards.clear();
        for (NumberedTrump trump : NumberedTrump.values()) {
            newDeck.cards.add(new Card(trump));
        }
        newDeck.cards.add(new Card(new Excuse()));
        return newDeck;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.getLast();
    }
}
