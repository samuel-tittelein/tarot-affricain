package java.players;

import java.Round;
import java.Trick;
import java.cards.Card;

import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {
    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name) {
        super(name);
    }

    public int makeBid(Round round) {

        System.out.println(getName() + ", faites votre pari: ");
        return readBid(round);
    }

    private int readBid(Round round) {
        int bid;
        try {
            bid = scanner.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Entrez un entier !");
            bid = makeBid(round);
        }
        if (bid < 0 || bid > round.getNumberOfBids()) {
            System.out.println("Votre pari doit être compris entre 0 et " + round.getNumberOfBids() + "!");
            bid = makeBid(round);
        }

        return bid;
    }

    public Card play(Trick trick) {
        System.out.println("Trick: " + trick);
        System.out.println("Your hand: " + hand);
        System.out.println(getName() + ", play a card: ");
        int cardIndex = scanner.nextInt();
        return trick.play(, cardIndex);//TODO
    }

}
