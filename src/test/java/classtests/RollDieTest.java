package classtests;

import com.stayready.craps.CrapsPlayer;
import com.stayready.craps.Craps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RollDieTest {


    @Test
    @DisplayName("Constructor Test")
    public void constructorTest(){

        CrapsPlayer player = new CrapsPlayer("David",21,2000.0);
       Craps rolldie = new Craps();
       Integer actual = rolldie.RollDie();
    }
}
