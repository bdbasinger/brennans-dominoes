package com.basinger.brennansdominoes.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Component
public class Game {

    private Player player1;
    private Player player2;
    private List<Domino> boneyard; // Pile to draw from
    private Player currentPlayer; // The player whose turn it is
    private final DominoBoard dominoBoard;




    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.dominoBoard = new DominoBoard();
        //this.board = new ArrayList<>();
        this.boneyard = new ArrayList<>();
        // Initially, currentPlayer will be null until the game determines who plays the first move.
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public List<Domino> getBoneyard() {
        return boneyard;
    }

    public void setBoneyard(List<Domino> boneyard) {
        this.boneyard = boneyard;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public String toString() {
        return "Game{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                //", board=" + board +
                ", boneyard=" + boneyard +
                ", currentPlayer=" + currentPlayer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(player1, game.player1) &&
                Objects.equals(player2, game.player2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player1, player2);
    }


    public void setGameOver(boolean b) {
        System.out.println("PLAYER X WINS!");
    }

    public DominoBoard getDominoBoard() {
        return this.dominoBoard;
    }
}
