package java;

import java.players.ComputerPlayer;
import java.players.HumanPlayer;
import java.players.IPlayer;

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
        //TODO
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


    }

    public void start(){
        //TODO
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
        //TODO
    }

    private void nextRound() {
        //TODO
    }

    private void displayLife() {
        //TODO
    }
}
