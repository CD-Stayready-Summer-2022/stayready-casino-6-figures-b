package com.stayready.games;

import com.stayready.Deck;

public abstract class CardGame implements Game{

    protected Deck deck;

    public CardGame() {
        this.deck = new Deck();
        deck.shuffle();
    }

}
