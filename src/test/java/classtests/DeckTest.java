package classtests;

import com.stayready.cards.Card;


import com.stayready.deck.Deck;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeckTest {
    @Test
    @DisplayName("Constructor test")
    public void constructorTest01(){
        //Given
        Deck deck = new Deck();
        //When
        Integer expected = 52;
        Integer actual = deck.cardsRemaining();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("RemoveCard Test")
    public void cardsRemainingTest01(){
        Deck deck = new Deck();
        Card card = deck.takeCardFromDeck();
        Integer expected = 51;
        Integer actual = deck.cardsRemaining();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Card Shuffle Test")
    public void cardShuffleTest01() {
        Deck deck = new Deck();
        Deck deck2 = new Deck();
        String unexpected = deck2.toString();

        deck.shuffle();
        String actual = deck.toString();

        Assertions.assertNotEquals(unexpected, actual);
    }


}
