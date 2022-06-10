package com.stayready;

import java.util.ArrayList;

public class Hand implements CardManager{
    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }


    @Override
    public Card removeCard(int cardIndex) {
        Card card = new Card(hand.get(cardIndex).getValue(),hand.get(cardIndex).getSuit());
        hand.remove(cardIndex);
        return card;
    }

    public void addCard(int cardIndex, Card card) {
        hand.add(cardIndex, card);
    }

    @Override
    public String toString() {
        return "Hand{" +
                "hand=" + hand +
                '}';
    }
}