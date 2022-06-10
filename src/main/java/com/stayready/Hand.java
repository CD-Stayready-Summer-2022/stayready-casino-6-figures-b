package com.stayready;

import java.util.ArrayList;

public class Hand extends Deck {
    private ArrayList<Card> cards;
    private int cardIndex;


    public void addCard(String suit, Integer value){
        cards.add(new Card(suit, value));
    }

    public void removeCard(int cardIndex){
        this.cardIndex = cardIndex;
        cards.remove(cardIndex);
    }
}
