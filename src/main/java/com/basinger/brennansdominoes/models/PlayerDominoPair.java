package com.basinger.brennansdominoes.models;

public class PlayerDominoPair {
    private Player player;
    private Domino domino;

    public PlayerDominoPair(Player player, Domino domino) {
        this.player = player;
        this.domino = domino;
    }

    public Player getPlayer() {
        return player;
    }

    public Domino getDomino() {
        return domino;
    }

    @Override
    public String toString() {
        return "PlayerDominoPair{" +
                "player=" + player +
                ", domino=" + domino +
                '}';
    }
}