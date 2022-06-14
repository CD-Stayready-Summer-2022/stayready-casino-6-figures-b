package com.stayready;

import com.stayready.cards.CardPlayer;
import com.stayready.cards.Dealer;
import com.stayready.games.Blackjack;
import com.stayready.games.GoFish;

import java.util.Scanner;

public class Casino {
    private Scanner scanner;

    public Casino(){
        scanner = new Scanner(System.in);
    }

    public void start(){
        String name2 = "[Lucky Star ☆] Casino";
        System.out.println("Hello player, welcome to the [Lucky Star ☆] Casino.\nWhat is your name?");
        String name1 = scanner.next();
        System.out.println("What game would you like to play?\n" +
                "Press 0 for Go Fish\n" +
                "Press 1 for Blackjack\n" +
                "Press 2 for Craps");
        String gameChoice = scanner.next();
        if (gameChoice.equals("0")){

            System.out.println("You chose go fish");
            GoFish goFish = new GoFish(new CardPlayer(name1), new CardPlayer(name2));
            goFish.startGame();
        }
        else if (gameChoice.equals("1")){
            System.out.println("You chose blackjack");
            Blackjack blackjack = new Blackjack(new CardPlayer(name1), new Dealer(name2));
            blackjack.startGame();
        }
        else if (gameChoice.equals("2")){
            System.out.println("You chose craps");
        }
        else{
            System.out.println("You must not know what you want to play," +
                    " try again :)");
            start();
        }

    }

    public static void main(String[] args) {
        new Casino().start();
    }
}
