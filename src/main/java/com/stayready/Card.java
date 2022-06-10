package com.stayready;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private CardValue value;
    private CardSuit suit;

    public Card(CardValue value, CardSuit suit) {
        this.value = value;
        this.suit = suit;
    }

    public CardValue getValue() {
        return value;
    }

    public CardSuit getSuit() {
        return suit;
    }

    @Override
    public String toString(){
        return String.format("Suit: %s, Value: %s", suit.name, value.name);
    }
}
