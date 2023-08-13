package com.basinger.brennansdominoes.models;

import com.basinger.brennansdominoes.Position;

import java.util.*;


/*
public class DominoBoard {

    private LinkedList<Domino> dominoes;
    private Set<Integer> endpoints;  // to quickly identify the current playable values

    private List<Domino> topTrain = new LinkedList<>();
    private List<Domino> bottomTrain = new LinkedList<>();
    private List<Domino> leftTrain = new LinkedList<>();
    private List<Domino> rightTrain = new LinkedList<>();




    public DominoBoard() {
        this.dominoes = new LinkedList<>();
        this.endpoints = new HashSet<>();
    }

    public DominoBoard(LinkedList<Domino> dominoes, Set<Integer> endpoints, List<Domino> topTrain, List<Domino> bottomTrain, List<Domino> leftTrain, List<Domino> rightTrain) {
        this.dominoes = dominoes;
        this.endpoints = endpoints;
        this.topTrain = topTrain;
        this.bottomTrain = bottomTrain;
        this.leftTrain = leftTrain;
        this.rightTrain = rightTrain;
    }


    public void addDominoToFront(Domino domino) {
        if (dominoes.isEmpty()) {
            endpoints.add(domino.getSide1());
            endpoints.add(domino.getSide2());
        } else {
            endpoints.remove(dominoes.getFirst().getSide1());
            endpoints.add(domino.getSide1());
        }
        dominoes.addFirst(domino);
    }

    public void addDominoToEnd(Domino domino) {
        if (dominoes.isEmpty()) {
            endpoints.add(domino.getSide1());
            endpoints.add(domino.getSide2());
        } else {
            endpoints.remove(dominoes.getLast().getSide2());
            endpoints.add(domino.getSide2());
        }
        dominoes.addLast(domino);
    }

    public Set<Integer> getEndpoints() {
        return this.endpoints;
    }

    public List<Domino> getDominoes() {
        return this.dominoes;
    }

    public List<Domino> getTopTrain() {
        return topTrain;
    }

    public void setTopTrain(List<Domino> topTrain) {
        this.topTrain = topTrain;
    }

    public List<Domino> getBottomTrain() {
        return bottomTrain;
    }

    public void setBottomTrain(List<Domino> bottomTrain) {
        this.bottomTrain = bottomTrain;
    }

    public List<Domino> getLeftTrain() {
        return leftTrain;
    }

    public void setLeftTrain(List<Domino> leftTrain) {
        this.leftTrain = leftTrain;
    }

    public List<Domino> getRightTrain() {
        return rightTrain;
    }

    public void setRightTrain(List<Domino> rightTrain) {
        this.rightTrain = rightTrain;
    }

    public void setDominoes(LinkedList<Domino> dominoes) {
        this.dominoes = dominoes;
    }

    public void setEndpoints(Set<Integer> endpoints) {
        this.endpoints = endpoints;
    }


 */

    public class DominoBoard {

        private List<Domino> topTrain = new LinkedList<>();
        private List<Domino> bottomTrain = new LinkedList<>();
        private List<Domino> leftTrain = new LinkedList<>();
        private List<Domino> rightTrain = new LinkedList<>();

        private Domino lastTopDomino;
        private Domino lastBottomDomino;
        private Domino lastLeftDomino;
        private Domino lastRightDomino;



        public void addToTopTrain(Domino domino) {
            topTrain.add(domino);
        }

        // Add domino to the bottom train
        public void addToBottomTrain(Domino domino) {
            bottomTrain.add(domino);
        }

        // Add domino to the left train
        public void addToLeftTrain(Domino domino) {
            leftTrain.add(domino);
        }

        // Add domino to the right train
        public void addToRightTrain(Domino domino) {
            rightTrain.add(domino);
        }

        // Get last domino from top train
        public Domino getLastFromTopTrain() {
            return (topTrain.isEmpty()) ? null : topTrain.get(topTrain.size() - 1);
        }

        // Get last domino from bottom train
        public Domino getLastFromBottomTrain() {
            return (bottomTrain.isEmpty()) ? null : bottomTrain.get(bottomTrain.size() - 1);
        }

        // Get last domino from left train
        public Domino getLastFromLeftTrain() {
            return (leftTrain.isEmpty()) ? null : leftTrain.get(leftTrain.size() - 1);
        }

        // Get last domino from right train
        public Domino getLastFromRightTrain() {
            return (rightTrain.isEmpty()) ? null : rightTrain.get(rightTrain.size() - 1);
        }

        // Utility methods to check if any train is empty
        public boolean isTopTrainEmpty() {
            return topTrain.isEmpty();
        }

        public boolean isBottomTrainEmpty() {
            return bottomTrain.isEmpty();
        }

        public boolean isLeftTrainEmpty() {
            return leftTrain.isEmpty();
        }

        public boolean isRightTrainEmpty() {
            return rightTrain.isEmpty();
        }

        // Getters for the trains if needed
        public List<Domino> getTopTrain() {
            return topTrain;
        }

        public List<Domino> getBottomTrain() {
            return bottomTrain;
        }

        public List<Domino> getLeftTrain() {
            return leftTrain;
        }

        public List<Domino> getRightTrain() {
            return rightTrain;
        }

        public Domino getLastTopDomino() {
            return lastTopDomino;
        }

        public void setLastTopDomino(Domino lastTopDomino) {
            this.lastTopDomino = lastTopDomino;
        }

        public Domino getLastBottomDomino() {
            return lastBottomDomino;
        }

        public void setLastBottomDomino(Domino lastBottomDomino) {
            this.lastBottomDomino = lastBottomDomino;
        }

        public Domino getLastLeftDomino() {
            return lastLeftDomino;
        }

        public void setLastLeftDomino(Domino lastLeftDomino) {
            this.lastLeftDomino = lastLeftDomino;
        }

        public Domino getLastRightDomino() {
            return lastRightDomino;
        }

        public void setLastRightDomino(Domino lastRightDomino) {
            this.lastRightDomino = lastRightDomino;
        }

        // You can also add methods to clear trains or initialize them if needed.
    }

