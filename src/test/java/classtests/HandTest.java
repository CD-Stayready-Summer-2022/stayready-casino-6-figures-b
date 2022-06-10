package classtests;
import com.stayready.*;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class HandTest {
    @Test
    @DisplayName("constructor test")
    public void constructorTest01(){
        Hand hand = new Hand();
        Hand actual = hand;

        Assertions.assertNotNull(actual);

    }

    @Test
    @DisplayName("add card to hand Test")
    public void addCardToHandTest(){
        Hand hand = new Hand();
        Card card = new Card(CardValue.ACE, CardSuit.SPADES);
        int index = 0;
        hand.addCard(index,card);
        String expected = "Hand{hand=[Suit: Spades, Value: Ace]}";
        String actual = hand.toString();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Remove card from hand test")
    public void removeCardFromHandTest(){
        Hand hand = new Hand();
        Card card = new Card(CardValue.ACE, CardSuit.SPADES);
        Card card2 = new Card(CardValue.KING, CardSuit.SPADES);
        int index = 0;
        int index2 = 0;
        hand.addCard(index,card);
        hand.addCard(index2,card2);
        hand.removeCard(0);

        String expected = "Hand{hand=[[Suit: Spades, Value: Ace]]}";
        String actual = hand.toString();

        Assertions.assertEquals(expected,actual);
    }


}
