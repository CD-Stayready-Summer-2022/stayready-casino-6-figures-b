package com.stayready.cards;

import java.util.*;

public class Hand {
    private List<Card> cards;

    public Hand(){
        this.cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return (ArrayList<Card>) cards;
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

    public Card removeCardFromHand(Card card){
        int indexOfCard = cards.indexOf(card);
        Card cardRemoved = cards.get(indexOfCard);
        cards.remove(indexOfCard);
        return cardRemoved;
    }

    public int getNumberOfCardsWithSpecificValue(CardValue value){
        int counter = 0;
        for (Card element : cards) {
            if (element.getValue() == value){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                '}';
    }
}
