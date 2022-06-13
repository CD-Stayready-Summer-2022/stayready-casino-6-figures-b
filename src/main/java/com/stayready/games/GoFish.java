package com.stayready.games;

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