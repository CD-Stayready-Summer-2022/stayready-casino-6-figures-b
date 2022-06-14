package com.stayready.cards;

import com.stayready.Player;

public class Dealer extends Player {
    private Hand hand;

    public Dealer(String name) {
        super(name);
        this.hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }
}
