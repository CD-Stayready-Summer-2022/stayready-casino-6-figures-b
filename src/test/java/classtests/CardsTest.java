package classtests;
import com.stayready.Card;
import org.junit.jupiter.api.Test;
import  org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;



public class CardsTest {
    @Test
    @DisplayName("Constructer Test")
    public void ConstructorTest01() {

        //Given
        Card card = new Card("King", 10);
        //when
        String expected = "King 10";
        String suit = card.getSuit();
        Integer value = card.getValue();
        //then
        String actual = String.format("%s %d", suit,value);
        Assertions.assertEquals(expected.toString(), actual.toString());
    }
    @Test
    @DisplayName("getter test")
    public void GetterTest02(){
        Card expected = new Card("King", 10);
        Card card = new Card("King", 10);
        String suit = card.getSuit();
        Integer value = card.getValue();
        Card actual = card;
        Assertions.assertEquals(expected.toString(), actual.toString());

    }
    @Test
    @DisplayName("setter test")
    public void setterTest00(){
        Card expected = new Card("Queen", 10);
        Card card = new Card("King", 10);
        String suit = card.getSuit();
        Integer value = card.getValue();

        card.setSuit("Queen");
        card.seValue(10);

        Card actual = card;
        Assertions.assertEquals(expected.toString(), actual.toString());

    }


}
