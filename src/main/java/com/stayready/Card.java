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
    //    private String suit;
//    private Integer value;
//
//    public Card(String suit, Integer value) {
//        this.suit = suit;
//        this.value = value;
//    }
//
//    public String getSuit() {
//        return suit;
//    }
//
//    public void setSuit(String suit) {
//        this.suit = suit;
//    }
//
//    public Integer getValue() {
//        return value;
//    }
//
//    public void seValue(Integer value) {
//        this.value = value;
//
//    }
}
