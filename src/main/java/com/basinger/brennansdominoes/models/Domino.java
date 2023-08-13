package com.basinger.brennansdominoes.models;

import java.util.Objects;

public class Domino {

    private int leftValue;
    private int rightValue;

    public Domino(int leftValue, int rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }


    public int getLeftValue() {
        return leftValue;
    }

    public void setLeftValue(int leftValue) {
        this.leftValue = leftValue;
    }

    public int getRightValue() {
        return rightValue;
    }

    public void setRightValue(int rightValue) {
        this.rightValue = rightValue;
    }

    public int totalValue() {
        return leftValue + rightValue;
    }

    @Override
    public String toString() {
        return leftValue + "-" + rightValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domino domino = (Domino) o;
        return leftValue == domino.leftValue &&
                rightValue == domino.rightValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftValue, rightValue);
    }

    //NEED TO IMPLEMENT
    public boolean isDouble() {
        return this.leftValue == this.rightValue;
    }

    //NEED TO IMPLEMENT
    public Integer getSide1() {
        return 1;
    }

    //NEED TO IMPLEMENT
    public Integer getSide2() {
        return 1;
    }
}
