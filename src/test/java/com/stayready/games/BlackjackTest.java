package com.stayready.games;

import com.stayready.Player;
import com.stayready.cards.BlackJackPlayer;
import com.stayready.cards.Dealer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BlackjackTest {
    private Blackjack blackjack;
    private BlackJackPlayer player;
    private Dealer dealer;

    @BeforeEach
    public void setUp(){
        player = new BlackJackPlayer("Sabrina",21,500.00);
        dealer = new Dealer("Lucky Star Casino");
        blackjack = new Blackjack(player, dealer);
        blackjack.deal();
    }

    @Test
    @DisplayName("FAIL Deal Test")
    public void dealTest01(){
        blackjack.deal();
        Integer expectedNumberOfCards = 0;
        Integer actualNumberOfCards = player.getHand().getCards().size();
        Assertions.assertNotEquals(expectedNumberOfCards, actualNumberOfCards);
    }

    @Test
    @DisplayName("PASS Deal Test")
    public void dealTest02(){
        blackjack.deal();
        Integer expectedNumberOfCards = 2;
        Integer actualNumberOfCards = player.getHand().getCards().size();
        System.out.println(player.getHand().getCards());
        Assertions.assertEquals(expectedNumberOfCards, actualNumberOfCards);
    }

    @Test
    @DisplayName("player hand output")
    //making sure there is something in player hand
    public void playerHandOutputTest01(){
        //System.out.println(blackjack.playerHandOutput());
        String actual = blackjack.playerHandOutput();
        Assertions.assertNotNull(actual);
    }

    @Test
    @DisplayName("dealer hand output")
    //making sure there is something in dealers hand
    public void dealerHandOutputTest01(){
        //System.out.println(blackjack.playerHandOutput());
        String actual = blackjack.dealerHandOutput(1);
        Assertions.assertNotNull(actual);
    }

    @Test
    @DisplayName("betting test!")
    public void betTest01(){
        Double expected = 485.0; //500 - 5 - 10 = 485
        Double actual = blackjack.bet(10.00);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("return bet test (draw/error)")
    public void betTest02(){
        blackjack.bet(10.00);//bet first then return
        Double expected = 500.00; //15.00 bet back to bal
        Double actual = blackjack.returnBet(10.00);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("double bet test(win)")
    public void betTest03(){
        blackjack.bet(10.00);
        Double expected = 515.00;
        Double actual = blackjack.winBet(10.00);
        Assertions.assertEquals(expected,actual);
    }

}
