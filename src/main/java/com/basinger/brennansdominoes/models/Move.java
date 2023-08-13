package com.basinger.brennansdominoes.models;

import com.basinger.brennansdominoes.Position;
import org.springframework.stereotype.Component;

import java.util.Objects;


public class Move {

    private Integer playerId; // The ID of the player making the move
    private Player player;
    private Domino domino;
    private Position trainPosition; // This can be "left", "right", "top", or "bottom" depending on where they want to place the domino relative to the board


    public Move(Player player, Domino domino, Position position) {
        this.player = player;
        this.domino = domino;
        this.trainPosition = position;
    }

    public Move(Domino domino, Position position) {
        this.domino = domino;
        this.trainPosition = position;
    }

    public Move() {
    }

    public Player getPlayer() {
        return player;
    }

    public Position getTrainPosition() {
        return trainPosition;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Domino getDomino() {
        return domino;
    }

    public void setDomino(Domino domino) {
        this.domino = domino;
    }

    public Position getPosition() {
        return trainPosition;
    }

    public void setPosition(Position position) {
        this.trainPosition = position;
    }

    @Override
    public String toString() {
        return "Move{" +
                "playerId='" + playerId + '\'' +
                ", domino=" + domino +
                ", train='" + trainPosition + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return Objects.equals(playerId, move.playerId) &&
                Objects.equals(domino, move.domino) &&
                Objects.equals(trainPosition, move.trainPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, domino, trainPosition);
    }

}
