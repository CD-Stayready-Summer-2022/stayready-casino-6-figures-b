package com.stayready.cards;

public class Card {
    private CardValue value;
    private CardSuit suit;

    public Card(CardValue value, CardSuit suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o){
        if (this == o ) return true;
        return false;
    }

    public CardValue getValue() {
        return value;
    }

    public CardSuit getSuit() {
        return suit;
    }

    @Override
    public String toString(){
        return String.format("[Suit: %s, Value: %s]", suit.name, value.name);
    }
}
