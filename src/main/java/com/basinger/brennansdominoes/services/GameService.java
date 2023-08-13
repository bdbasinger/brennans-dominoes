package com.basinger.brennansdominoes.services;

import com.basinger.brennansdominoes.Position;
import com.basinger.brennansdominoes.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {

    //Only need once instance of the game class at a time for now...
    @Autowired
    private Game game;

    public Game startNewGame() {

        Game game = new Game(new Player("1","PLAYER 1"), new Player("1","PLAYER 2"));

        List<Domino> shuffledDominoes = shuffleDominoes();

        // Distribute dominoes to players
        game.getPlayer1().setHand(new LinkedList<>(shuffledDominoes.subList(0, 7)));
        game.getPlayer2().setHand(new LinkedList<>(shuffledDominoes.subList(7, 14)));

        System.out.println("Player 1's Dominoes: " + game.getPlayer1().getHand().toString());
        System.out.println("Player 2's Dominoes: " + game.getPlayer2().getHand().toString());

        // Set up the Draw From Pile
        game.setBoneyard(new LinkedList<>(shuffledDominoes.subList(14,28)));

        System.out.println("Boneyard Dominoes: " + game.getBoneyard().toString());

        // Initialize the board and place the highest double domino
        // This logic also adjusts the players' hands and sets the score
        initializeBoardWithHighestDouble(game);

        return game;
    }

    public Move makeMove(Game game, Player player, Domino domino) {
        // 1. Check if it's the player's turn
        if (player != game.getCurrentPlayer()) {
            throw new IllegalArgumentException("It's not this player's turn");
        }

        //If

        // 2. Validate if the move is legal
        List<Domino> playableDominoes = computePlayableDominoes(game);  // Assuming you've a method to compute playable dominoes


        if (!playableDominoes.contains(domino)) {
            // Player will have to draw from the boneyard instead of throwing this exception
            throw new IllegalArgumentException("Invalid move");
        }


        // 3. Update the board with the new domino
        game.getDominoBoard().addToBottomTrain(domino);
        player.getHand().remove(domino);

        // 4. Compute scores if necessary
        int newScore = computeScore(game); // Assuming you've a method to compute score based on the board state
        player.setScore(player.getScore() + newScore);

        // 5. Switch players for the next turn
        if (game.getCurrentPlayer() == game.getPlayer1()) {
            game.setCurrentPlayer(game.getPlayer2());
        } else {
            game.setCurrentPlayer(game.getPlayer1());
        }

        return new Move(game.getCurrentPlayer(), domino, Position.TOP_ENDPOINT);  // Assuming the Move object stores the player and the domino played
    }

    //NEED TO IMPLEMENT
    private int computeScore(Game game) {
        return 0;
    }

    //NEED TO IMPLEMENT
    private List<Domino> computePlayableDominoes(Game game) {
        return game.getDominoBoard().getTopTrain();
    }




    public Game checkGameOver(Game game) {
        // Check for game over condition
        if(game.getPlayer1().getScore() >= 100 || game.getPlayer2().getScore() >= 100) {
            // End game and declare a winner
            game.setGameOver(true);
        }
        return game;
    }

    private List<Domino> shuffleDominoes() {
        //list of all dominoes
        List<Domino> dominoes = new LinkedList<>();

        //add dominoes to dominoes list
        for(int i = 0; i <= 6; i++) {
            for(int j = 0; j <= i; j++) {
                dominoes.add(new Domino(i, j));
            }
        }
        //shuffle them up a little bit
        Collections.shuffle(dominoes);
        //voila
        return dominoes;
    }


    private void initializeBoardWithHighestDouble(Game game) {

        // Find both the highest double domino and the player that has it - could return null
        PlayerDominoPair playerDominoPair = getHighestDoubleFromBothHands(
                game.getPlayer1(),
                (LinkedList<Domino>) game.getPlayer1().getHand(),
                game.getPlayer2(),
                (LinkedList<Domino>) game.getPlayer2().getHand()
        );

        // If there are no doubles found in either players hands
        if (playerDominoPair == null)
            // Set the current player to be player1
            game.setCurrentPlayer(game.getPlayer1());
        else {
            // If we found the player with the highest double domino
            Player playerWithHighestDouble = playerDominoPair.getPlayer();
            Domino highestDouble = playerDominoPair.getDomino();
            // Keep a record of the central piece on the domino board
            game.getDominoBoard().setCentralDomino(highestDouble);


        }


        // If found, place the highest double on the board and adjust the score



/*        // If found, place the highest double on the board and adjust the score

        if(highestDouble != null) {
            game.getDominoBoard().addToTopTrain(highestDouble);
            playerWithHighestDouble.getDominoes().remove(highestDouble);
            playerWithHighestDouble.setScore(playerWithHighestDouble.getScore() + 2 * highestDouble.getLeftValue());
        }*/
    }

    private Domino computeHighestDouble(LinkedList<Domino> hand) {
        return hand.stream()
                .filter(Domino::isDouble)
                .max(Comparator.comparing(Domino::getLeftValue)) // since it's a double, we can use either left or right value for comparison
                .orElse(null); // returns null if no double is found
    }

    public PlayerDominoPair getHighestDoubleFromBothHands(Player player1, LinkedList<Domino> hand1, Player player2, LinkedList<Domino> hand2) {
        Domino highestDoubleHand1 = computeHighestDouble(hand1);
        Domino highestDoubleHand2 = computeHighestDouble(hand2);

        if(highestDoubleHand1 != null)
            System.out.println("Highest Double in hand 1: " + highestDoubleHand1);
        if(highestDoubleHand2 != null)
            System.out.println("Highest Double in hand 2: " + highestDoubleHand2);


        // Now, we'll compare the highest doubles from both hands to get the overall highest.
        if (highestDoubleHand1 == null && highestDoubleHand2 == null) {
            return null; // no doubles in both hands
        } else if (highestDoubleHand1 == null) {
            return new PlayerDominoPair(player2, highestDoubleHand2);
        } else if (highestDoubleHand2 == null) {
            return new PlayerDominoPair(player1, highestDoubleHand1);
        } else {
            if (highestDoubleHand1.getLeftValue() >= highestDoubleHand2.getLeftValue()) {
                return new PlayerDominoPair(player1, highestDoubleHand1);
            } else {
                return new PlayerDominoPair(player2, highestDoubleHand2);
            }
        }
    }




    // add other helper methods or logic as needed.
}

