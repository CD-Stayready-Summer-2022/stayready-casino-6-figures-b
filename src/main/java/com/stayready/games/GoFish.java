package com.stayready.games;
import com.stayready.Player;
import com.stayready.cards.*;

import java.util.*;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class GoFish extends CardGame {
    private final static Integer NUMBER_TO_DEAL = 7;
    private goFishPlayer player1;
    private goFishPlayer player2;
    private Scanner scanner;

    public GoFish(Player player1, Player player2) {
        this.player1 = (goFishPlayer) player1;
        this.player2 = (goFishPlayer) player2;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void startGame() {
        deal();
        while ((player1.getBookNum() + player2.getBookNum() < 13 - 1) && deck.cardsRemaining() != 0) {
            promptUserToPlay(player1);
            System.out.println("-----------------");
            promptUserToPlay(player2);
            System.out.println("-----------------");
        }
        System.out.println(String.format("%s has won the game!", (player1.getBookNum() >= player2.getBookNum())?player1.getName():player2.getName()));
    }


    public void promptUserToPlay(goFishPlayer player) {
        Hand hand = (player1.equals(player)) ? player1.getHand() : player2.getHand();
        Hand hand2 = (player1.equals(player)) ? player2.getHand() : player1.getHand();
//        System.out.println("Hand1: " + hand.toString());
//        System.out.println("Hand2: " + hand2.toString());

        System.out.println(String.format("%s it's your turn. Enter from the choices the card value are you looking for?", player.getName()));

        HashMap<CardValue, String> options = new HashMap<>();
        ArrayList<CardValue> valuesInHand = new ArrayList<>();
        for (Card card : player.getHand().getCards()) {
            if (!options.containsKey(card.getValue())) {
                options.put(card.getValue(), card.getValue().name);
                valuesInHand.add(card.getValue());
            }
        }

        System.out.println("Option\t\tCard Type\tQty in Hand");
        int i = 0;
        for (CardValue val : valuesInHand) {
            System.out.print(String.format("Press %d for %s", i++, val.name));
            if(val.getName().length() <= 3){
                System.out.println(String.format("\t\t\t%d", hand.getNumberOfCardsWithSpecificValue(val)));
            }else{
                System.out.println(String.format("\t\t%d", hand.getNumberOfCardsWithSpecificValue(val)));
            }
        }
        Integer input = scanner.nextInt();
        CardValue choice = valuesInHand.get(input);
        System.out.println("The value you're looking for is: " + choice.value);
        HashMap<CardValue, String> options2 = new HashMap<>();
        ArrayList<CardValue> valuesInHand2 = new ArrayList<>();
        for (Card card : hand2.getCards()) {
            if (!options2.containsKey(card.getValue())) {
                options2.put(card.getValue(), card.getValue().name);
                valuesInHand.add(card.getValue());
            }
        }

        if (options2.containsKey(choice)) {
            List<Card> removed = new ArrayList<Card>();
            for (Card element : hand2.getCards()) {
                if (element.getValue() == choice){
                    removed.add(element);
                    hand.giveCardToHand(element);
                }
            }
            hand2.getCards().removeAll(removed);
            System.out.format("You received %d %s cards from the other player./n", removed.size(), choice.name);
            if (isThereABook(hand, choice)) {
                //removeBook(hand, choice);
                player.setBookNum(player.getBookNum() + 1);
            }
            //Decision to keep same player next turn as they guessed correctly
            promptUserToPlay(player);
        }
        else{
            System.out.println("Go fish!");
            hand.giveCardToHand(deck.takeCardFromDeck());
            //method for checking 4ofkind
            if (isThereABook(hand, choice)) {
                removeBook(hand, choice);
                player.setBookNum(player.getBookNum() + 1);
            }
        }

    }

    public void deal(){
        for(int x =0 ; x < NUMBER_TO_DEAL +1; x++){
            Card card1 = deck.takeCardFromDeck();
            player1.getHand().giveCardToHand(card1);

            Card card2 = deck.takeCardFromDeck();
            player2.getHand().giveCardToHand(card2);
        }
    }

    public Boolean isThereABook(Hand hand, CardValue value){
        int counter = 0;
        for(Card card: hand.getCards()) {
            if (card.getValue() == value) {
                counter++;
            }
        }
        if(counter == 4) {
            return true;
        }
        return false;
    }

    public void removeBook(Hand hand, CardValue value){
        for (Card card : hand.getCards()) {
            if (card.getValue() == value) {
                hand.removeCardFromHand(card);
                break;
            }
        }
    }


    public goFishPlayer getPlayer1() {
        return player1;
    }

    public goFishPlayer getPlayer2() {
        return player2;
    }
    //    START GAME

import com.stayready.Card;
import com.stayready.Deck;
import com.stayready.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GoFish extends CardGame{

    private ArrayList<Player> players;
    private Player player1;
    private Player player2;

    public GoFish(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
    }

    @Override
    public void startGame() {
        Boolean hasGameEnded = false;
        while(!hasGameEnded){

        }

    }

    public void gameAlgo(){
        //    player and dealer each get hand(7 cards)


//    PLAYERS TURN
//    player goes first and must ask for a valid
//    card(value already in hand)
//
//    if dealer hand has the card(s)
//          it must give them to player
//          if the player has 4 of a suit of matching values
//              add 1 to 4-of-a-kind count
//            the player goes again
//    else
//         GO FISH
//         the player draws from deck/stock pile
//         if the player has 4 of a suit of matching values
//             add 1 to 4-of-a-kind count
//         else
//             next turn
//
//    DEALERS TURN
//
//    dealer goes next and must ask for a valid
//    card(value already in hand)
//
//    if player hand has the card(s)
//          it must give all of them to dealer
//          if the dealer has 4 of a suit of matching values
//              add 1 to 4-of-a-kind count
//            the player goes again
//    else
//         GO FISH
//         the delaer draws from deck/stock pile
//         if the dealer has 4 of a suit of matching values
//             add 1 to 4-of-a-kind count
//         else
//             next turn
//
////////// this repeats until drawPile is 1 cardRemaining /////////////
//
//            the players who's turn it is gets last card
//            and can ask for that value
//
//            whichever player at the end has the most
//            4-of-a-kind, WINS
//            the other LOSES.
//
//
//            ENDGAME
    }

    public void userPlayMenu(Player player){

    }


    public void dealCards(Integer numCards){
        for(int i = 0; i < numCards; i++){
            Card tempCard1 = deck.removeCard(0);
            player1.getHand().addCard(0, tempCard1);

            Card tempCard2 = deck.removeCard(0);
            player2.getHand().addCard(0, tempCard2);
        }
    }
}