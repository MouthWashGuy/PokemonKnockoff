package pokemongame.customcollections;

import java.util.Collection;

public class PokemonMoveList<E> extends LimitedArrayList<E> {

    private static final int MAXIMUM_MOVES = 4;

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public PokemonMoveList() {
        super(MAXIMUM_MOVES);
    }

    public PokemonMoveList(E[] array) {
        super(MAXIMUM_MOVES, array);
    }

    public PokemonMoveList(Collection<? extends E> c) {
        super(MAXIMUM_MOVES, c);
    }
}
