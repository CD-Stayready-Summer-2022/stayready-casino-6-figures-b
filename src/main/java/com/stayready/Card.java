package com.stayready;

import java.util.ArrayList;
import java.util.List;

public class Card {

    private String suit;
    private Integer value;

    public Card(String suit, Integer value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public Integer getValue() {
        return value;
    }

    public void seValue(Integer value) {
        this.value = value;

    }
    @Override
    public String toString() {
        return suit+":"+value;
    }
}
