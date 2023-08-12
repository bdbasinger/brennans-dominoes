package com.basinger.brennansdominoes.models;

import java.util.Objects;

public class Move {

    private String playerId; // The ID of the player making the move
    private Domino domino;
    private String position; // This can be "left", "right", "top", or "bottom" depending on where they want to place the domino relative to the board


    public Move(String playerId, Domino domino, String position) {
        this.playerId = playerId;
        this.domino = domino;
        this.position = position;
    }

    public Move(Domino domino, String position) {
        this.domino = domino;
        this.position = position;
    }

    public Move() {
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Domino getDomino() {
        return domino;
    }

    public void setDomino(Domino domino) {
        this.domino = domino;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Move{" +
                "playerId='" + playerId + '\'' +
                ", domino=" + domino +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return Objects.equals(playerId, move.playerId) &&
                Objects.equals(domino, move.domino) &&
                Objects.equals(position, move.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, domino, position);
    }

}
