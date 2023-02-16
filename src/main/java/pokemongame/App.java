package pokemongame;

import pokemongame.typing.*;
import pokemongame.typing.PokeType.ALL_TYPES;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ALL_TYPES[] gyrados = {ALL_TYPES.Water, ALL_TYPES.Flying};
        System.out.println(PokeType.calculateEffectiveness(ALL_TYPES.Electric, gyrados));
    }
}
