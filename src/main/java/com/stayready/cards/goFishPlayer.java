package com.stayready.cards;

import com.stayready.Player;

public class goFishPlayer extends Player {
    private Hand hand;
    private Integer bookNum = 0;

    public goFishPlayer(String name) {
        super(name, 20, 500.00);
        this.hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }
}
