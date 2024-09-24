package main.java.players;

import main.java.Round;
import main.java.Trick;
import main.java.cards.Card;

import java.util.List;

public interface IPlayer {
    String getName();
    int getLife();
    void decreaseLife();
    void decreaseLife(int life);
    List<Card> getHand();
    void receiveCard(Card card);
    int makeBid(Round round);
    Card play(Trick trick);
    String toString();
}
