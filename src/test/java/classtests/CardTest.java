package classtests;
import com.stayready.Card;
import com.stayready.CardSuit;
import com.stayready.CardValue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CardTest {
    @Test
    @DisplayName("constructor test")
    public void constructorTest01(){
        Card card = new Card(CardValue.ACE, CardSuit.SPADES);
        String expected = "Suit: Spades, Value: Ace";
        String actual = card.toString();
        Assertions.assertEquals(expected,actual);
    }

}
