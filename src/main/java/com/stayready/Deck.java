package com.stayready;
import com.stayready.Card;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;


    public Deck() {
        cards = new ArrayList<>();
        buildDeck();
    }

    private void buildDeck(){
        for(CardSuit suit: CardSuit.values()){
            for(CardValue value: CardValue.values()){
                //System.out.println(value.name + " of "+ suit.name);
                Card card = new Card(value, suit);
                cards.add(card);
            }
        }
    }

    public Card deal(Integer numberOfCards){
        return null;
    }

    public Integer cardsRemaining(){
        return cards.size();
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }


    //    private ArrayList<Card> cards;
//
//    public Deck() {
//        this.cards = new ArrayList<>();
//
//        String cardSuits[] = {"Spades", "Clubs", "Hearts", "Diamonds"};
//
//        for(String suit : cardSuits){
//            for(int i = 0; i < 13; i++){
//                Card tempCard = new Card(suit, i+1);
//                cards.add(tempCard);
//            }
//        }
//
//        shuffle((ArrayList<Card>) cards);
//    }
//
//    public static void shuffle(ArrayList<Card> cards) {
//        Collections.shuffle(cards);
//    }

}
