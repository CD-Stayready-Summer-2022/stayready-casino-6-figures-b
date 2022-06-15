package com.stayready.games;

import com.stayready.Casino;
import com.stayready.cards.*;

import java.util.Scanner;

public class Blackjack extends CardGame {
    private final static Integer NUMBER_TO_DEAL = 2;
    private final Hand pHand;
    private final Hand dHand;
    private BlackJackPlayer player;
    private Dealer dealer;
    private Scanner scanner;
    Double increasedBet;
    private Integer autoWin = 0;
    private Integer sum = 0;
    private Integer dealSum = 0;
    private int playerCardValue = 0;
    private int dealerCardValue = 0;
    private int pCountAces = 0;
    private int dCountAces = 0;

    public Blackjack(BlackJackPlayer player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
        this.pHand = player.getHand();
        this.dHand = dealer.getHand();
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
        System.out.println(balance);
        return balance;
    }

    public Double winBet(Double increasedBet){
        Double balance = player.getMoney();
        balance += (5.00 + increasedBet)*2;
        player.setMoney(balance);
        System.out.println(balance);
        return balance;
    }

    public void deal() {
        for (int i = 0; i < NUMBER_TO_DEAL; i++) {
            Card card1 = deck.takeCardFromDeck();
            pHand.giveCardToHand(card1);

            Card card2 = deck.takeCardFromDeck();
            dHand.giveCardToHand(card2);
        }
    }

    //can't test? because the cards randomize each run
    //find another way to test method...
    public boolean checkForNaturalBlackjack() {
        boolean isNaturalBlackjack = false;
        for (int i = 0; i < 2; i++) {
            playerCardValue = pHand.getCards().get(i).getValue().value;
            sum += playerCardValue;
            dealerCardValue = dHand.getCards().get(i).getValue().value;
            dealSum += dealerCardValue;

            if (sum < 21) {
                isNaturalBlackjack = false;
            } else if (sum == 21) {
                isNaturalBlackjack = true;
                if (dealSum < 21) {
                    autoWin = 1;
                } else if (dealSum == 21) {
                    autoWin = 0;
                } else {
                    autoWin = 2;
                }
            }

        }
        return isNaturalBlackjack;
    }

    public String playerHandOutput(){
        String playerHand = pHand.getCards().toString();
        return playerHand;
    }

    public String dealerHandOutput(int choice) {
        String dealerHand = "";
        switch (choice) {
            case 0:
                dealerHand = dHand.getCards().get(0).toString();
                break;
            case 1:
                dealerHand = dHand.getCards().toString();
                break;
        }
        return dealerHand;
    }

    public Integer playerHandSum(){
        for (int i = 0 ; i < 1; i++) {
            playerCardValue += pHand.getCards().get(i).getValue().value;
        }
        return playerCardValue;
    }

    public Integer dealerHandSum(){
        for (int i = 0 ; i < 1; i++) {
            dealerCardValue += dHand.getCards().get(i).getValue().value;
        }
        return dealerCardValue;
    }

    //can't test? because the cards randomize each run
    //find another way to test method...
    public int playerCountAces(){
        for (int i = 0 ; i < pHand.getCards().size(); i++){
            int tempValue = pHand.getCards().get(i).getValue().value;
            if (tempValue==11){
                pCountAces++;
            }
        }
        return pCountAces++;
    }

    public int dealerCountAces(){
        for (int i = 0 ; i < dHand.getCards().size(); i++){
            int tempValue = dHand.getCards().get(i).getValue().value;
            if (tempValue==11) {
                dCountAces++;
            }
        }
        return dCountAces;
    }

    public int pAceSum(){
        int tempSum;
        pCountAces = playerCountAces();

        if (pCountAces > 1){
            tempSum = (pCountAces-1) * 10;
            playerCardValue -= tempSum;
        }
        return playerCardValue;
    }

    public int dAceSum(){
        int tempSum;
        dCountAces = dealerCountAces();

        if (dCountAces > 1){
            tempSum = (dCountAces-1) * 10;
            dealerCardValue -= tempSum;
        }
        return dealerCardValue;
    }

    //can't test? because the cards randomize each run
    //find another way to test method...
    public Boolean playerIsBust(){
        Boolean pIsBust = false;
        pAceSum();
        if (playerHandSum()>21){
            pIsBust = true;
        } else if (playerHandSum()<=21) {
            pIsBust=false;
        }
        return pIsBust;
    }

    public Boolean dealerIsBust(){
        Boolean dIsBust = false;
        dAceSum();
        if (dealerHandSum()>21){
            dIsBust = true;
        } else if (dealerHandSum()<=21) {
            dIsBust=false;
        }
        return dIsBust;
    }

    public void playerHitOrStand () {
        System.out.println("Press 0 for hit.\nPress 1 for stand.");
        Integer input = scanner.nextInt();
        if (input == 0){
            System.out.println("You chose hit.");
            Card card1 = deck.takeCardFromDeck();
            pHand.giveCardToHand(card1);
            System.out.println("Players hand"+playerHandOutput());
            System.out.println("Dealers hand"+dealerHandOutput(0));
            if (!playerIsBust()){
                playerHitOrStand();
            }
            else{
                System.out.println("Your hand busts and you lose! Try again!");
                System.out.println("Players hand" + playerHandOutput());
                System.out.println("Dealers hand"+dealerHandOutput(1));
            }
        }
        else if (input == 1){
            System.out.println("You chose stand. Dealers turn!");
        }
    }

    public void dealerAlgorithm(){
        if (dealerHandSum()<17){
            System.out.println("Dealers hand: "+dealerHandOutput(1));
            System.out.println("Dealer hit.");
            Card card1 = deck.takeCardFromDeck(); //hit
            dHand.giveCardToHand(card1);
            if (dealerIsBust()){
                System.out.println("House busts!\nGame over.");
                System.out.println("Players hand" + playerHandOutput());
                System.out.println("Dealers hand"+dealerHandOutput(1));
                findWinner();
            } else if (!dealerIsBust()) {
                dealerAlgorithm();
            }
        }
        else if (dealerHandSum()>=17){
            System.out.println("Dealer stood.\nLet's reveal the hands!");
            System.out.println("Players hand" + playerHandOutput());
            System.out.println("Dealers hand"+dealerHandOutput(1));
            findWinner();
        }
    }

    public void findWinner(){
        Integer playerSum = playerHandSum();
        Integer dealerSum = dealerHandSum();

        if (playerSum>dealerSum){
            String msg = String.format("Congratulations %s! You have won this round.", player.getName());
            System.out.println(msg);
            winBet(increasedBet);
            System.out.println(player.getMoney());
        }
        else if (playerSum<dealerSum){
            String msg = String.format("Unfortunately you have lost, and this round goes to the house. Try again!");
            System.out.println(msg);
            System.out.println(player.getMoney());
        }
        else if (playerSum==dealerSum){
            String msg = String.format("The round ends in a push, %s and %s both have %s and have drawn."
                    , player.getName(), dealer.getName(), playerSum);
            System.out.println(msg);
            returnBet(increasedBet);
            System.out.println(player.getMoney());
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
            if (!checkForNaturalBlackjack()) {
                playerHitOrStand();
                dealerAlgorithm();
            } else if (checkForNaturalBlackjack()) {
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
}
