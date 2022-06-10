package com.stayready;

public enum CardSuit {
    CLUBS("Club"), SPADES("Spades"), HEARTS("Hearts"), DIAMONDS("Diamonds");

    public final String name;

    CardSuit(String name) {
        this.name = name;
    }

}
