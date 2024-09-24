package main.java.players;

import main.java.Trick;
import main.java.cards.Card;
import main.java.cards.TwoExcusesException;

import java.util.ArrayList;
import java.util.List;

import static main.java.Game.LIFE;

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
    public void decreaseLife(int life) {
        this.life -= life;
    }
    public void decreaseLife() {
        decreaseLife(1);
    }

    public List<Card> getHand() {
        return hand;
    }

    public void receiveCard(Card card) {
        hand.add(card);
    }

    protected List<Card> computeAllowedCards(Trick trick) {
        List<Card> allowed = new ArrayList<>();
        Card maxCard = trick.getBestCard();
        for (Card c : this.hand) {
            try {
                if (c.compareTo(maxCard) > 0) {
                    allowed.add(c);
                }
            } catch (TwoExcusesException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        if (allowed.isEmpty()) {
            allowed = new ArrayList<>(this.hand);
        }

        return allowed;
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
