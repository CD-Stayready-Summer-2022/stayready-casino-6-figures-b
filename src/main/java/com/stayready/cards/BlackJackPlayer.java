package com.stayready.cards;

import com.stayready.Player;

public class BlackJackPlayer extends Player {
    private Hand hand;

    public BlackJackPlayer(String name, Integer age, Double money) {
        super(name,age, money);
        this.hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }


}
