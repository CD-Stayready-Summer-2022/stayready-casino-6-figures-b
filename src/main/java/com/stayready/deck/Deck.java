package com.stayready.deck;
import com.stayready.cards.Card;
import com.stayready.cards.CardSuit;
import com.stayready.cards.CardValue;
import java.util.ArrayList;
import java.util.Collections;

public class Deck{
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

    public Card takeCardFromDeck(){
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}
