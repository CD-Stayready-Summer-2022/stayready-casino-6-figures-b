package com.stayready;
import java.util.ArrayList;
import java.util.Collections;

public class Deck implements CardManager{
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        buildDeck();
    }

    public void buildDeck(){
        for(CardSuit suit: CardSuit.values()){
            for(CardValue value: CardValue.values()){
                Card card = new Card(value, suit);
                cards.add(card);
            }
        }
    }

    public Integer cardsRemaining(){
        return cards.size();
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    @Override
    public Card removeCard(int cardIndex) {
        Card card = new Card(cards.get(cardIndex).getValue(),cards.get(cardIndex).getSuit());
        cards.remove(cardIndex);
        return card;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}
