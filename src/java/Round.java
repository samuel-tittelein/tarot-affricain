package java;

import java.cards.DeckOfCard;
import java.players.IPlayer;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Round {

    private List<IPlayer> players = new ArrayList<IPlayer>();
    private int [] bids;
    private int numberOfBids;
    private int [] scores;
    private int currentPlayer;
    private DeckOfCard deck;
    int numberOfCards;


    public Round(List<IPlayer> players, int currentPlayer, int numberOfCards) {
        this.players = players;
        this.currentPlayer = currentPlayer;
        this.numberOfCards = numberOfCards;
        scores = new int[players.size()];
    }

    public List<IPlayer> getPlayers() {
        return players;
    }

    public void play() {
        dealCards();
        askBids();


        currentPlayer++;
    }

    private void dealCards() {
        deck = DeckOfCard.newDeck();
        deck.shuffle();
        for (IPlayer player : players) {
            for (int i = 0; i < numberOfCards; i++) {
                player.receiveCard(deck.draw());
            }
        }
    }

    public int getNumberOfBids() {
        return numberOfBids;
    }

    public int getTotalBids() {
        //TODO
        int totalBids = 0;
        for (int i = 0; i < numberOfBids; i++) {
            totalBids += bids[i];
        }
        return totalBids;
    }

    private void askBids() {
        for (IPlayer player : players) {
            bids[numberOfBids] = player.makeBid(this);
            numberOfBids++;
        }
    }

    private void playTrick(Trick trick) {
        //TODO
        int firstPlayer =
        for (int i = 0; i < numberOfCards; i++) {

            for (IPlayer player : players) {

                playTrick(player);
                firstPlayer = trick.getWinner();
            }

        }
    }

    public int getPenalty(int playerIndex) {
        return abs(scores[playerIndex] - bids[playerIndex]);
    }

}
