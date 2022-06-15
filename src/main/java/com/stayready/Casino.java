package com.stayready;

import com.stayready.cards.Card;
import com.stayready.cards.CardValue;
import com.stayready.games.GoFish;

import java.util.Scanner;

import static com.stayready.cards.CardSuit.CLUBS;

public class Casino {
    private Scanner scanner;

    public Casino(){
        scanner = new Scanner(System.in);
    }

    public void start(){
        Player robot = new Player("🤖 AI 🤖");
        Player computer = new Player("👾 COMPUTER 👾");
        Player renato = new Player("🚀 Renato 🚀");
        GoFish goFish = new GoFish(renato, computer);
        goFish.botStartGame();
    }

    public static void main(String[] args) {
        new Casino().start();
    }
}
