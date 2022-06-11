package com.stayready.cards;

import com.stayready.deck.Deck;
import com.stayready.games.Game;

public abstract class CardGame implements Game {
    protected Deck deck;

    public CardGame(){
        this.deck = new Deck();
        deck.shuffle();
    }
}
