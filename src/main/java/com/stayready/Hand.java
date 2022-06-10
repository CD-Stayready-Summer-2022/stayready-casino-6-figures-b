package com.stayready;

import java.util.ArrayList;
import com.stayready.Card;

public class Hand extends Deck {
    private ArrayList<Card> cards;
    private int cardIndex;


    public void addCard(){

        //cards.add(new Card(suit, Integer value));

    }

    public void removeCard(int cardIndex){
        this.cardIndex = cardIndex;
        cards.remove(cardIndex);
    }
}
