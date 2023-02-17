package pokemongame;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import pokemongame.typing.PokeType;
import pokemongame.typing.PokeType.ALL_TYPES;;

public class PokeTypeTest {

    @Test
    public void testEffectiveness() {

        ALL_TYPES[] vaporeon = {ALL_TYPES.Water};
        ALL_TYPES[] charmander = {ALL_TYPES.Fire};
        ALL_TYPES[] caterpie = {ALL_TYPES.Bug};
        ALL_TYPES[] pidgey = {ALL_TYPES.Flying, ALL_TYPES.Normal};
        ALL_TYPES[] ekans = {ALL_TYPES.Poison};
        ALL_TYPES[] paras = {ALL_TYPES.Bug, ALL_TYPES.Grass};
        ALL_TYPES[] mankey = {ALL_TYPES.Fighting};
        ALL_TYPES[] abra = {ALL_TYPES.Psychic};
        ALL_TYPES[] geodude = {ALL_TYPES.Ground, ALL_TYPES.Rock};
        ALL_TYPES[] magnemite = {ALL_TYPES.Electric, ALL_TYPES.Steel};
        ALL_TYPES[] ghastly = {ALL_TYPES.Ghost, ALL_TYPES.Poison};
        ALL_TYPES[] hydreigon = {ALL_TYPES.Dark, ALL_TYPES.Dragon};
        ALL_TYPES[] mrRime = {ALL_TYPES.Ice, ALL_TYPES.Psychic};
        ALL_TYPES[] sylveon = {ALL_TYPES.Fairy};

       ALL_TYPES[][] pokemonArr = {vaporeon, charmander, caterpie, pidgey, ekans, paras, mankey, abra, geodude, magnemite, ghastly, hydreigon, mrRime, sylveon};
       List<Double> results = new ArrayList<Double>();

        // testing grass moves
        for (ALL_TYPES[] pokemon: pokemonArr) {
            results.add(PokeType.calculateEffectiveness(ALL_TYPES.Grass, pokemon));
        }
        assertThat(results, contains(2.0, 0.5, 0.5, 0.5, 0.5, 0.25, 1.0, 1.0, 4.0, 0.5, 0.5, 0.5, 1.0, 1.0));
        results.clear();

        // testing fire moves
        for (ALL_TYPES[] pokemon: pokemonArr) {
            results.add(PokeType.calculateEffectiveness(ALL_TYPES.Fire, pokemon));
        }
        assertThat(results, contains(0.5, 0.5, 2.0, 1.0, 1.0, 4.0, 1.0, 1.0, 0.5, 2.0, 1.0, 0.5, 2.0, 1.0));
        results.clear();

        // testing nomal moves
        for (ALL_TYPES[] pokemon: pokemonArr) {
            results.add(PokeType.calculateEffectiveness(ALL_TYPES.Normal, pokemon));
        }
        assertThat(results, contains(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 0.5, 0.0, 1.0, 1.0, 1.0));
        results.clear();

        // testing water moves
        for (ALL_TYPES[] pokemon: pokemonArr) {
            results.add(PokeType.calculateEffectiveness(ALL_TYPES.Water, pokemon));
        }
        assertThat(results, contains(0.5, 2.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 4.0, 1.0, 1.0, 0.5, 1.0, 1.0));
        results.clear();
    }
}
