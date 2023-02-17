package pokemongame;

import static org.junit.Assert.*;
import org.junit.Test;
import pokemongame.typing.PokeType;
import pokemongame.typing.PokeType.ALL_TYPES;;

public class PokeTypeTest {

    @Test
    public void testEffectiveness() {

        // grass move on water type
        ALL_TYPES[] vaporeonTypes = {ALL_TYPES.Water};
        double actual = PokeType.calculateEffectiveness(ALL_TYPES.Grass, vaporeonTypes);
        assertEquals(2.0, actual, 0);

        //dark move on water type
        double actual2 = PokeType.calculateEffectiveness(ALL_TYPES.Dark, vaporeonTypes);
        assertEquals(1.0, actual2, 0);
    }
}
