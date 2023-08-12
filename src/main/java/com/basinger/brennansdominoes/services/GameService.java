package com.basinger.brennansdominoes.services;

import com.basinger.brennansdominoes.models.Domino;
import com.basinger.brennansdominoes.models.Game;
import com.basinger.brennansdominoes.models.Move;
import com.basinger.brennansdominoes.models.Player;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class GameService {

    public Game startNewGame() {
        Game game = new Game(new Player("1"),new Player("1"));

        List<Domino> shuffledDominoes = shuffleDominoes();

        // Distribute dominoes to players
        game.getPlayer1().setDominoes(new LinkedList<>(shuffledDominoes.subList(0, 7)));
        game.getPlayer2().setDominoes(new LinkedList<>(shuffledDominoes.subList(7, 14)));

        // Initialize the board and place the highest double domino
        // This logic also adjusts the players' hands and sets the score
        initializeBoardWithHighestDouble(game);

        return game;
    }

    public Move makeMove(Game game, Player player, Domino domino) {
        // Your logic to check if the move is valid, update the board, and compute scores.
        // Remember to return the result as a Move object, including any changes to the game state.
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
        List<Domino> dominoes = new LinkedList<>();

        for(int i = 0; i <= 6; i++) {
            for(int j = 0; j <= i; j++) {
                dominoes.add(new Domino(i, j));
            }
        }

        Collections.shuffle(dominoes);
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
            game.getBoard().add(highestDouble);
            playerWithHighestDouble.getDominoes().remove(highestDouble);
            playerWithHighestDouble.setScore(playerWithHighestDouble.getScore() + 2 * highestDouble.getLeftValue());
        }
    }

    // You can add other helper methods or logic as needed.
}

