package main.java;

import main.java.players.ComputerPlayer;
import main.java.players.HumanPlayer;
import main.java.players.IPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public static final int NB_PLAYERS = 4;
    public static final int LIFE = 12;
    public static final int MAX_CARDS_IN_HAND = 7;

    private final List<IPlayer> players = new ArrayList<>();
    private int currentPlayer;
    private int numberOfCards;
    private int increment;

    public Game(){
        super();
    }

    public void init() {
        Scanner scanner;
        for (int i = 0; i < NB_PLAYERS; i++) {
            System.out.println("Enter the name of player " + (i + 1) + ":");
            scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            System.out.println(name + " est il un joueur humain ?");
            scanner = new Scanner(System.in);
            boolean human = scanner.nextBoolean();
            if (human) {
                players.add(new HumanPlayer(name));
            } else {
                players.add(new ComputerPlayer(name));
            }
        }
        numberOfCards = MAX_CARDS_IN_HAND;
        currentPlayer = 0;
    }

    public void start(){
        while (allPlayersAreAlive()) {
            playRound();
            displayLife();
            nextRound();
        }
    }

    private boolean allPlayersAreAlive() {
        for (IPlayer player : players) {
            if (player.getLife() < 0) {
                return false;
            }
        }
        return true;
    }

    private void playRound() {
        Round round = new Round(players, currentPlayer, numberOfCards);
        round.play();
        currentPlayer = (currentPlayer + 1) % NB_PLAYERS;
    }

    private void nextRound() {
        numberOfCards += increment;
        if (numberOfCards <= 0 || numberOfCards >= MAX_CARDS_IN_HAND) {
            increment = -increment;
        }
    }

    private void displayLife() {
        for (IPlayer player : players) {
            System.out.println(player.getName() + ": " + player.getLife() + " points de vie");
        }
    }
}
