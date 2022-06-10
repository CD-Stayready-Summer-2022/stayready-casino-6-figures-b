package classtests;
import com.stayready.Card;
import com.stayready.CardSuit;
import com.stayready.CardValue;


import com.stayready.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeckTest {
    @Test
    @DisplayName("constructor test")
    public void constructorTest01(){
        Deck deck = new Deck();
        Integer expected = 52;
        Integer actual = deck.cardsRemaining();
        Assertions.assertEquals(expected,actual);
    }

}
