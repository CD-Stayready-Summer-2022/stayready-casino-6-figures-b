//package classtests;
//import com.stayready.Card;
//import org.junit.jupiter.api.Test;
//import  org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//
//
//
//public class CardsTest {
//    @Test
//    @DisplayName("Test for Card value input")
//    public void CardFaceValue01() {
//
//        //Given
//        Card King = new Card("King: ", 10);
//        //when
//        String expected = "King: 10";
//        String suit = King.getSuit();
//        Integer value = King.getValue();
//        //then
//        String actual = String.format("%s%d", suit, value);
//        Assertions.assertEquals(expected,actual);
//    }
//    @Test
//    @DisplayName("Test for numbered Cards")
//    public void CardNumberValue02(){
//        Card SevenHeart = new Card("SevenHeart: ", 7);
//        String expected = "SevenHeart: 7";
//        String suit = SevenHeart.getSuit();
//        Integer value = SevenHeart.getValue();
//        String actual = String.format("%s%d",suit,value );
//        Assertions.assertEquals(expected,actual);
//    }
//
//
//}
