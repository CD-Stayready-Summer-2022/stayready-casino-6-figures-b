package classtests;

import com.stayready.Card;
import com.stayready.Deck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeckTest {

    @Test
    @DisplayName("Deck Constructor Test")
    public void constructorTest01(){
        //Given
        Deck deck = new Deck();
        for(Card tempCard : deck){
            String tempStr = String.format("%s %d", deck)
            System.out.println();
        }

        //When


        //Then
    }

}
