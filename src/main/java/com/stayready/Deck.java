package com.stayready;
import java.util.ArrayList;
import java.util.Collections;

public class Deck implements CardManager{
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        buildDeck();
    }

    void buildDeck(){
        for(CardSuit suit: CardSuit.values()){
            for(CardValue value: CardValue.values()){
                Card card = new Card(value, suit);
                cards.add(card);
            }
        }
    }

//    public ArrayList deal(Integer numberOfCards){
////        for(int i=0;i <numberOfCards;i++){
////            int pos = cards.size()-1;
////            card = cards.get(pos);
////            hand.add();
////            cards.remove(pos);
////        }
//        return null;
//    }

    public Integer cardsRemaining(){
        return cards.size();
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
    }

    @Override
    public Card removeCard(int cardIndex) {
        Card card = new Card(cards.get(cardIndex).getValue(),cards.get(cardIndex).getSuit());
        cards.remove(cardIndex);
        return card;
    }

}
