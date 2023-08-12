package com.basinger.brennansdominoes.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {

    private String id;
    private List<Domino> hand;
    private int score;

    public Player(String id) {
        this.id = id;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Domino> getHand() {
        return hand;
    }

    public void setHand(List<Domino> hand) {
        this.hand = hand;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", hand=" + hand +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }




}