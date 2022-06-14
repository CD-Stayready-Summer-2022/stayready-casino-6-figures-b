package com.stayready.games;

import com.stayready.cards.Card;
import com.stayready.cards.CardPlayer;
import com.stayready.cards.CardValue;
import com.stayready.cards.Dealer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BlackjackTest {
    private Blackjack blackjack;
    private CardPlayer player;
    private Dealer dealer;

    @BeforeEach
    public void setUp(){
        player = new CardPlayer("Sabrina");
        dealer = new Dealer("Lucky Star Casino");
        blackjack = new Blackjack(player, dealer);
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
}
