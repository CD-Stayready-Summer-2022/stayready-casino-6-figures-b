package com.stayready.games;

import com.stayready.cards.goFishPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GoFishTest {

    private GoFish goFish;
    private goFishPlayer player1;
    private goFishPlayer player2;

    @BeforeEach
    public void setup(){
        player1 = new goFishPlayer("Jimmy Bones");
        player2 = new goFishPlayer("Tyra Banks");
        goFish = new GoFish(player1, player2);
    }

    @Test
    @DisplayName("Deal Test")
    public void dealTest01(){
        goFish.deal();
        Integer expectedNumberOfCards = 7;
        Integer actualNumberOfCards = player1.getHand().getCards().size();
        Assertions.assertEquals(expectedNumberOfCards, actualNumberOfCards);
    }

    @Test
    @DisplayName("")
    public void onlyAskHandTest01(){

    }

}
