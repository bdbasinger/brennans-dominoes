package com.basinger.brennansdominoes.services;

import com.basinger.brennansdominoes.Position;
import com.basinger.brennansdominoes.models.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class GameService {

    public Game startNewGame() {

        Game game = new Game(new Player("1","PLAYER 1"), new Player("1","PLAYER 2"));

        List<Domino> shuffledDominoes = shuffleDominoes();

        // Distribute dominoes to players
        game.getPlayer1().setHand(new LinkedList<>(shuffledDominoes.subList(0, 7)));
        game.getPlayer2().setHand(new LinkedList<>(shuffledDominoes.subList(7, 14)));

        System.out.println("Player 1's Dominoes: " + game.getPlayer1().getHand().toString());
        System.out.println("Player 2's Dominoes: " + game.getPlayer2().getHand().toString());

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

        // 2. Validate if the move is legal
        List<Domino> playableDominoes = computePlayableDominoes(game);  // Assuming you've a method to compute playable dominoes
        if (!playableDominoes.contains(domino)) {
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
        Domino highestDouble = null;
        Player playerWithHighestDouble = null;

        for(Domino d : game.getPlayer1().getDominoes()) {
            if(d.isDouble() && (highestDouble == null || d.getLeftValue() > highestDouble.getLeftValue())) {
                highestDouble = d;
                playerWithHighestDouble = game.getPlayer1();
            }
        }

        for(Domino d : game.getPlayer2().getDominoes()) {
            if(d.isDouble() && (highestDouble == null || d.getLeftValue() > highestDouble.getLeftValue())) {
                highestDouble = d;
                playerWithHighestDouble = game.getPlayer2();
            }
        }

        // If found, place the highest double on the board and adjust the score
        if(highestDouble != null) {
            game.getDominoBoard().addToTopTrain(highestDouble);
            playerWithHighestDouble.getDominoes().remove(highestDouble);
            playerWithHighestDouble.setScore(playerWithHighestDouble.getScore() + 2 * highestDouble.getLeftValue());
        }
    }

    // You can add other helper methods or logic as needed.
}

