package classtests;
import com.stayready.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    @DisplayName("constructor test")
    public void constructorTest00(){
        Player player = new Player("Renato", 26, 20.20);

        Player actual = player;

        Assertions.assertNotNull(actual);

    }

    @Test
    @DisplayName("constructor test")
    public void constructorTest01(){
        Player expected = new Player("Sabrina", 20, 500.00);

        String name = "Sabrina";
        Integer age = 20;
        Double money = 500.00;

        Player player = new Player(name, age, money);

        Player actual = player;

        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    @DisplayName("getter test")
    public void getterTest00(){
        Player expected = new Player("Sabrina", 20, 500.00);

        Player player = new Player("Sabrina", 20, 500.00);
        String name = player.getName();

        Player actual = player;

        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    @DisplayName("setter test")
    public void setterTest00(){
        Player expected = new Player("Sabrina", 20, 500.00);

        Player player = new Player("x", 20, 500.00);
        String name = player.getName();

        player.setName("Sabrina");

        name = player.getName();

        Player actual = player;

        Assertions.assertEquals(expected.toString(), actual.toString());
    }
}
