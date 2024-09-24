package main.java;

import main.java.cards.Card;
import main.java.cards.DeckOfCard;
import main.java.players.IPlayer;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Round {

    private final List<IPlayer> players;
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
        for (int i = 0; i < numberOfCards; i++) {
            Trick trick = new Trick();
            playTrick(trick);
        }

        for (int i = 0; i < players.size(); i++) {
            players.get(i).decreaseLife(getPenalty(i));
        }

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

    public int getTotalBids() { //je sais pas ou on traite le cas où le total des paris ne doit pas être égal au nb de carte
        int totalBids = 0;
        for (int i = 0; i < numberOfBids; i++) {
            totalBids += bids[i];
        }
        return totalBids;
    }

    private void askBids() {
        int firstPlayer = currentPlayer;
        int nbPlayers = players.size();
        for (int i = 0; i < nbPlayers; i++) {
            int playerIndex = (i + firstPlayer) % nbPlayers;
            bids[numberOfBids] = players.get(playerIndex).makeBid(this);
            numberOfBids++;
        }
    }

    private void playTrick(Trick trick) {
        int firstPlayer = currentPlayer;
        int nbPlayers = players.size();
        for (int i = 0; i < nbPlayers; i++) {
            int playerIndex = (i + firstPlayer) % nbPlayers;
            Card card = players.get(playerIndex).play(trick);
            trick.play(playerIndex, card);
        }
        currentPlayer = trick.getWinner();
    }

    public int getPenalty(int playerIndex) {
        return abs(scores[playerIndex] - bids[playerIndex]);
    }

}
