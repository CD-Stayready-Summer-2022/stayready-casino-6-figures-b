package com.stayready;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {


    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();

        String cardSuits[] = {"Spades", "Clubs", "Hearts", "Diamonds"};

        for(String suit : cardSuits){
            for(int i = 0; i < 13; i++){
                Card tempCard = new Card(suit, i+1);
                cards.add(tempCard);
            }
        }

        shuffle((ArrayList<Card>) cards);
    }

    public static void shuffle(ArrayList<Card> cards) {
        Collections.shuffle(cards);
    }

}
