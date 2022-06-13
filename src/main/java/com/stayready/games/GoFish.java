package com.stayready.games;
import com.stayready.Player;
import com.stayready.cards.*;

import java.util.*;

public class GoFish extends CardGame {
    private final static Integer NUMBER_TO_DEAL = 7;
    private CardPlayer player1;
    private CardPlayer player2;
    private Scanner scanner;

    public GoFish(CardPlayer player1, CardPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void startGame() {
        //boolean gameOver = false;
        deal();
        while(player1.getCountFour() + player2.getCountFour() < 13){
            promptUserToPlay(player1);
            System.out.println("-----------------");
            promptUserToPlay(player2);
            System.out.println("-----------------");
        }
    }

    public void promptUserToPlay(Player player){ //turn""
        Hand hand = (player1.equals(player))? player2.getHand() : player1.getHand();
        String msg = String.format("Hey, %s what card value are you looking for?", player.getName());
        System.out.println(msg);
        int x = 0;
        String msg2 = "";
        for (CardValue value: CardValue.values()) {
            msg2 = String.format("Press %d for %s", x, value.name);
            System.out.println(msg2);
            x++;
        }
        Integer input = scanner.nextInt();
        CardValue value = CardValue.values()[input];
        System.out.println("You selected " + value.name);

        if (hand.valueOfCardInHand(value)) {
            String msg3 = String.format("You received the card %s", value.name);
            System.out.println(msg3);

        } else {
            System.out.println("Go fish!");
            hand.giveCardToHand(deck.takeCardFromDeck());
        }
    }


    public void deal(){
        for(int x =0 ; x < NUMBER_TO_DEAL; x++){
            Card card1 = deck.takeCardFromDeck();
            player1.getHand().giveCardToHand(card1);

            Card card2 = deck.takeCardFromDeck();
            player2.getHand().giveCardToHand(card2);
        }
    }

    public CardPlayer getPlayer1() {
        return player1;
    }

    public CardPlayer getPlayer2() {
        return player2;
    }



//    START GAME

//    player and dealer each get hand(7 cards)
//
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