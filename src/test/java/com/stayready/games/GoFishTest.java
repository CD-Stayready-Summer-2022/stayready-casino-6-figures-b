package com.stayready.games;

import com.stayready.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GoFishTest {

    private GoFish goFish;
    private Player player1;
    private Player player2;

    @BeforeEach
    public void setup(){
        player1 = new Player("Jimmy Bones");
        player2 = new Player("Tyra Banks");
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
