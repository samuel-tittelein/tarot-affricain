package main.java.players;

import main.java.Round;
import main.java.Trick;
import main.java.cards.Card;

import java.util.List;
import java.util.Random;

public class ComputerPlayer extends AbstractPlayer {

    private static final Random RANDOM = new Random();

    public ComputerPlayer(String name) {
        super(name);
    }

    public int makeBid(Round round) {
        return RANDOM.nextInt(round.getNumberOfBids()) + 1;
    }

    public Card play(Trick trick) {
        List<Card> allowed = computeAllowedCards(trick);
        int randomIndex = RANDOM.nextInt(allowed.size());
        return allowed.get(randomIndex);
    }
}
