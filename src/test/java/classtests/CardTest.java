package classtests;
import com.stayready.cards.Card;
import com.stayready.cards.CardSuit;
import com.stayready.cards.CardValue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CardTest {
    @Test
    @DisplayName("constructor test")
    public void constructorTest01(){
        Card card = new Card(CardValue.ACE, CardSuit.SPADES);
        String expected = "+--------+\n|        |\n|        |\n| Spades |\n|        |\n|   Ace  |\n|        |\n+--------+";
        String actual = card.toString();
        System.out.println(expected+"\n"+actual);
        Assertions.assertEquals(expected,actual);


    }



}
