package java.players;

import java.Trick;
import java.cards.Card;

import java.util.List;

import static java.Game.LIFE;

public abstract class AbstractPlayer implements IPlayer {
    String name;
    List<Card> hand;
    int life;

    protected AbstractPlayer(String name) {
        this.name = name;
        this.life = LIFE;
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public void decreaseLife() {
        life--;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void receiveCard(Card card) {
        hand.add(card);
    }

    protected List<Card> computeAllowedCards(Trick trick) {
        //TODO
    }

    @Override
    public String toString() {

        return "AbstractPlayer{" +
               "name='" + name + "'" +
               ", hand=" + hand +
               ", life=" + life +
               '}';
    }

}
