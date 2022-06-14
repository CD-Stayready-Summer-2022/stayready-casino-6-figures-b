package com.stayready.cards;

import java.util.*;

public class Hand {
    private ArrayList<Card> cards;

    public Hand(){
        this.cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Boolean valueOfCardInHand(CardValue value){
        for(Card card:cards){
            if(card.getValue().equals(value)){
                return true;
            }
        }
        return false;
    }

    public void giveCardToHand(Card card){
        cards.add(card);
    }

    public boolean cardIsInHand(Card card){
        return cards.contains(card);
    }

    public Card getCardFromHand(Card card){
        int indexOfCard = cards.indexOf(card);
        Card cardRemoved = cards.get(indexOfCard);
        cards.remove(indexOfCard);
        return cardRemoved;
    }

    @Override
    public String toString() {
        return "Hand: " + cards;
    }

    // only used for testing
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

}
