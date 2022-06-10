package com.stayready;

import java.util.ArrayList;

import java.util.Collections;

public class Hand {
    private ArrayList<Card> handCards;
    private int cardIndex;

    public Hand() {
        handCards = new ArrayList<>();
    }


    public void addCard(String suit, Integer value) {

    }

    public void removeCard(int cardIndex) {
        this.cardIndex = cardIndex;
        handCards.remove(cardIndex);
    }
}