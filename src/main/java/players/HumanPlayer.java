package main.java.players;

import main.java.Round;
import main.java.Trick;
import main.java.cards.Card;

import java.util.InputMismatchException;
import java.util.List;
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
        System.out.println("Your hand: " + hand + ", Vous pouvez jouer :");
        List<Card> allowed = computeAllowedCards(trick);
        for (int i = 0; i <allowed.size(); i++) {
            System.out.println(i + 1 + ". " + allowed.get(i));
        }
        System.out.println(getName() + ", play a card: ");

        int cardIndex = -1;
        boolean validInput = false;

        // Boucle pour demander la saisie tant que l'indice est incorrect
        while (!validInput) {
            try {
                cardIndex = scanner.nextInt() - 1;  // On enlève 1 car l'utilisateur choisit entre 1 et n, mais les index commencent à 0

                if (cardIndex >= 0 && cardIndex < allowed.size()) {
                    validInput = true;  // L'entrée est valide
                } else {
                    System.out.println("Indice invalide, veuillez réessayer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrée non valide, veuillez saisir un nombre.");
                scanner.next();  // Pour vider l'entrée incorrecte
            }
        }

        // Retourne la carte choisie
        return allowed.get(cardIndex);


    }

}
