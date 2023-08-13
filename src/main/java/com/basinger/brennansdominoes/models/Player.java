package com.basinger.brennansdominoes.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


@Component
public class Player {

    private String id;
    private LinkedList<Domino> hand;
    private Integer score;
    private String playerName;

    public Player(String id, String playerName) {
        this.id = id;
        this.playerName = playerName;
        this.hand = new LinkedList<>();
        this.score = 0;
    }

    public Player() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<Domino> getHand() {
        return this.hand;
    }

    public void setHand(LinkedList<Domino> dominos) {
        this.hand = dominos;
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
                ", playerName='" + playerName + '\'' +
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




    //NEED TO IMPLEMENT
    public List<Domino> getDominoes() {
        return this.hand;
    }
}