package com.stayready.games;

import com.stayready.Player;
import com.stayready.cards.*;
import com.stayready.deck.Deck;

import java.util.Scanner;

public class Blackjack extends CardGame {
    private final static Integer NUMBER_TO_DEAL = 2;
    private CardPlayer player;
    private Dealer dealer;
    private Scanner scanner;
    private Integer autoWin = 0;

    public Blackjack(CardPlayer player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
        this.scanner = new Scanner(System.in);
    }

    public void deal() {
        for (int i = 0; i < NUMBER_TO_DEAL; i++) {
            Card card1 = deck.takeCardFromDeck();
            player.getHand().giveCardToHand(card1);

            Card card2 = deck.takeCardFromDeck();
            dealer.getHand().giveCardToHand(card2);

        }
    }

    //can't test? because the cards randomize each run
    //find another way to test method...
    public Boolean checkForNaturalBlackjack() {
        Integer sum = 0;
        Integer dealSum = 0;
        Boolean checkBJ = null;

        for (int i = 0; i < player.getHand().getCards().size(); i++) {
            CardValue playerCardValue = player.getHand().getCards().get(i).getValue();
            sum = sum + playerCardValue.value;
            if (sum < 21) {
                checkBJ = false;
            } else if (sum == 21) {
                for (int j = 0; j < dealer.getHand().getCards().size(); j++) {
                    CardValue dealerCardValue = dealer.getHand().getCards().get(j).getValue();
                    dealSum = dealSum + dealerCardValue.value;
                    if (dealSum < 21) {
                        autoWin = 1;
                    } else if (dealSum == 21) {
                        autoWin = 0;
                    } else {
                        autoWin = 2;
                    }
                }
                checkBJ = true;
            } else {
                checkBJ = null;
            }
        }
        return checkBJ;
    }

    public String playerHandOutput(){
        String playerHand = player.getHand().getCards().toString();
        return playerHand;
    }

    public String dealerHandOutput(){
        String dealerHand = dealer.getHand().getCards().get(0).toString();
        return dealerHand;
    }

    public void hitOrStand () {

    }

    @Override
    public void startGame() {
        deal();
        System.out.println("Your cards: "+playerHandOutput());
        System.out.println("Dealer revealed card: "+dealerHandOutput());

        if (checkForNaturalBlackjack()==false){
            hitOrStand();
        }
        else if (checkForNaturalBlackjack()==true){
            switch (autoWin){
                case 0:
                    String msg = String.format("The round ends in a push, %s and %s both have blackjack and have drawn."
                            , player.getName(), dealer.getName());
                    System.out.println(msg);
                    break;
                case 1:
                    String msg2 = String.format("Congratulations %s! You have won this round.", player.getName());
                    System.out.println(msg2);
                    break;
                case 2:
                    String msg3 = String.format("%s, [Lucky Star ☆] apologizes as a technical error has occurred." +
                            " Please try again later.", player.getName());
                    System.out.println(msg3);
                    break;
            }
        }
        else{
            System.out.println("A technical error occurred with the game, " +
                    "try again later :)");
        }
    }


    // win conditions:
    //    By drawing a hand value that is higher than the dealer’s hand value
    //    By the dealer drawing a hand value that goes over 21.
    //    By drawing a hand value of 21 on your first two cards, when the dealer does not.

    // lose conditions:
    //    Your hand value exceeds 21.
    //    The dealers hand has a greater value than yours at the end of the round

}
