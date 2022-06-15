package com.stayready.games;

import com.stayready.Casino;
import com.stayready.cards.*;

import java.util.Scanner;

public class Blackjack extends CardGame {
    private final static Integer NUMBER_TO_DEAL = 2;
    private BlackJackPlayer player;
    private Dealer dealer;
    private Scanner scanner;
    Double increasedBet;
    private Integer autoWin = 0;
    private Integer sum = 0;
    private Integer dealSum = 0;
    private Boolean checkBJ = null;
    private int playerCardValue = 0;
    private int dealerCardValue = 0;
    private int pCountAces = 0;
    private int dCountAces = 0;

    public Blackjack(BlackJackPlayer player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
        this.scanner = new Scanner(System.in);
    }


    public Boolean checkAgeForGambling(){
        Boolean canPlay;
        int playerAge = player.getAge();
        if (playerAge >= 21){
            canPlay = true;
        }
        else{
            canPlay = false;
        }
        return canPlay;
    }


    public Double bet(Double increasedBet){
        Double balance = player.getMoney();
        balance -= 5.00; //5.00 per round of BJ
        if (increasedBet > 0.00){
            balance -= increasedBet;
        }
        player.setMoney(balance);
        return balance;
    }

    public Double returnBet(Double increasedBet){
        Double balance = player.getMoney();
        balance += 5.00 + increasedBet;
        player.setMoney(balance);
        return balance;
    }

    public Double winBet(Double increasedBet){
        Double balance = player.getMoney();
        balance += (5.00 + increasedBet)*2;
        player.setMoney(balance);
        return balance;
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
        for (int i = 0; i < player.getHand().getCards().size(); i++) {
            playerCardValue = player.getHand().getCards().get(i).getValue().value;
            sum = sum + playerCardValue;
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

    public String dealerHandOutput(int choice) {
        String dealerHand = null;
        switch (choice) {
            case 0:
                dealerHand = dealer.getHand().getCards().get(0).toString();
                break;
            case 1:
                dealerHand = dealer.getHand().getCards().toString();
                break;
        }
        return dealerHand;
    }

    public Integer playerHandSum(){
        for (int i = 0 ; i < 2; i++) {
            playerCardValue = playerCardValue + player.getHand().getCards().get(i).getValue().value;
        }
        return playerCardValue;
    }

    public Integer dealerHandSum(){
        for (int i = 0 ; i < dealer.getHand().getCards().size(); i++) {
            dealerCardValue = dealerCardValue + dealer.getHand().getCards().get(i).getValue().value;
        }
        return dealerCardValue;
    }

    //can't test? because the cards randomize each run
    //find another way to test method...
    public int playerCountAces(){
        for (int i = 0 ; i < 2; i++){
            int tempValue = player.getHand().getCards().get(i).getValue().value;
            if (tempValue==11){
                pCountAces++;
            }
        }
        return pCountAces++;
    }

    public int dealerCountAces(){
        for (int i = 0 ; i < dealer.getHand().getCards().size(); i++){
            int tempValue = dealer.getHand().getCards().get(i).getValue().value;
            if (tempValue==11) {
                dCountAces++;
            }
        }
        return dCountAces;
    }

    //can't test? because the cards randomize each run
    //find another way to test method...
    public Boolean checkForBust(){
        playerCountAces();
        dealerCountAces();
        Boolean bustChk = null;
        if (playerHandSum() > 21){
            if (pCountAces > 1){
                playerCardValue = playerHandSum() - 10;
                checkForBust();
            }
            System.out.println("Player has bust, whoever is the closest to 21 without going over now wins\nCALCULATING...");
            bustChk = true;
            findWinner();
        }else if (dealerHandSum()>21){
            if (dCountAces > 1){
                dealerCardValue = playerHandSum() - 10;
                checkForBust();
            }
            System.out.println("House has bust, whoever is the closest to 21 without going over now wins\nCALCULATING...");
            bustChk = true;
            findWinner();
        } else {
            bustChk = false;
        }
        return bustChk;
    }

    public void playerHitOrStand () {
        System.out.println("Press 0 for hit.\nPress 1 for stand.");
        Integer input = scanner.nextInt();
        if (input == 0){
            System.out.println("You chose hit.");
            Card card1 = deck.takeCardFromDeck();
            player.getHand().giveCardToHand(card1);
            System.out.println("Players hand"+playerHandOutput());
            System.out.println("Dealers hand"+dealerHandOutput(0));
            if (!checkForBust()){
                playerHitOrStand();
            }
            else{
                System.out.println("Your hand busts and you lose! Try again!");
            }
        }
        else if (input == 1){
            System.out.println("You chose stand. Dealers turn!");
            dealerAlgorithm();
        }
    }

    public void dealerAlgorithm(){
        if (dealerHandSum()<17){
            System.out.println("Dealer hit.");
            Card card1 = deck.takeCardFromDeck(); //hit
            dealer.getHand().giveCardToHand(card1);
            checkForBust();
        }
        else if (dealerHandSum()>17 && !checkForBust()){
            System.out.println("Dealer stood.\nLet's reveal the hands!");
            System.out.println("Players hand" + playerHandOutput());
            System.out.println("Dealers hand"+dealerHandOutput(1));
            findWinner();
        }
    }

    public void findWinner(){
        Integer playerSum = playerHandSum();
        Integer dealerSum = dealerHandSum();

        if (playerSum>dealerSum && !checkForBust()){
            String msg = String.format("Congratulations %s! You have won this round.", player.getName());
            System.out.println(msg);
            winBet(increasedBet);
        }
        else if (playerSum<dealerSum){
            String msg = String.format("Unfortunately you have lost, and this round goes to the house. Try again!");
            System.out.println(msg);
        }
        else if (playerSum==dealerSum){
            String msg = String.format("The round ends in a push, %s and %s both have %s and have drawn."
                    , player.getName(), dealer.getName(), playerSum);
            System.out.println(msg);
            returnBet(increasedBet);
        }
        else{
            String msg = String.format("%s, [Lucky Star ☆] apologizes as a technical error has occurred." +
                    " Please try again later.", player.getName());
            System.out.println(msg);
        }
    }

        @Override
    public void startGame() {
        checkAgeForGambling();
        if (checkAgeForGambling()) {
            System.out.println("Welcome to Blackjack!\nEach round costs $5.00" +
                    " to participate but you can risk more, if you dare," +
                    " and double it all!\nPlease enter an integer of how much you " +
                    "want to bet.\nYou can also bet 0.00!");
            increasedBet = scanner.nextDouble();
            bet(increasedBet);
            deal();
            System.out.println("Your cards: " + playerHandOutput());
            System.out.println("Dealer revealed card: " + dealerHandOutput(0));

            if (checkForNaturalBlackjack() == false) {
                playerHitOrStand();
            } else if (checkForNaturalBlackjack() == true) {
                switch (autoWin) {
                    case 0:
                        String msg = String.format("The round ends in a push, " +
                                        "%s and %s both have blackjack and have drawn."
                                , player.getName(), dealer.getName());
                        System.out.println(msg);
                        returnBet(increasedBet);
                        break;
                    case 1:
                        String msg2 = String.format("Congratulations %s! You have won " +
                                "this round.", player.getName());
                        System.out.println(msg2);
                        winBet(increasedBet);
                        break;
                    case 2:
                        String msg3 = String.format("%s, [Lucky Star ☆] apologizes as a " +
                                "technical error has occurred." +
                                " Please try again later.", player.getName());
                        System.out.println(msg3);
                        returnBet(increasedBet);
                        break;
                }
            } else {
                System.out.println("A technical error occurred with the game, " +
                        "try again later :)");
                returnBet(increasedBet);
            }
        }
        else{
            System.out.println("You are too young to gamble, sorry!");
            Casino.main();
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
