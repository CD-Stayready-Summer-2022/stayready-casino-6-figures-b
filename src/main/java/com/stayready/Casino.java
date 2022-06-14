package com.stayready;

import com.stayready.cards.Card;
import com.stayready.cards.CardValue;
import com.stayready.cards.goFishPlayer;
import com.stayready.games.GoFish;

import java.util.Scanner;

import static com.stayready.cards.CardSuit.CLUBS;

public class Casino {
    private Scanner scanner;

    public Casino(){
        scanner = new Scanner(System.in);
    }

    public void start(){

        Card card1 = new Card(CardValue.TEN, CLUBS);

        System.out.println("Player 1 whats is your name?");
        String name1 = scanner.next();
        //System.out.println("Player 2 whats is your name?");
        String name2 = "AI";
        GoFish goFish = new GoFish(new goFishPlayer(name1), new goFishPlayer(name2));
        goFish.startGame();
    }

    public static void main(String[] args) {
        new Casino().start();
    }
}
