package classtests;

import com.stayready.cards.Card;
import com.stayready.cards.CardSuit;
import com.stayready.cards.CardValue;
import com.stayready.cards.Hand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

public class HandTest2 {
    private Hand hand;
    private Card card1;
    private Card card2;
    private Card card3;

    @BeforeEach
    public void setUp(){
        hand = new Hand();
        card1 = new Card(CardValue.ACE, CardSuit.SPADES);
        card2 = new Card(CardValue.FIVE, CardSuit.HEARTS);
        card3 = new Card(CardValue.FOUR, CardSuit.CLUBS);
    }

    @Test
    @DisplayName("Constructor test")
    public void constructorTest01(){
        Integer expectedSize = 0;
        ArrayList<Card> cards = hand.getCards();
        Assertions.assertNotNull(cards);
        Assertions.assertEquals(expectedSize, cards.size());
    }

    @Test
    @DisplayName("Give Card to Hand")
    public void giveCardToHandTest01(){
        Integer expectedSize = 1;
        hand.giveCardToHand(card1);
        Integer actualSize = hand.getCards().size();
        Assertions.assertEquals(expectedSize, actualSize);
    }

    @Test
    @DisplayName("Is Card in Hand")
    public void cardIsInHandTest01(){
        hand.giveCardToHand(card1);
        Boolean actual = hand.cardIsInHand(card1);
        Assertions.assertTrue(actual);
    }

    @Test
    @DisplayName("Is Not Card in Hand")
    public void cardIsInHandTest02(){
        hand.giveCardToHand(card1);
        Boolean actual = hand.cardIsInHand(card2);
        Assertions.assertFalse(actual);
    }

    @Test
    @DisplayName("Get Card from hand")
    public void getCardFromHandTest01(){
        hand.giveCardToHand(card1);
        Card expected = card1;
        Card actual = hand.removeCardFromHand(card1);
        Assertions.assertEquals(expected, actual);
        Assertions.assertFalse(hand.cardIsInHand(card1));
    }
}
