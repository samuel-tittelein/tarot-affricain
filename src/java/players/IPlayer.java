package java.players;

import java.cards.Card;
import java.Round;
import java.Trick;
import java.util.List;

public interface IPlayer {
    String getName();
    int getLife();
    void decreaseLife();
    List<Card> getHand();
    void receiveCard(Card card);
    int makeBid(Round round);
    Card play(Trick trick);
    String toString();
}
